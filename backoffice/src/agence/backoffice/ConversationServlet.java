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
 * Servlet implementation class ConversationServlet
 */
public class ConversationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConversationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		int id = Integer.parseInt(identifiant);
		String req = "SELECT mess_to_id,mess_from_id,mess_text,send_time FROM MESSAGE  WHERE (mess_to_id=" + id + " OR mess_from_id=" + id + ") ORDER BY send_time DESC";
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
				Message message = new Message();
				message.setIdEnv(rs.getInt("mess_from_id"));
				message.setIdRec(rs.getInt("mess_to_id"));
				message.setMess(rs.getString("mess_text"));
				message.setTemps(rs.getString("send_time"));
				listemessage.add(message);
			}
			Client client = getClient(id);
			request.setAttribute("client", client);
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
		request.getRequestDispatcher("/WEB-INF/conversation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Client getClient(int idclient) {
		String req = "SELECT * FROM CLIENT  WHERE IDCLIENT=" + idclient;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			Client client = null;
			while (rs.next()) {
				client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
			}
			return client;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
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
