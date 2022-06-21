package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifieAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifieAgentServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String numtel = request.getParameter("numtel");
		String region = request.getParameter("region");
		String idagent = request.getParameter("idagent");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("UPDATE AGENT SET NOM=?,PRENOM=?,REGION=?,NUMTEL=? WHERE IDAGENT=" + idagent);
			pstmt.setString(1, nom);
			pstmt.setString(2, prenom);
			pstmt.setString(3, region);
			pstmt.setString(4, numtel);
			System.out.println("UPDATE AGENT SET NOM='" + nom + "',PRENOM='" + prenom + "',REGION='" + region + "',NUMTEL='" + numtel + "' WHERE IDAGENT=" + idagent);
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
		response.sendRedirect("/backoffice/prive/descriptifagent?identifiant=" + idagent);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
