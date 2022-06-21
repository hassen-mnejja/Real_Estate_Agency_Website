package agence.backoffice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimeAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimeAgentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idagent = request.getParameter("idagent");
		String req = "DELETE FROM AGENT WHERE IDAGENT=" + idagent;
		supprimevisite(idagent);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
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
		File path = new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Agent\\" + idagent + "\\");
		deleteFile(path);
		response.sendRedirect("/backoffice/prive/chercheragent");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	public static void deleteFile(File element) {
		if (element.exists()) { if (element.isDirectory()) { for (File sub : element.listFiles()) { deleteFile(sub); } } }
		element.delete();
	}

	private void supprimevisite(String idagent) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM VISITE WHERE IDAGENT=" + idagent;
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					System.out.println(e2.toString());
				}
			}
		}
	}

}
