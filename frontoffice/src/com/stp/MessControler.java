package com.stp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessControler {
	private Connection connexion;

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

	public void addMessage(Mess m) {
		loadDatabase();

		try {
			PreparedStatement ps = connexion.prepareStatement("insert into message(mess_from_id,mess_to_id,mess_text,send_time) values (?,?,?,?)");

			ps.setInt(1, m.getMessFromId());
			ps.setInt(2, m.getMessToId());
			ps.setString(3, m.getMessText());
			ps.setString(4, m.getSendDate());

			ps.executeUpdate();
			// ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteMessage(int idMessage) {
		loadDatabase();
		try {
			PreparedStatement ps = connexion.prepareStatement("delete FROM message where mess_from_id = ?");
			ps.setInt(1, idMessage);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Mess> listMessage(int idclient) {
		List<Mess> msgs = new ArrayList<Mess>();
		loadDatabase();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM message where( mess_from_id =?|| mess_to_id=?)  order by send_time");
			ps.setInt(1, idclient);
			ps.setInt(2, idclient);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mess m = new Mess();
				m.setMessFromId(rs.getInt("mess_from_id"));
				m.setMessToId(rs.getInt("mess_to_id"));
				m.setMessText(rs.getString("mess_text"));
				m.setSendDate(rs.getString("send_time"));
				m.setMessId(rs.getInt("mess_id"));

				msgs.add(m);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msgs;
	}

}
