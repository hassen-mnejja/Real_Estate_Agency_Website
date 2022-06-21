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

public class ChercherBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChercherBienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM BIEN";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<BienImmobilier> listebien = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setStatut(rs.getString("STATUT"));
				bien.setModeOffre(rs.getString("MODEOFFRE"));
				bien.setTypeBien(rs.getString("TYPEBIEN"));
				bien.setDelegation(rs.getString("DELEGATION"));
				bien.setRegion(rs.getString("REGION"));
				int prix = 0;
				int prixa = rs.getInt("PRIXDEMANDE");
				int prixl = rs.getInt("LOYER");
				if (prixa == 0)
					prix = prixl;
				else
					prix = prixa;
				bien.setPrix(prix);
				listebien.add(bien);
			}
			request.setAttribute("listebien", listebien);
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
		request.getRequestDispatcher("/WEB-INF/biencherche.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typebien = request.getParameter("typebien");
		request.setAttribute("typebien", typebien);
		String modeoffre = request.getParameter("modeoffre");
		request.setAttribute("modeoffre", modeoffre);
		String statut = request.getParameter("statut");
		request.setAttribute("statut", statut);
		String region = request.getParameter("region");
		request.setAttribute("region", region);
		String delegation = request.getParameter("delegation");
		request.setAttribute("delegation", delegation);
		String de = request.getParameter("de");
		request.setAttribute("de", de);
		String vers = request.getParameter("vers");
		request.setAttribute("vers", vers);
		String pde = request.getParameter("pde");
		request.setAttribute("pde", pde);
		String pvers = request.getParameter("pvers");
		request.setAttribute("pvers", pvers);

		if (de == "")
			de = "0";
		if (vers == "")
			vers = "9999";
		if (pde == "")
			pde = "0";
		if (pvers == "")
			pvers = "99999999";
		String req = "SELECT * FROM BIEN WHERE IDBIEN BETWEEN " + de + " AND " + vers;
		req = req + " AND PRIXDEMANDE BETWEEN " + pde + " AND " + pvers;
		req = req + " AND LOYER BETWEEN " + pde + " AND " + pvers;
		if (typebien != "" && typebien != null) { req = req + " AND UPPER(TYPEBIEN) = UPPER('" + typebien + "')"; }
		if (modeoffre != "" && typebien != null) { req = req + " AND UPPER(MODEOFFRE) = UPPER('" + modeoffre + "')"; }
		if (statut != "" && typebien != null) { req = req + " AND UPPER(STATUT) = UPPER('" + statut + "')"; }
		if (region != "" && typebien != null) { req = req + " AND UPPER(REGION) = UPPER('" + region + "')"; }
		if (delegation != "" && typebien != null) { req = req + " AND UPPER(DELEGATION) = UPPER('" + delegation + "')"; }
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<BienImmobilier> listebien = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setStatut(rs.getString("STATUT"));
				bien.setModeOffre(rs.getString("MODEOFFRE"));
				bien.setTypeBien(rs.getString("TYPEBIEN"));
				bien.setDelegation(rs.getString("DELEGATION"));
				bien.setRegion(rs.getString("REGION"));
				int prix = 0;
				int prixa = rs.getInt("PRIXDEMANDE");
				int prixl = rs.getInt("LOYER");
				if (prixa == 0)
					prix = prixl;
				else
					prix = prixa;
				bien.setPrix(prix);
				listebien.add(bien);
			}
			request.setAttribute("listebien", listebien);
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
		request.getRequestDispatcher("/WEB-INF/biencherche.jsp").forward(request, response);
	}

}
