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

public class Utilisateur {
	public static int id;
	public static int bien;
	public static int entrer;
	public static String nom;
	public static String prenom;
	public static String email;
	public static String numtel;
	public static String password;
	public static List<String[]> listefavoris = new ArrayList<String[]>();
	private Connection connexion;
	private Statement st;
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

	public int identifiant(HttpServletRequest request) {
		String emaile = request.getParameter("email");
		String passworde = request.getParameter("password");
		loadDatabase();
		try {
			st = connexion.createStatement();
			rs = st.executeQuery("select * from client c where " + "c.email='" + emaile + "'" + " AND c.password='" + passworde + "';");
			if (rs != null) {
				rs.next();
				id = rs.getInt("idclient");
				prenom = rs.getString("prenom");
				nom = rs.getString("nom");
				password = rs.getString("password");
				email = rs.getString("email");
				numtel = rs.getString("numtel");

			} else
				id = 0;
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
		return id;
	}

	public void addClient(HttpServletRequest request) {
		loadDatabase();

		try {
			PreparedStatement ps = connexion.prepareStatement("insert into client(nom,prenom,password,email,numtel) values(?,?,?,?,?)");
			/* ps.setString(1,null); */
			String email = request.getParameter("email");
			String pwd1 = request.getParameter("pwd1");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("num");
			this.prenom = prenom;
			this.email = email;
			this.password = pwd1;
			this.nom = nom;
			this.numtel = tel;
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, pwd1);
			ps.setString(4, email);
			ps.setString(5, tel);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public int dernierligne() {
		loadDatabase();
		int i = 0;
		try {
			st = connexion.createStatement();
			rs = st.executeQuery("select * from client ;");

			while (rs.next())
				i = i + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public boolean UpdateClient(HttpServletRequest request) {
		loadDatabase();
		boolean flag = false;
		String sql = "update client set password=?,numtel=?,nom=?,prenom=?,email=? where idclient=?";
		try {
			PreparedStatement ps = connexion.prepareStatement(sql);

			ps.setString(1, request.getParameter("pwd1"));
			ps.setString(2, request.getParameter("num"));
			ps.setString(3, request.getParameter("nom"));
			ps.setString(4, request.getParameter("prenom"));
			ps.setString(5, request.getParameter("email"));
			ps.setInt(6, id);
			if (ps.executeUpdate() > 0) {
				flag = true;

			}
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;

	}
}
