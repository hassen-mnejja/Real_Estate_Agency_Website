package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutPropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutPropServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String numpriv = request.getParameter("numpriv");
		String numtrav = request.getParameter("numtrav");
		String debutdispo = request.getParameter("debutdispo");
		String findispo = request.getParameter("findispo");
		String adress = request.getParameter("adress");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO PROPRIETAIRE (NOM,PRENOM,ADRESS,NUMPRIV,NUMTRAV,DEBUTDISPO,FINDISPO) values (?,?,?,?,?,?,?)", new String[] { "IDPROP" });
			pstmt.setString(1, nom);
			pstmt.setString(2, prenom);
			pstmt.setString(3, adress);
			pstmt.setString(4, numpriv);
			pstmt.setString(5, numtrav);
			pstmt.setString(6, debutdispo);
			pstmt.setString(7, findispo);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			int idProp = 0;
			if (rs.next()) { idProp = rs.getInt(1); }
			response.sendRedirect("/backoffice/prive/descriptifprop?identifiant=" + idProp);
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
