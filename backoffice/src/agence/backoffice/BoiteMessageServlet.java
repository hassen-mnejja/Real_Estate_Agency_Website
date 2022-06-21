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
import agence.model.Message;

/**
 * Servlet implementation class BoiteMessageServlet
 */
public class BoiteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoiteMessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT mess_to_id,mess_from_id,mess_text,send_time,nom,prenom FROM MESSAGE M, CLIENT CL WHERE M.mess_from_id=CL.IDCLIENT AND mess_to_id=0 ORDER BY send_time DESC";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Message> listemessage = new ArrayList<Message>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("mess_from_id"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				Message message = new Message();
				message.setIdEnv(rs.getInt("mess_from_id"));
				message.setIdRec(0);
				message.setMess(rs.getString("mess_text"));
				message.setTemps(rs.getString("send_time"));
				message.setClient(client);
				listemessage.add(message);
			}
			request.setAttribute("listemessage", listemessage);
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
		request.getRequestDispatcher("/WEB-INF/boitemessage.jsp").forward(request, response);
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
		String idclient = request.getParameter("idclient");
		request.setAttribute("idclient", idclient);
		String datemin = request.getParameter("datemin");
		request.setAttribute("datemin", datemin);
		String datemax = request.getParameter("datemax");
		request.setAttribute("datemax", datemax);
		if (datemax == "")
			datemax = "2050-12-30T12:00";
		if (datemin == "")
			datemin = "1950-12-30T12:00";
		String req = "SELECT mess_to_id,mess_from_id,mess_text,send_time,nom,prenom FROM MESSAGE M, CLIENT CL WHERE M.mess_from_id=CL.IDCLIENT AND send_time BETWEEN '" + datemin + "' AND '" + datemax + "'";
		if (idclient != "") { req = req + " AND mess_from_id = " + idclient; }
		if (nom != "" && nom != null) { req = req + " AND UPPER(NOM) LIKE UPPER('%" + nom + "%')"; }
		if (prenom != "" && prenom != null) { req = req + " AND UPPER(PRENOM) LIKE UPPER('%" + prenom + "%')"; }
		req = req + " AND mess_to_id=0 ORDER BY send_time DESC";
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Message> listemessage = new ArrayList<Message>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("mess_from_id"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				Message message = new Message();
				message.setIdEnv(rs.getInt("mess_from_id"));
				message.setIdRec(0);
				message.setMess(rs.getString("mess_text"));
				message.setTemps(rs.getString("send_time"));
				message.setClient(client);
				listemessage.add(message);
			}
			request.setAttribute("listemessage", listemessage);
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
		request.getRequestDispatcher("/WEB-INF/boitemessage.jsp").forward(request, response);
	}

}
