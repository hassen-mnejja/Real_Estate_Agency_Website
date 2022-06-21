package agence.backoffice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimeBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SupprimeBienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbien = request.getParameter("idbien");
		String typebien = getType(idbien);
		String req = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			switch (typebien) {
			case "Appartement":
				req = "DELETE FROM APPARTEMENT WHERE IDBIEN=" + idbien;
				break;
			case "Maison":
				req = "DELETE FROM MAISON WHERE IDBIEN=" + idbien;
				break;
			case "Studio":
				req = "DELETE FROM STUDIO WHERE IDBIEN=" + idbien;
				break;
			case "Terrain":
				req = "DELETE FROM TERRAIN WHERE IDBIEN=" + idbien;
				break;
			case "Entrepot":
				req = "DELETE FROM ENTREPOT WHERE IDBIEN=" + idbien;
				break;
			case "Emplacement":
				req = "DELETE FROM EMPLACEMENT WHERE IDBIEN=" + idbien;
				break;
			}
			stmt.executeUpdate(req);
			supprimecontrat(idbien);
			supprimevisite(idbien);
			supprimefavoris(idbien);
			supprimebien(idbien);
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
		File path = new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Bien\\" + idbien + "\\");
		deleteFile(path);
		response.sendRedirect("/backoffice/prive/chercherbien");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	public static void deleteFile(File element) {
		if (element.exists()) { if (element.isDirectory()) { for (File sub : element.listFiles()) { deleteFile(sub); } } }
		element.delete();
	}

	private String getType(String idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT TYPEBIEN FROM BIEN WHERE IDBIEN=" + idbien);
			String type = "";
			if (rs.next()) { type = rs.getString("TYPEBIEN"); }
			return type;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
			return null;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

	private void supprimebien(String idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM BIEN WHERE IDBIEN=" + idbien;
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

	private void supprimecontrat(String idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM CONTRAT WHERE IDBIEN=" + idbien;
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

	private void supprimevisite(String idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM VISITE WHERE IDBIEN=" + idbien;
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

	private void supprimefavoris(String idbien) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement stmt = con.createStatement();
			String req = "DELETE FROM FAVORIS WHERE IDBIEN=" + idbien;
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
