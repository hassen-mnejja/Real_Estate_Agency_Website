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

import agence.model.BienImmobilier;
import agence.model.Proprietaire;

public class DescriptifPropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DescriptifPropServlet() {
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
			String req = "SELECT IDPROP,NOM,PRENOM,NUMPRIV,NUMTRAV,DEBUTDISPO,FINDISPO,ADRESS FROM PROPRIETAIRE WHERE IDPROP = " + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			int idprop = 0;
			if (rs.next()) {
				Proprietaire prop = new Proprietaire();
				idprop = rs.getInt("IDPROP");
				prop.setIdProp(idprop);
				prop.setNom(rs.getString("NOM"));
				prop.setPrenom(rs.getString("PRENOM"));
				prop.setNumPriv(rs.getString("NUMPRIV"));
				prop.setNumTrav(rs.getString("NUMTRAV"));
				prop.setDebutDispo(rs.getString("DEBUTDISPO"));
				prop.setFinDispo(rs.getString("FINDISPO"));
				prop.setAdress(rs.getString("ADRESS"));
				request.setAttribute("prop", prop);
			}
			ArrayList<BienImmobilier> listebien;
			listebien = getListeBien(idprop);
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

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/propdescriptif.jsp");
		disp.forward(request, response);
	}

	private ArrayList<BienImmobilier> getListeBien(int idprop) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT * FROM BIEN WHERE IDPROP = " + idprop;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<BienImmobilier> listebien = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setStatut(rs.getString("STATUT"));
				bien.setRegion(rs.getString("REGION"));
				bien.setDelegation(rs.getString("DELEGATION"));
				bien.setModeOffre(rs.getString("MODEOFFRE"));
				bien.setTypeBien(rs.getString("TYPEBIEN"));
				listebien.add(bien);
			}
			return listebien;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					System.out.println(e2.toString());
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
