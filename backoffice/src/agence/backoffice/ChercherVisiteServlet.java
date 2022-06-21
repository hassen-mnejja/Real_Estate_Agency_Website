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
import agence.model.BienImmobilier;
import agence.model.Client;
import agence.model.Visite;

/**
 * Servlet implementation class ChercherVisiteServlet
 */
public class ChercherVisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChercherVisiteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM VISITE";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Visite> listevisite = new ArrayList<Visite>();
			while (rs.next()) {
				Visite visite = new Visite();
				visite.setIdVisite(rs.getInt("IDVISITE"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				Agent agent = new Agent();
				agent.setIdAgent(rs.getInt("IDAGENT"));
				visite.setClient(client);
				visite.setBien(bien);
				visite.setAgent(agent);
				visite.setDate(rs.getString("DATE"));
				visite.setHeured(rs.getString("HEURED"));
				visite.setHeuref(rs.getString("HEUREF"));
				listevisite.add(visite);
			}
			request.setAttribute("listevisite", listevisite);
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
		request.getRequestDispatcher("/WEB-INF/visitecherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idagent = request.getParameter("idagent");
		request.setAttribute("idagent", idagent);
		String idclient = request.getParameter("idclient");
		request.setAttribute("idclient", idclient);
		String datemin = request.getParameter("datemin");
		request.setAttribute("datemin", datemin);
		String datemax = request.getParameter("datemax");
		request.setAttribute("pmidatemaxn", datemax);
		String idbien = request.getParameter("idbien");
		request.setAttribute("idbien", idbien);
		if (datemax == "")
			datemax = "2050-12-30";
		if (datemin == "")
			datemin = "1950-12-30";
		String req = "SELECT * FROM VISITE WHERE DATE BETWEEN '" + datemin + "' AND '" + datemax + "'";
		if (idagent != "") { req = req + " AND IDAGENT = " + idagent; }
		if (idbien != "") { req = req + " AND IDBIEN = " + idbien; }
		if (idclient != "") { req = req + " AND IDCLIENT = " + idclient; }
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Visite> listevisite = new ArrayList<Visite>();
			while (rs.next()) {
				Visite visite = new Visite();
				visite.setIdVisite(rs.getInt("IDVISITE"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				Agent agent = new Agent();
				agent.setIdAgent(rs.getInt("IDAGENT"));
				visite.setClient(client);
				visite.setBien(bien);
				visite.setAgent(agent);
				visite.setDate(rs.getString("DATE"));
				visite.setHeured(rs.getString("HEURED"));
				visite.setHeuref(rs.getString("HEUREF"));
				listevisite.add(visite);
			}
			request.setAttribute("listevisite", listevisite);
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
		request.getRequestDispatcher("/WEB-INF/visitecherche.jsp").forward(request, response);
	}

}
