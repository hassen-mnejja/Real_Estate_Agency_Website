package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class ChercherClientServlet
 */
public class ChercherClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChercherClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM CLIENT";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Client> listeclient = new ArrayList<Client>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				client.setNumtel(rs.getString("NUMTEL"));
				client.setEmail(rs.getString("EMAIL"));
				listeclient.add(client);
			}
			request.setAttribute("listeclient", listeclient);
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
		request.getRequestDispatcher("/WEB-INF/clientcherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		String numtel = request.getParameter("numtel");
		request.setAttribute("numtel", numtel);
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		String de = request.getParameter("de");
		request.setAttribute("de", de);
		String vers = request.getParameter("vers");
		request.setAttribute("vers", vers);
		if (de == "")
			de = "0";
		if (vers == "")
			vers = "1000";
		String req = "SELECT * FROM CLIENT WHERE IDCLIENT BETWEEN " + de + " AND " + vers;
		if (nom != "") { req = req + " AND UPPER(NOM) LIKE UPPER('%" + nom + "%')"; }
		if (prenom != "") { req = req + " AND UPPER(PRENOM) LIKE UPPER('%" + prenom + "%')"; }
		if (numtel != "" && numtel != null) { req = req + " AND NUMTEL LIKE '%" + numtel + "%'"; }
		if (email != "" && email != null) { req = req + " AND UPPER(EMAIL) LIKE UPPER('%" + email + "%')"; }
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Client> listeclient = new ArrayList<Client>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				client.setNumtel(rs.getString("NUMTEL"));
				client.setEmail(rs.getString("EMAIL"));
				listeclient.add(client);
			}
			request.setAttribute("listeclient", listeclient);
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
		request.getRequestDispatcher("/WEB-INF/clientcherche.jsp").forward(request, response);
	}

}
