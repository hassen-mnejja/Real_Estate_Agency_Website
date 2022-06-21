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
import agence.model.Contrat;

/**
 * Servlet implementation class DescriptifContratServlet
 */
public class DescriptifContratServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DescriptifContratServlet() {
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
		int numcontrat = Integer.parseInt(identifiant);

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT NUMCONTRAT,B.IDBIEN,CL.IDCLIENT,DATE,PRIX,DESCRIPTIF,NOM,PRENOM FROM CONTRAT C,BIEN B,CLIENT CL WHERE C.IDBIEN=B.IDBIEN AND C.IDCLIENT=CL.IDCLIENT AND NUMCONTRAT = " + numcontrat;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			if (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setDescriptif(rs.getString("DESCRIPTIF"));
				Contrat contrat = new Contrat();
				contrat.setClient(client);
				contrat.setBien(bien);
				contrat.setNumContrat(numcontrat);
				contrat.setDate(rs.getString("DATE"));
				contrat.setPrix(rs.getInt("PRIX"));
				request.setAttribute("contrat", contrat);
			}
			ArrayList<BienImmobilier> biens;
			biens = getListeBien();
			request.setAttribute("biens", biens);
			ArrayList<Client> clients;
			clients = getListeClient();
			request.setAttribute("clients", clients);
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

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/contratdescriptif.jsp");
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

	private ArrayList<BienImmobilier> getListeBien() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT * FROM BIEN WHERE STATUT = 'Disponible'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<BienImmobilier> listebien = new ArrayList<BienImmobilier>();
			while (rs.next()) {
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setDescriptif(rs.getString("DESCRIPTIF"));
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

	private ArrayList<Client> getListeClient() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT * FROM CLIENT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			ArrayList<Client> listeclient = new ArrayList<Client>();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				listeclient.add(client);
			}
			return listeclient;
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

}
