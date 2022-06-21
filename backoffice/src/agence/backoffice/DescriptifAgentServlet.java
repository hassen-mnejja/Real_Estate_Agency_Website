package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.model.Agent;
import agence.model.BienImmobilier;
import agence.model.Client;
import agence.model.Visite;

public class DescriptifAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DescriptifAgentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		int id = Integer.parseInt(identifiant);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT IDAGENT,NOM,PRENOM,NUMTEL,SEXE,REGION FROM AGENT WHERE IDAGENT = " + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			if (rs.next()) {
				Agent agent = new Agent();
				agent.setIdAgent(rs.getInt("IDAGENT"));
				agent.setNom(rs.getString("NOM"));
				agent.setPrenom(rs.getString("PRENOM"));
				agent.setNumTel(rs.getString("NUMTEL"));
				agent.setSexe(rs.getString("SEXE"));
				agent.setAdress(rs.getString("REGION"));
				ArrayList<Visite> liste = visites(id);
				request.setAttribute("agent", agent);
				request.setAttribute("listevisite", liste);
			}
		} catch (Exception e) {
			System.out.println("Echec de connexion");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/agentdescriptif.jsp");
		disp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private ArrayList<Visite> visites(int idagent) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT IDVISITE,IDCLIENT,IDBIEN,DATE,HEURED,HEUREF FROM VISITE WHERE IDAGENT = " + idagent;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Visite> liste = new ArrayList<Visite>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				Visite visite = new Visite();
				visite.setIdVisite(rs.getInt("IDVISITE"));
				visite.setBien(bien);
				visite.setClient(client);
				visite.setDate(rs.getString("DATE"));
				visite.setHeured(rs.getString("HEURED"));
				visite.setHeuref(rs.getString("HEUREF"));
				liste.add(visite);
			}
			return liste;
		} catch (Exception e) {
			System.out.println("Echec de connexion");
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
