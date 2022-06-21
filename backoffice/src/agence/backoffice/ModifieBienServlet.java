package agence.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifieBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifieBienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String idbien = request.getParameter("idbien");
		String idprop = request.getParameter("idprop");
		String descriptif = request.getParameter("descriptif");
		String rue = request.getParameter("rue");
		String numero = request.getParameter("numero");
		String codepostal = request.getParameter("codepostal");
		String region = request.getParameter("region");
		String delegation = request.getParameter("delegation");
		String soumission = request.getParameter("soumission");
		String disposition = request.getParameter("disposition");
		ArrayList<String> caracs = new ArrayList<String>();
		for (int i = 1; i < 11; i++) {
			String ch = request.getParameter("carac" + i);
			if (ch != null)
				caracs.add(ch);
		}
		String carac = "";
		for (int k = 0; k < caracs.size(); k++) {
			if (!(caracs.get(k).equals("")))
				carac = carac + caracs.get(k) + "/";
		}
		String typebien = request.getParameter("typebien");
		String modeoffre = request.getParameter("modeoffre");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement("UPDATE BIEN SET IDPROP=?,DESCRIPTIF=?,RUE=?,NUMERO=?,CODEPOSTAL=?,REGION=?,DELEGATION=?,SOUMISSION=?,DISPOSITION=?,CARAC=?,TYPEBIEN=?,MODEOFFRE=? WHERE IDBIEN=" + idbien);
			pstmt.setInt(1, Integer.parseInt(idprop));
			pstmt.setString(2, descriptif);
			pstmt.setString(3, rue);
			pstmt.setInt(4, Integer.parseInt(numero));
			pstmt.setInt(5, Integer.parseInt(codepostal));
			pstmt.setString(6, region);
			pstmt.setString(7, delegation);
			pstmt.setString(8, soumission);
			pstmt.setString(9, disposition);
			pstmt.setString(10, carac);
			pstmt.setString(11, typebien);
			pstmt.setString(12, modeoffre);
			pstmt.executeUpdate();
			response.sendRedirect("/backoffice/prive/descriptifbien?identifiant=" + idbien);
		} catch (Exception e) {
			System.out.println(e.toString());
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
