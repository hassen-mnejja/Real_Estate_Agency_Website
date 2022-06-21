package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.model.BienImmobilier;
import agence.model.Client;

/**
 * Servlet implementation class AjoutContratServlet
 */
public class AjoutContratServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutContratServlet() {
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
		request.getRequestDispatcher("/WEB-INF/contratajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numcontrat = Integer.parseInt(request.getParameter("numcontrat"));
		String numcontratn = request.getParameter("numcontratn");
		int idbien = Integer.parseInt(request.getParameter("idbien"));
		int idclient = Integer.parseInt(request.getParameter("idclient"));
		String idbienn = request.getParameter("idbienn");
		int prix = Integer.parseInt(request.getParameter("prix"));
		String date = request.getParameter("date");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			if (idbienn != null) {
				deleteline(Integer.parseInt(numcontratn));
				if (Integer.parseInt(idbienn) != idbien)
					contratrechange(Integer.parseInt(idbienn));
			}
			PreparedStatement pstmt = con.prepareStatement("INSERT CONTRAT (NUMCONTRAT,IDBIEN,IDCLIENT,PRIX,DATE) values (?,?,?,?,?)");
			pstmt.setInt(1, numcontrat);
			pstmt.setInt(2, idbien);
			pstmt.setInt(3, idclient);
			pstmt.setInt(4, prix);
			pstmt.setString(5, date);
			pstmt.executeUpdate();
			contratchange(idbien);

			response.sendRedirect("/backoffice/prive/descriptifcontrat?identifiant=" + numcontrat);
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

	public void contratchange(int idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT MODEOFFRE FROM BIEN WHERE IDBIEN=" + idbien;
			Statement stmt = con.createStatement();
			System.out.println(req);
			ResultSet rs = stmt.executeQuery(req);
			String mode = "";
			if (rs.next()) { mode = rs.getString("MODEOFFRE"); }
			if (mode.contentEquals("A Vendre")) {
				PreparedStatement pstmt = con.prepareStatement("UPDATE BIEN SET STATUT=? WHERE IDBIEN=" + idbien);
				pstmt.setString(1, "Vendu");
				pstmt.executeUpdate();
			} else {
				PreparedStatement pstmt = con.prepareStatement("UPDATE BIEN SET STATUT=? WHERE IDBIEN=" + idbien);
				pstmt.setString(1, "Loué");
				pstmt.executeUpdate();
			}
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

	public void contratrechange(int idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("UPDATE BIEN SET STATUT=? WHERE IDBIEN=" + idbien);
			pstmt.setString(1, "Disponible");
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

	public void deleteline(int num) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM CONTRAT WHERE NUMCONTRAT=" + num);
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
}
