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

import agence.model.Agent;

public class ChercherAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChercherAgentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM AGENT";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Agent> listeagent = new ArrayList<Agent>();
			while (rs.next()) {
				Agent agent = new Agent();
				agent.setIdAgent(rs.getInt("IDAGENT"));
				agent.setNom(rs.getString("NOM"));
				agent.setPrenom(rs.getString("PRENOM"));
				agent.setAdress(rs.getString("REGION"));
				agent.setNumTel(rs.getString("NUMTEL"));
				agent.setSexe(rs.getString("SEXE"));
				listeagent.add(agent);
			}
			request.setAttribute("listeagent", listeagent);
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
		request.getRequestDispatcher("/WEB-INF/agentcherche.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		String numtel = request.getParameter("numtel");
		request.setAttribute("numtel", numtel);
		String sexe = request.getParameter("sexe");
		request.setAttribute("sexe", sexe);
		String region = request.getParameter("region");
		request.setAttribute("region", region);
		String de = request.getParameter("de");
		request.setAttribute("de", de);
		String vers = request.getParameter("vers");
		request.setAttribute("vers", vers);
		if (de == "")
			de = "0";
		if (vers == "")
			vers = "1000";
		String req = "SELECT * FROM AGENT WHERE IDAGENT BETWEEN " + de + " AND " + vers;
		if (nom != "") { req = req + " AND UPPER(NOM) LIKE UPPER('%" + nom + "%')"; }
		if (prenom != "") { req = req + " AND UPPER(PRENOM) LIKE UPPER('%" + prenom + "%')"; }
		if (numtel != "" && numtel != null) { req = req + " AND NUMTEL LIKE '%" + numtel + "%'"; }
		if (sexe != "" && sexe != null) { req = req + " AND UPPER(SEXE)=UPPER('" + sexe + "')"; }
		if (region != "" && region != null) { req = req + " AND UPPER(REGION)=UPPER('" + region + "')"; }
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Agent> listeagent = new ArrayList<Agent>();
			while (rs.next()) {
				Agent agent = new Agent();
				agent.setIdAgent(rs.getInt("IDAGENT"));
				agent.setNom(rs.getString("NOM"));
				agent.setPrenom(rs.getString("PRENOM"));
				agent.setAdress(rs.getString("REGION"));
				agent.setNumTel(rs.getString("NUMTEL"));
				agent.setSexe(rs.getString("SEXE"));
				listeagent.add(agent);
			}
			request.setAttribute("listeagent", listeagent);
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
		request.getRequestDispatcher("/WEB-INF/agentcherche.jsp").forward(request, response);
	}

}
