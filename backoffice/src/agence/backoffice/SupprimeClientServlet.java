package agence.backoffice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupprimeClientServlet
 */
public class SupprimeClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimeClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idclient = request.getParameter("idclient");
		String req = "DELETE FROM CLIENT WHERE IDCLIENT =" + idclient;
		supprimevisite(idclient);
		supprimecontrat(idclient);
		supprimefavoris(idclient);
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			System.out.println(req);
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
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
		File path = new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Client\\" + idclient + "\\");
		deleteFile(path);
		response.sendRedirect("/backoffice/prive/chercherclient");
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

	public static void deleteFile(File element) {
		if (element.exists()) { if (element.isDirectory()) { for (File sub : element.listFiles()) { deleteFile(sub); } } }
		element.delete();
	}

	private void supprimecontrat(String idclient) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM CONTRAT WHERE IDCLIENT=" + idclient;
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
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

	private void supprimevisite(String idclient) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM VISITE WHERE IDCLIENT=" + idclient;
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
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

	private void supprimefavoris(String idclient) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM FAVORIS WHERE IDCLIENT=" + idclient;
			stmt.executeUpdate(req);
		} catch (SQLException se) {
			if (!(se.getErrorCode() == 50000) && (se.getSQLState().equals("XJ015")))
				System.out.println(se);
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

}
