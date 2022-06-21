package com.stp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Favor {
	private Connection connexion;
	private PreparedStatement st;
	private Statement stat;
	private ResultSet rs;

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

	public void inserer(HttpServletRequest request) {
		loadDatabase();
		int id_client = Utilisateur.id;
		String cliqued = request.getParameter("favoris");
		int id_bien = Integer.parseInt(cliqued);
		try {
			st = connexion.prepareStatement("insert into favoris(idbien,idclient)values(?,?)");
			st.setInt(1, id_bien);
			st.setInt(2, id_client);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {

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
	}

	public String Chercher(int id, int bien) {
		List<String> biens = new ArrayList<String>();
		loadDatabase();
		String ch = "";
		try {
			stat = connexion.createStatement();
			rs = stat.executeQuery("select id_bien , id_client from favoris ;");
			int i = 0;
			while (rs.next()) {
				biens.add(String.valueOf(rs.getInt(1)));
				biens.add(String.valueOf(rs.getInt(2)));
				if ((rs.getInt(1) == bien) && (rs.getInt(2) == id)) {
					i = 1;
					break;
				}
			}
			if (i == 0)
				ch = "non";
			else
				ch = "oui";

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
				if (connexion != null)
					connexion.close();
				/*
				 * if (st1 != null) st.close();
				 */
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		return ch;
	}

	public void inserer(int id, int bien) {

		loadDatabase();
		try {
			st = connexion.prepareStatement("insert into favoris(id_bien,id_client)values(?,?)");
			st.setInt(1, bien);
			st.setInt(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {

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
	}

	public void effacer(int id, int bien) {
		loadDatabase();
		try {

			st = connexion.prepareStatement("delete from favoris" + " where id_client=?" + " and id_bien=?;");
			st.setInt(1, id);
			st.setInt(2, bien);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermeture de la connexion
			try {

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
	}

	public List<String> favoris(int id) {
		List<String> numbien = new ArrayList<String>();
		loadDatabase();
		String query = "select * from favoris where id_client=" + id + ";";
		try {
			stat = connexion.createStatement();
			rs = stat.executeQuery(query);
			while (rs.next()) {
				numbien.add(String.valueOf(rs.getInt("id_bien")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numbien;
	}
}
