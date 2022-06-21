package agence.backoffice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AjoutBienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutBienServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT idprop FROM PROPRIETAIRE");
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) { ids.add(rs.getInt(1)); }
			request.setAttribute("ids", ids);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		request.getRequestDispatcher("/WEB-INF/bienajouter.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descriptif = "";
		String idprop = "";
		String rue = "";
		String numero = "";
		String codepostal = "";
		String region = "";
		String delegation = "";
		String soumission = "";
		String disposition = "";
		String typebien = "";
		String anbchambres = "";
		String anbgarages = "";
		String aascenseur = "";
		String anetage = "";
		String asjardin = "";
		String astotale = "";
		String mnbchambres = "";
		String mnbgarages = "";
		String nbetages = "";
		String msjardin = "";
		String mstotale = "";
		String sstotale = "";
		String sascenseur = "";
		String snetage = "";
		String emstotale = "";
		String nbpieces = "";
		String tstotale = "";
		String affectation = "";
		String enstotale = "";
		String equip1 = "";
		String equip2 = "";
		String equip3 = "";
		String modeoffre = "";
		String prixdemande = "";
		String etat = "";
		String caution = "";
		String loyer = "";
		String charges = "";
		String typebail = "";
		String meuble = "";
		String superficie = "";
		ArrayList<String> caracs = new ArrayList<String>();
		for (int i = 1; i < 11; i++) { caracs.add(""); }
		ArrayList<FileItem> images = new ArrayList<FileItem>();
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) { return; }
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext())
				return;
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					System.out.println(name + " : " + value);
					switch (name) {
					case "descriptif":
						descriptif = value;
						break;
					case "idprop":
						idprop = value;
						break;
					case "rue":
						rue = value;
						break;
					case "numero":
						numero = value;
						break;
					case "codepostal":
						codepostal = value;
						break;
					case "region":
						region = value;
						break;
					case "delegation":
						delegation = value;
						break;
					case "soumission":
						soumission = value;
						break;
					case "disposition":
						disposition = value;
						break;
					case "typebien":
						typebien = value;
						break;
					case "anbchambres":
						anbchambres = value;
						break;
					case "anbgarages":
						anbgarages = value;
						break;
					case "aascenseur":
						aascenseur = value;
						break;
					case "anetage":
						anetage = value;
						break;
					case "asjardin":
						asjardin = value;
						break;
					case "astotale":
						astotale = value;
						break;
					case "mnbchambres":
						mnbchambres = value;
						break;
					case "mnbgarages":
						mnbgarages = value;
						break;
					case "nbetages":
						nbetages = value;
						break;
					case "msjardin":
						msjardin = value;
						break;
					case "mstotale":
						mstotale = value;
						break;
					case "sstotale":
						sstotale = value;
						break;
					case "sascenseur":
						sascenseur = value;
						break;
					case "snetage":
						snetage = value;
						break;
					case "emstotale":
						emstotale = value;
						break;
					case "nbpieces":
						nbpieces = value;
						break;
					case "tstotale":
						tstotale = value;
						break;
					case "affectation":
						affectation = value;
						break;
					case "enstotale":
						enstotale = value;
						break;
					case "equip1":
						equip1 = value;
						break;
					case "equip2":
						equip2 = value;
						break;
					case "equip3":
						equip3 = value;
						break;
					case "modeoffre":
						modeoffre = value;
						break;
					case "prixdemande":
						prixdemande = value;
						break;
					case "etat":
						etat = value;
						break;
					case "caution":
						caution = value;
						break;
					case "loyer":
						loyer = value;
						break;
					case "charges":
						charges = value;
						break;
					case "typebail":
						typebail = value;
						break;
					case "meuble":
						meuble = value;
						break;
					case "superficie":
						superficie = value;
						break;
					}
					for (int k = 0; k < caracs.size(); k++) {
						int pos = k + 1;
						if (("carac" + pos).equals(name)) { caracs.set(k, value); }
					}
				} else if (fileItem.getSize() > 0) { images.add(fileItem); }
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		Connection con = null;
		try {
			String carac = "";
			for (int k = 0; k < caracs.size(); k++) {
				if (!(caracs.get(k).equals("")))
					carac = carac + caracs.get(k) + "/";
			}
			if (!(carac.length() == 0))
				carac = carac.substring(0, carac.length() - 1);
			System.out.println("carac : " + carac);
			String equip = "";
			if (!(equip1.equals("")))
				equip = equip + equip1 + "/";
			if (!(equip2.equals("")))
				equip = equip + equip2 + "/";
			if (!(equip3.equals("")))
				equip = equip + equip3 + "/";
			if (!(equip.length() == 0))
				equip = equip.substring(0, equip.length() - 1);
			System.out.println("equip : " + equip);
			int nbimages = images.size();
			int idbien = ajoutbien(descriptif, idprop, rue, numero, codepostal, region, delegation, soumission, disposition, typebien, carac, modeoffre, nbimages, prixdemande, etat, caution, loyer, charges, typebail, meuble, superficie);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			if (typebien.equals("t1")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO APPARTEMENT (IDBIEN,NBCHAMBRES,NBGARAGES,NETAGE,ASCENSEUR,STOTALE,SJARDIN) values (?,?,?,?,?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(anbchambres));
				pstmt.setInt(3, Integer.parseInt(anbgarages));
				pstmt.setInt(4, Integer.parseInt(anetage));
				pstmt.setString(5, aascenseur);
				pstmt.setInt(6, Integer.parseInt(astotale));
				pstmt.setInt(7, Integer.parseInt(asjardin));
				pstmt.executeUpdate();
			} else if (typebien.equals("t2")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO EMPLACEMENT (IDBIEN,STOTALE,NBPIECES) values (?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(emstotale));
				pstmt.setInt(3, Integer.parseInt(nbpieces));
				pstmt.executeUpdate();
			} else if (typebien.equals("t3")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO MAISON (IDBIEN,NBCHAMBRES,NBGARAGES,NBETAGES,STOTALE,SJARDIN) values (?,?,?,?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(mnbchambres));
				pstmt.setInt(3, Integer.parseInt(mnbgarages));
				pstmt.setInt(4, Integer.parseInt(nbetages));
				pstmt.setInt(5, Integer.parseInt(mstotale));
				pstmt.setInt(6, Integer.parseInt(msjardin));
				pstmt.executeUpdate();
			} else if (typebien.equals("t4")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO STUDIO (IDBIEN,NETAGE,ASCENSEUR,STOTALE) values (?,?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(snetage));
				pstmt.setString(3, sascenseur);
				pstmt.setInt(4, Integer.parseInt(sstotale));
				pstmt.executeUpdate();
			} else if (typebien.equals("t5")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO TERRAIN (IDBIEN,STOTALE,AFFECTATION) values (?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(tstotale));
				pstmt.setString(3, affectation);
				pstmt.executeUpdate();
			} else if (typebien.equals("t6")) {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO ENTREPOT (IDBIEN,STOTALE,EQUIPEMENT) values (?,?,?)");
				pstmt.setInt(1, idbien);
				pstmt.setInt(2, Integer.parseInt(enstotale));
				pstmt.setString(3, equip);
				pstmt.executeUpdate();
			}
			int i = 0;
			for (FileItem item : images) {
				File path = new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Bien\\" + idbien + "\\");
				if (!path.exists()) { path.mkdirs(); }
				i = i + 1;
				item.write(new File("E:\\Formation\\Workspace java2\\backoffice\\WebContent\\Images\\Bien\\" + idbien + "\\" + idbien + "-" + i + ".jpg"));
			}
			response.sendRedirect("/backoffice/prive/chercherbien");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	int ajoutbien(String descriptif, String idprop, String rue, String numero, String codepostal, String region, String delegation, String soumission, String disposition, String typebien, String carac, String modeoffre, int nbimages,
			String prixdemande, String etat, String caution, String loyer, String charges, String typebail, String meuble, String superficie) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		int idbien = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dataServerURL = "jdbc:mysql://localhost:3306/agence";
			con = DriverManager.getConnection(dataServerURL, "root", "");
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO BIEN (DESCRIPTIF,IDPROP,RUE,NUMERO,CODEPOSTAL,REGION,DELEGATION,SOUMISSION,DISPOSITION,TYPEBIEN,CARAC,MODEOFFRE,NBIMAGES,PRIXDEMANDE,ETAT,CAUTION,LOYER,CHARGES,TYPEBAIL,MEUBLE,STATUT,SUPERFICIE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new String[] { "IDBIEN" });
			pstmt.setString(1, descriptif);
			pstmt.setInt(2, Integer.parseInt(idprop));
			pstmt.setString(3, rue);
			pstmt.setInt(4, Integer.parseInt(numero));
			pstmt.setInt(5, Integer.parseInt(codepostal));
			pstmt.setString(6, region);
			pstmt.setString(7, delegation);
			pstmt.setString(8, soumission);
			pstmt.setString(9, disposition);
			switch (typebien) {
			case "t1":
				pstmt.setString(10, "Appartement");
				break;
			case "t2":
				pstmt.setString(10, "Emplacement");
				break;
			case "t3":
				pstmt.setString(10, "Maison");
				break;
			case "t4":
				pstmt.setString(10, "Studio");
				break;
			case "t5":
				pstmt.setString(10, "Terrain");
				break;
			case "t6":
				pstmt.setString(10, "Entrepot");
				break;
			}
			pstmt.setString(11, carac);
			switch (modeoffre) {
			case "m1":
				pstmt.setString(12, "A Vendre");
				break;
			case "m2":
				pstmt.setString(12, "A Louer");
				break;
			}
			pstmt.setInt(13, nbimages);
			pstmt.setInt(14, Integer.parseInt(prixdemande));
			pstmt.setString(15, etat);
			pstmt.setInt(16, Integer.parseInt(caution));
			pstmt.setInt(17, Integer.parseInt(loyer));
			pstmt.setInt(18, Integer.parseInt(charges));
			pstmt.setString(19, typebail);
			pstmt.setString(20, meuble);
			pstmt.setString(21, "Disponible");
			pstmt.setInt(22, Integer.parseInt(superficie));
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) { idbien = rs.getInt(1); }
			System.out.println("idbien : " + idbien);
			return idbien;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
