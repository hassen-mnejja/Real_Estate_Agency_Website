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

import agence.model.Appartement;
import agence.model.BienImmobilier;
import agence.model.Emplacement;
import agence.model.Entrepot;
import agence.model.Maison;
import agence.model.Studio;
import agence.model.Terrain;

public class DescriptifBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DescriptifBienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ids", listeprop());
		String identifiant = request.getParameter("identifiant");
		int id = Integer.parseInt(identifiant);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT * FROM BIEN WHERE IDBIEN = " + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			if (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setIdProp(rs.getInt("IDPROP"));
				bien.setStatut(rs.getString("STATUT"));
				bien.setDescriptif(rs.getString("DESCRIPTIF"));
				bien.setRue(rs.getString("RUE"));
				bien.setNumero(rs.getInt("NUMERO"));
				bien.setCodePostal(rs.getInt("CODEPOSTAL"));
				bien.setRegion(rs.getString("REGION"));
				bien.setDelegation(rs.getString("DELEGATION"));
				bien.setSoumission(rs.getString("SOUMISSION"));
				bien.setDisposition(rs.getString("DISPOSITION"));
				String typeBien = rs.getString("TYPEBIEN");
				bien.setTypeBien(typeBien);
				request.setAttribute("type", typeBien);
				bien.setModeOffre(rs.getString("MODEOFFRE"));
				bien.setPrixDemande(rs.getInt("PRIXDEMANDE"));
				bien.setEtat(rs.getString("ETAT"));
				bien.setCaution(rs.getInt("CAUTION"));
				bien.setLoyer(rs.getInt("LOYER"));
				bien.setCharges(rs.getInt("CHARGES"));
				bien.setTypeBail(rs.getString("TYPEBAIL"));
				bien.setMeuble(rs.getString("MEUBLE"));
				String carac = rs.getString("CARAC");
				if (carac.equals("")) { carac = "Pas de caractéristiques"; }
				String caracs[] = carac.split("/");
				bien.setCaracs(caracs);
				request.setAttribute("nbcaracs", caracs.length);
				bien.setNbImages(rs.getInt("NBIMAGES"));
				switch (typeBien) {
				case "Appartement":
					String req1 = "SELECT * FROM APPARTEMENT WHERE IDBIEN = " + id;
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(req1);
					Appartement appartement = new Appartement();
					if (rs1.next()) {
						appartement.setAscenseur(rs1.getString("ASCENSEUR"));
						appartement.setNbChambres(rs1.getInt("NBCHAMBRES"));
						appartement.setNbGarages(rs1.getInt("NBGARAGES"));
						appartement.setEtage(rs1.getInt("NETAGE"));
						appartement.setsTotale(rs1.getLong("STOTALE"));
						appartement.setsJardin(rs1.getLong("SJARDIN"));
						appartement.setBien(bien);
					}
					request.setAttribute("fbien", appartement);
					break;
				case "Maison":
					String req2 = "SELECT * FROM MAISON WHERE IDBIEN = " + id;
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(req2);
					Maison maison = new Maison();
					if (rs2.next()) {
						maison.setNbChambres(rs2.getInt("NBCHAMBRES"));
						maison.setNbGarages(rs2.getInt("NBGARAGES"));
						maison.setNbEtages(rs2.getInt("NBETAGES"));
						maison.setsTotale(rs2.getLong("STOTALE"));
						maison.setsJardin(rs2.getLong("SJARDIN"));
						maison.setBien(bien);
					}
					request.setAttribute("fbien", maison);
					break;
				case "Emplacement":
					String req3 = "SELECT * FROM EMPLACEMENT WHERE IDBIEN = " + id;
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery(req3);
					Emplacement emplacement = new Emplacement();
					if (rs3.next()) {
						emplacement.setNbPieces(rs3.getInt("NBPIECES"));
						emplacement.setsTotale(rs3.getLong("STOTALE"));
						emplacement.setBien(bien);
					}
					request.setAttribute("fbien", emplacement);
					break;
				case "Entrepot":
					String req4 = "SELECT * FROM ENTREPOT WHERE IDBIEN = " + id;
					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery(req4);
					Entrepot entrepot = new Entrepot();
					if (rs4.next()) {
						String equips = rs4.getString("EQUIPEMENT");
						entrepot.setEquip(equips.split("/"));
						request.setAttribute("nbequips", equips.length());
						entrepot.setsTotale(rs4.getLong("STOTALE"));
						entrepot.setBien(bien);
					}
					request.setAttribute("fbien", entrepot);
					break;
				case "Studio":
					String req5 = "SELECT * FROM STUDIO WHERE IDBIEN = " + id;
					Statement stmt5 = con.createStatement();
					ResultSet rs5 = stmt5.executeQuery(req5);
					Studio studio = new Studio();
					if (rs5.next()) {
						studio.setAscenseur(rs5.getString("ASCENSEUR"));
						studio.setsTotale(rs5.getLong("STOTALE"));
						studio.setEtage(rs5.getInt("NETAGE"));
						studio.setBien(bien);
					}
					request.setAttribute("fbien", studio);
					break;
				case "Terrain":
					String req6 = "SELECT * FROM TERRAIN WHERE IDBIEN = " + id;
					Statement stmt6 = con.createStatement();
					ResultSet rs6 = stmt6.executeQuery(req6);
					Terrain terrain = new Terrain();
					if (rs6.next()) {
						terrain.setAffectation(rs6.getString("AFFECTATION"));
						terrain.setsTotale(rs6.getLong("STOTALE"));
						terrain.setBien(bien);
					}
					request.setAttribute("fbien", terrain);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					System.out.println(e2.toString());
				}
			}
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/biendescriptif.jsp");
		disp.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	ArrayList<Integer> listeprop() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT idprop FROM PROPRIETAIRE");
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) { ids.add(rs.getInt(1)); }
			return ids;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
			return null;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
