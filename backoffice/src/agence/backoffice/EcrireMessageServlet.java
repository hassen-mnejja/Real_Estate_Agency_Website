package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.model.Client;

/**
 * Servlet implementation class EcrireMessageServlet
 */
public class EcrireMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EcrireMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("SELECT IDCLIENT,NOM,PRENOM FROM CLIENT");
			ArrayList<Client> clients = new ArrayList<Client>();
			while (rs1.next()) {
				Client cl = new Client();
				cl.setIdClient(rs1.getInt("IDCLIENT"));
				cl.setNom(rs1.getString("NOM"));
				cl.setPrenom(rs1.getString("PRENOM"));
				clients.add(cl);
			}
			request.setAttribute("clients", clients);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		request.getRequestDispatcher("/WEB-INF/messageecrire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idclient = request.getParameter("idclient");
		String message = request.getParameter("message");
		String temps = request.getParameter("temps");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO MESSAGE (mess_from_id,mess_to_id,mess_text,send_time) values (?,?,?,?)");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, Integer.parseInt(idclient));
			pstmt.setString(3, message);
			pstmt.setString(4, temps);
			pstmt.executeUpdate();
			response.sendRedirect("/backoffice/prive/conversation?identifiant=" + idclient);
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
	}
}
