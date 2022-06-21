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
import agence.model.Client;

/**
 * Servlet implementation class DescriptifClientServlet
 */
public class DescriptifClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DescriptifClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		int id = Integer.parseInt(identifiant);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT IDCLIENT,NOM,PRENOM,NUMTEL,EMAIL FROM CLIENT WHERE IDCLIENT = " + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			if (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				client.setNumtel(rs.getString("NUMTEL"));
				client.setEmail(rs.getString("EMAIL"));
				ArrayList<BienImmobilier> liste = favoris(id);
				client.setFavoris(liste);
				request.setAttribute("client", client);
			}
		} catch (Exception e) {
			System.out.println("Echec de connexion");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/clientdescriptif.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private ArrayList<BienImmobilier> favoris(int id) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT DESCRIPTIF,IDBIEN,TYPEBIEN,MODEOFFRE FROM BIEN B,FAVORIS F WHERE (B.IDBIEN=F.id_bien) AND id_client = " + id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<BienImmobilier> liste = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setDescriptif(rs.getString("DESCRIPTIF"));
				bien.setTypeBien(rs.getString("TYPEBIEN"));
				bien.setModeOffre(rs.getString("MODEOFFRE"));
				liste.add(bien);
			}
			return liste;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
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
