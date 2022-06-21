package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimeProprietaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimeProprietaireServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idprop = request.getParameter("idprop");

		String req = "DELETE FROM PROPRIETAIRE WHERE IDPROP = " + idprop;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(req);
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
		response.sendRedirect("/backoffice/prive/chercherprop?idprop=&nom=&prenom=&numpriv=&numtrav=");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
