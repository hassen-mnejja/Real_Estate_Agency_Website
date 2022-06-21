package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.model.BienImmobilier;
import agence.model.Client;

/**
 * Servlet implementation class AjoutVisiteServlet
 */
public class AjoutVisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutVisiteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery("SELECT IDCLIENT,NOM,PRENOM FROM CLIENT");
			ArrayList<Client> clients = new ArrayList<Client>();
			while (rs1.next()) {
				Client cl = new Client();
				cl.setIdClient(rs1.getInt("IDCLIENT"));
				cl.setNom(rs1.getString("NOM"));
				cl.setPrenom(rs1.getString("PRENOM"));
				clients.add(cl);
			}
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT idbien,descriptif FROM BIEN WHERE STATUT='Disponible'");
			ArrayList<BienImmobilier> biens = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("idbien"));
				bien.setDescriptif(rs.getString("descriptif"));
				biens.add(bien);
			}
			request.setAttribute("biens", biens);
			request.setAttribute("clients", clients);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		request.getRequestDispatcher("/WEB-INF/visiteajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idbien = Integer.parseInt(request.getParameter("idbien"));
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		String heured = request.getParameter("heured");
		String heuref = request.getParameter("heuref");
		String date = request.getParameter("date");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("select idagent from agent where idagent not in ( select idagent from visite where date = ? and ((heured <= ? and heuref >= ? ) or (heured >= ? and heuref <= ? )));");
			pstmt.setString(1, date);
			pstmt.setString(2, heured);
			pstmt.setString(3, heuref);
			pstmt.setString(4, heured);
			pstmt.setString(5, heuref);
			ResultSet rs = pstmt.executeQuery();
			List<Integer> list = new ArrayList<>();
			int idagent = 0;
			Random rand = new Random();
			while (rs.next()) { list.add(rs.getInt(1)); }
			if (list.size() != 0)
				idagent = list.get(rand.nextInt(list.size()));
			if ((idagent == 0) || (disponible(idbien, date, heured, heuref) == 0)) {
				request.setAttribute("test", "faux");
				if (idagent != 0)
					request.setAttribute("message", "Le bien est occupé par une autre visite pour cette date.");
				else
					request.setAttribute("message", "Il n'y aucun agent disponnible pour cette date.");
				request.setAttribute("message0", "Essayer avec une autre date");
			} else {
				request.setAttribute("test", "vrai");
				ajouterVisite(idbien, idclient, heured, heuref, date, idagent);
				Statement st = con.createStatement();
				ResultSet rs1 = st.executeQuery("SELECT nom,prenom,numtel FROM AGENT WHERE IDAGENT=" + idagent);
				String nom = "";
				String prenom = "";
				String numtel = "";
				while (rs1.next()) {
					nom = rs1.getString("nom");
					prenom = rs1.getString("prenom");
					numtel = rs1.getString("numtel");
				}
				request.setAttribute("message1", "La visité a été programée avec succès.");
				request.setAttribute("message2", "L'agent disponnible est Mr/Mme : " + nom + "  " + prenom);
				request.setAttribute("message3", "Vous pouvez contacter sur son num :" + numtel);
			}
			request.getRequestDispatcher("/WEB-INF/visiteverifier.jsp").forward(request, response);
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
	}

	private void ajouterVisite(int idbien, int idclient, String heured, String heuref, String date, int idagent) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("INSERT VISITE (IDBIEN,IDAGENT,IDCLIENT,DATE,HEURED,HEUREF) values (?,?,?,?,?,?)");
			pstmt.setInt(1, idbien);
			pstmt.setInt(2, idagent);
			pstmt.setInt(3, idclient);
			pstmt.setString(4, date);
			pstmt.setString(5, heured);
			pstmt.setString(6, heuref);
			pstmt.executeUpdate();
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
	}

	private int disponible(int idbien, String date, String heured, String heuref) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("select idbien from bien where idbien=? and idbien not in ( select idbien from visite where date = ? and ((heured <= ? and heuref >= ? ) or (heured >= ? and heuref <= ? )));");
			pstmt.setInt(1, idbien);
			pstmt.setString(2, date);
			pstmt.setString(3, heured);
			pstmt.setString(4, heuref);
			pstmt.setString(5, heured);
			pstmt.setString(6, heuref);
			ResultSet rs = pstmt.executeQuery();
			int test = 0;
			if (rs.next()) { test = rs.getInt(1); }
			return test;
		} catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
