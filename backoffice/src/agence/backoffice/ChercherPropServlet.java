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

import agence.model.Proprietaire;

public class ChercherPropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChercherPropServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = "SELECT * FROM PROPRIETAIRE";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Proprietaire> listeprop = new ArrayList<Proprietaire>();
			while (rs.next()) {
				Proprietaire prop = new Proprietaire();
				prop.setIdProp(rs.getInt("IDPROP"));
				prop.setNom(rs.getString("NOM"));
				prop.setPrenom(rs.getString("PRENOM"));
				prop.setNumPriv(rs.getString("NUMPRIV"));
				prop.setNumTrav(rs.getString("NUMTRAV"));
				prop.setDebutDispo(rs.getString("DEBUTDISPO"));
				prop.setFinDispo(rs.getString("FINDISPO"));
				prop.setAdress(rs.getString("ADRESS"));
				listeprop.add(prop);
			}
			request.setAttribute("listeprop", listeprop);
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
		request.getRequestDispatcher("/WEB-INF/propcherche.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		String numpriv = request.getParameter("numpriv");
		request.setAttribute("numpriv", numpriv);
		String numtrav = request.getParameter("numtrav");
		request.setAttribute("numtrav", numtrav);
		String de = request.getParameter("de");
		request.setAttribute("de", de);
		String vers = request.getParameter("vers");
		request.setAttribute("vers", vers);
		if (de == "")
			de = "0";
		if (vers == "")
			vers = "1000";
		String req = "SELECT * FROM PROPRIETAIRE WHERE IDPROP BETWEEN " + de + " AND " + vers;
		if (nom != "") { req = req + " AND UPPER(NOM) LIKE UPPER('%" + nom + "%')"; }
		if (prenom != "") { req = req + " AND UPPER(PRENOM) LIKE UPPER('%" + prenom + "%')"; }
		if (numpriv != "" && numpriv != null) { req = req + " AND NUMPRIV LIKE '%" + numpriv + "%'"; }
		if (numtrav != "" && numtrav != null) { req = req + " AND NUMTRAV LIKE '%" + numtrav + "%'"; }
		System.out.println(req);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Proprietaire> listeprop = new ArrayList<Proprietaire>();
			while (rs.next()) {
				Proprietaire prop = new Proprietaire();
				prop.setIdProp(rs.getInt("IDPROP"));
				prop.setNom(rs.getString("NOM"));
				prop.setPrenom(rs.getString("PRENOM"));
				prop.setNumPriv(rs.getString("NUMPRIV"));
				prop.setNumTrav(rs.getString("NUMTRAV"));
				prop.setDebutDispo(rs.getString("DEBUTDISPO"));
				prop.setFinDispo(rs.getString("FINDISPO"));
				prop.setAdress(rs.getString("ADRESS"));
				listeprop.add(prop);
			}
			request.setAttribute("listeprop", listeprop);
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
		request.getRequestDispatcher("/WEB-INF/propcherche.jsp").forward(request, response);
	}

}
