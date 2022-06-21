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

import agence.model.BienImmobilier;
import agence.model.Client;
import agence.model.Contrat;

/**
 * Servlet implementation class ChercherContratServlet
 */
public class ChercherContratServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChercherContratServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM CONTRAT";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Contrat> listecontrat = new ArrayList<Contrat>();
			while (rs.next()) {
				Contrat contrat = new Contrat();
				contrat.setNumContrat(rs.getInt("NUMCONTRAT"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				contrat.setClient(client);
				contrat.setBien(bien);
				contrat.setDate(rs.getString("DATE"));
				contrat.setPrix(rs.getInt("PRIX"));
				listecontrat.add(contrat);
			}
			request.setAttribute("listecontrat", listecontrat);
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
		request.getRequestDispatcher("/WEB-INF/contratcherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numcontrat = request.getParameter("numcontrat");
		request.setAttribute("numcontrat", numcontrat);
		String idbien = request.getParameter("idbien");
		request.setAttribute("idbien", idbien);
		String idclient = request.getParameter("idclient");
		request.setAttribute("idclient", idclient);
		String pmin = request.getParameter("pmin");
		request.setAttribute("pmin", pmin);
		String pmax = request.getParameter("pmax");
		request.setAttribute("pmax", pmax);
		String datemin = request.getParameter("datemin");
		request.setAttribute("datemin", datemin);
		String datemax = request.getParameter("datemax");
		request.setAttribute("datemax", datemax);
		if (pmin == "")
			pmin = "0";
		if (pmax == "")
			pmax = "10000000";
		if (datemax == "")
			datemax = "2050-12-30";
		if (datemin == "")
			datemin = "1950-12-30";
		String req = "SELECT * FROM CONTRAT WHERE PRIX BETWEEN " + pmin + " AND " + pmax + " AND DATE BETWEEN '" + datemin + "' AND '" + datemax + "'";
		if (numcontrat != "") { req = req + " AND NUMCONTRAT = " + numcontrat; }
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
			ArrayList<Contrat> listecontrat = new ArrayList<Contrat>();
			while (rs.next()) {
				Contrat contrat = new Contrat();
				contrat.setNumContrat(rs.getInt("NUMCONTRAT"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				contrat.setClient(client);
				contrat.setBien(bien);
				contrat.setDate(rs.getString("DATE"));
				contrat.setPrix(rs.getInt("PRIX"));
				listecontrat.add(contrat);
			}
			request.setAttribute("listecontrat", listecontrat);
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
		request.getRequestDispatcher("/WEB-INF/contratcherche.jsp").forward(request, response);
	}

}
