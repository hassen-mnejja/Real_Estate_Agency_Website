package com.stp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Chercher {
	private Connection connexion;
	private Statement st;
	private ResultSet rs;
	public static List<String[]> biens = new ArrayList<String[]>();
	public List<String[]> tous = new ArrayList<String[]>();
	public static String typebien;
	public static String regionbien;
	public static int verif;

	private void loadDatabase() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {}

		try {
			String url = "jdbc:mysql://localhost:3306/agence?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			connexion = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String[]> Selection(HttpServletRequest request) {

		loadDatabase();
		String region = request.getParameter("region");
		String[] bien = request.getParameterValues("bien");
		String budgetmax = request.getParameter("maximum");
		String budgetmin = request.getParameter("minimum");
		String maxsup = request.getParameter("maxsup");
		String minsup = request.getParameter("minsup");
		String[] type = request.getParameterValues("type");
		typebien = bien[0];
		regionbien = region;
		try {

			biens.clear();
			st = connexion.createStatement();
			if (type[0].equals("A Vendre"))
				rs = st.executeQuery("select idbien,delegation,superficie,prixdemande,descriptif,nbimages,codepostal,modeoffre,disposition,numero,rue,carac,etat,caution,loyer,charges,typebail,meuble,typebien" + " from bien bi " + "where bi.region='"
						+ region + "'" + " AND bi.typebien='" + bien[0] + "'" + " AND bi.prixdemande between'" + Integer.parseInt(budgetmin) + "'" + "and '" + Integer.parseInt(budgetmax) + "'" + " AND bi.superficie between'"
						+ Integer.parseInt(minsup) + "'" + "and '" + Integer.parseInt(maxsup) + "'" + " AND bi.statut='" + "Disponible '" + " AND bi.modeoffre='" + type[0] + "';");

			else
				rs = st.executeQuery("select idbien,delegation,superficie,prixdemande,descriptif,nbimages,codepostal,modeoffre,disposition,numero,rue,carac,etat,caution,loyer,charges,typebail,meuble,typebien" + " from bien bi " + "where bi.region='"
						+ region + "'" + " AND bi.type_bien='" + bien[0] + "'" + " AND bi.loyer between'" + Integer.parseInt(budgetmin) + "'" + "and '" + Integer.parseInt(budgetmax) + "'" + " AND bi.superficie between'" + Integer.parseInt(minsup)
						+ "'" + "and '" + Integer.parseInt(maxsup) + "'" + " AND bi.statut='" + "Disponible '" + " AND bi.modeoffre='" + type[0] + "';");
			while (rs.next()) {

				String[] lien = new String[19];
				lien[0] = (String.valueOf(rs.getInt(1))); // numbien
				lien[1] = (rs.getString(2));// delegation
				lien[2] = (rs.getString(3));// superficie
				lien[3] = (rs.getString(4));// prix
				lien[4] = (rs.getString(5));// description
				lien[5] = (String.valueOf(rs.getInt(6)));// nb_image
				lien[6] = (String.valueOf(rs.getInt(7)));// codepostal
				lien[7] = rs.getString(8);// modeoffre
				lien[8] = rs.getString(9);// date
				lien[9] = String.valueOf(rs.getInt(10));// numero
				lien[10] = rs.getString(11);// rue
				lien[11] = rs.getString(12);// carac
				lien[12] = rs.getString(13);// etat
				lien[13] = String.valueOf(rs.getInt(14));// caution
				lien[14] = String.valueOf(rs.getInt(15));// loyer
				lien[15] = String.valueOf(rs.getInt(16));// charges
				lien[16] = rs.getString(17);// typebail
				lien[17] = rs.getString(18);// meuble
				lien[18] = rs.getString(19);// type_bien
				biens.add(lien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (connexion != null)
					connexion.close();
				/*
				 * if (st1 != null) st.close();
				 */
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		return biens;
	}

	public String[] type_bien(int id, String type) {
		loadDatabase();
		String query = "select * from maison where idbien=" + id + ";";
		String query2 = "select * from appartement where idbien=" + id + ";";
		String query3 = "select * from entrepot where idbien=" + id + ";";
		String query4 = "select * from emplacement where idbien=" + id + ";";
		String query5 = "select * from studio where idbien=" + id + ";";
		String query6 = "select * from terrain where idbien=" + id + ";";
		String[] tab = new String[5];
		try {
			st = connexion.createStatement();
			if (type.equals("Maison")) {
				rs = st.executeQuery(query);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("nbchambres"));
				tab[1] = String.valueOf(rs.getInt("nbgarages"));
				tab[2] = String.valueOf(rs.getInt("nbetages"));
				tab[3] = String.valueOf(rs.getInt("stotale"));
				tab[4] = String.valueOf(rs.getInt("sjardin"));
			}
			if (type.equals("Appartement")) {
				rs = st.executeQuery(query2);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("nbgarages"));
				tab[1] = String.valueOf(rs.getString("ascenseur"));
				tab[2] = String.valueOf(rs.getInt("nbchambres"));
				tab[3] = String.valueOf(rs.getInt("stotale"));
				tab[4] = String.valueOf(rs.getInt("netage"));
			}
			if (type.equals("Entrepot")) {
				rs = st.executeQuery(query3);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("stotale"));
				tab[1] = rs.getString("equipement");
			}
			if (type.equals("Emplacement")) {
				rs = st.executeQuery(query4);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("stotale"));
				tab[1] = String.valueOf(rs.getInt("nbpieces"));
			}
			if (type.equals("Studio")) {
				rs = st.executeQuery(query5);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("netage"));
				tab[2] = String.valueOf(rs.getInt("stotale"));
				tab[1] = String.valueOf(rs.getString("ascenseur"));
			}
			if (type.equals("Terrain")) {
				rs = st.executeQuery(query6);
				rs.next();
				tab[0] = String.valueOf(rs.getInt("stotale"));
				tab[1] = rs.getString("affectation");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tab;
	}

	public List<String[]> Tout() {
		tous.clear();
		loadDatabase();
		try {

			st = connexion.createStatement();
			rs = st.executeQuery(
					"select idbien,delegation,superficie,prixdemande,descriptif,nbimages,codepostal,modeoffre,disposition,numero,rue,carac,etat,caution,loyer,charges,typebail,meuble,typebien" + " from bien " + " where statut='" + "Disponible ';");
			int i = 0;
			while (rs.next()) {
				String[] lien = new String[19];
				lien[0] = (String.valueOf(rs.getInt(1))); // numbien
				lien[1] = (rs.getString(2));// delegation
				lien[2] = (rs.getString(3));// superficie
				lien[3] = (rs.getString(4));// prix
				lien[4] = (rs.getString(5));// description
				lien[5] = (String.valueOf(rs.getInt(6)));// nb_image
				lien[6] = (String.valueOf(rs.getInt(7)));// codepostal
				lien[7] = rs.getString(8);// modeoffre
				lien[8] = rs.getString(9);// date
				lien[9] = String.valueOf(rs.getInt(10));// numero
				lien[10] = rs.getString(11);// rue
				lien[11] = rs.getString(12);// carac
				lien[12] = rs.getString(13);// etat
				lien[13] = String.valueOf(rs.getInt(14));// caution
				lien[14] = String.valueOf(rs.getInt(15));// loyer
				lien[15] = String.valueOf(rs.getInt(16));// charges
				lien[16] = rs.getString(17);// typebail
				lien[17] = rs.getString(18);// meuble
				lien[18] = rs.getString(19);// type_bien
				tous.add(lien);
				i = i + 1;
			}
			verif = i;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (connexion != null)
					connexion.close();
				/*
				 * if (st1 != null) st.close();
				 */
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		return tous;
	}

	public List<String[]> toute_la_base() {
		List<String[]> bien_favoris = new ArrayList<String[]>();
		loadDatabase();
		try {
			st = connexion.createStatement();
			rs = st.executeQuery("select idbien,delegation,superficie,prixdemande,descriptif,nbimages,codepostal,modeoffre,disposition,numero,rue,carac,etat,caution,loyer,charges,typebail,meuble,typebien" + " from bien ;");
			while (rs.next()) {
				String[] lien = new String[19];
				lien[0] = (String.valueOf(rs.getInt(1))); // numbien
				lien[1] = (rs.getString(2));// delegation
				lien[2] = (rs.getString(3));// superficie
				lien[3] = (rs.getString(4));// prix
				lien[4] = (rs.getString(5));// description
				lien[5] = (String.valueOf(rs.getInt(6)));// nb_image
				lien[6] = (String.valueOf(rs.getInt(7)));// codepostal
				lien[7] = rs.getString(8);// modeoffre
				lien[8] = rs.getString(9);// date
				lien[9] = String.valueOf(rs.getInt(10));// numero
				lien[10] = rs.getString(11);// rue
				lien[11] = rs.getString(12);// carac
				lien[12] = rs.getString(13);// etat
				lien[13] = String.valueOf(rs.getInt(14));// caution
				lien[14] = String.valueOf(rs.getInt(15));// loyer
				lien[15] = String.valueOf(rs.getInt(16));// charges
				lien[16] = rs.getString(17);// typebail
				lien[17] = rs.getString(18);// meuble
				lien[18] = rs.getString(19);// type_bien
				bien_favoris.add(lien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bien_favoris;
	}
}
