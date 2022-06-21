package agence.backoffice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class AjoutClientServlet
 */
public class AjoutClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/clientajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idclient = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			idclient = last();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO CLIENT (NOM,PRENOM,EMAIL,PASSWORD,NUMTEL) values (?,?,?,?,?)");
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (!isMultipartContent) { return; }
			ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			try {
				List<FileItem> fields = upload.parseRequest(request);
				Iterator<FileItem> it = fields.iterator();
				if (!it.hasNext())
					return;
				int i = 0;
				while (it.hasNext()) {
					FileItem fileItem = it.next();
					boolean isFormField = fileItem.isFormField();
					if (isFormField) {
						String name = fileItem.getFieldName();
						String value = fileItem.getString("UTF-8");
						System.out.println(name + " : " + value);
						switch (name) {
						case "nom":
							pstmt.setString(1, value);
						case "prenom":
							pstmt.setString(2, value);
						case "email":
							pstmt.setString(3, value);
						case "password":
							pstmt.setString(4, value);
						case "numtel":
							pstmt.setString(5, value);
						}

					} else if (fileItem.getSize() > 0) {
						// String fileNameSuffix = "." + FilenameUtils.getExtension(fileItem.getName());
						File path = new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Client\\" + idclient + "\\");
						if (!path.exists()) { path.mkdirs(); }
						i = i + 1;
						fileItem.write(new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Client\\" + idclient + "\\" + idclient + "-" + i + ".jpg"));
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			pstmt.executeUpdate();
			request.setAttribute("idclient", idclient);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}

		response.sendRedirect("/backoffice/prive/chercherclient");
	}

	int last() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"agence\" AND TABLE_NAME = \"CLIENT\"");
			if (rs.next()) {
				return rs.getInt(1);
			} else
				return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

}
