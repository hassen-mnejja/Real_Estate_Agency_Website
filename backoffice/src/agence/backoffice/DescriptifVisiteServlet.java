package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agence.model.Agent;
import agence.model.BienImmobilier;
import agence.model.Client;
import agence.model.Visite;

/**
 * Servlet implementation class DescriptifVisiteServlet
 */
public class DescriptifVisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DescriptifVisiteServlet() {
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
		int idvisite = Integer.parseInt(identifiant);

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			String req = "SELECT IDVISITE,B.IDBIEN,CL.IDCLIENT,DATE,HEURED,HEUREF,DESCRIPTIF,NOM,PRENOM FROM VISITE V,BIEN B,CLIENT CL WHERE V.IDBIEN=B.IDBIEN AND V.IDCLIENT=CL.IDCLIENT AND IDVISITE = " + idvisite;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(req);
			String req1 = "SELECT V.IDAGENT,NOM,PRENOM FROM VISITE V,AGENT A WHERE V.IDAGENT=A.IDAGENT AND IDVISITE = " + idvisite;
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(req1);
			Visite visite = new Visite();
			if (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("IDCLIENT"));
				client.setNom(rs.getString("NOM"));
				client.setPrenom(rs.getString("PRENOM"));
				BienImmobilier bien = new BienImmobilier();
				bien.setIdBien(rs.getInt("IDBIEN"));
				bien.setDescriptif(rs.getString("DESCRIPTIF"));
				visite.setClient(client);
				visite.setBien(bien);
				visite.setIdVisite(idvisite);
				visite.setDate(rs.getString("DATE"));
				visite.setHeured(rs.getString("HEURED"));
				visite.setHeuref(rs.getString("HEUREF"));
			}
			if (rs1.next()) {
				Agent agent = new Agent();
				agent.setIdAgent(rs1.getInt("IDAGENT"));
				agent.setNom(rs1.getString("NOM"));
				agent.setPrenom(rs1.getString("PRENOM"));
				visite.setAgent(agent);
			}
			request.setAttribute("visite", visite);
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

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/visitedescriptif.jsp");
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

}
