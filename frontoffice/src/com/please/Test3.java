package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stp.Chercher;
import com.stp.Utilisateur;

/**
 * Servlet implementation class Test3
 */
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cliqued = request.getParameter("clique");
		String typebien = "";
		Utilisateur.bien = Integer.parseInt(cliqued);
		Utilisateur.entrer = 3;
		HttpSession session = request.getSession();
		session.setAttribute("entrer", Utilisateur.entrer);
		int r = 0;
		request.setAttribute("r", r);

		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		session.setAttribute("cliqued", cliqued);
		for (String[] l : Utilisateur.listefavoris) {
			if (l[0].equals(cliqued)) {
				session.setAttribute("nombree", l[5]);
				typebien = l[18];
				session.setAttribute("typebien", l[18]);
				session.setAttribute("description", l[4]); // edheya test7a9'ha ki bech tzyd fil base de donn�e mtaa bien_immmobilier w
															// taamel boucle for fi plus d'information win fama Emplacement w kol w taawedh
															// bil les valeurs ili mawjoudin f liste
				session.setAttribute("region", Chercher.regionbien);
				session.setAttribute("adresse", l[1]);
				session.setAttribute("code", l[6]);
				session.setAttribute("carac", l[11].split("/"));
				session.setAttribute("modeoffre", l[7]);
				session.setAttribute("prix", l[3]);
				session.setAttribute("numero", l[9]);
				session.setAttribute("rue", l[10]);
				session.setAttribute("etat", l[12]);
				session.setAttribute("caution", l[13]);
				session.setAttribute("loyer", l[14]);
				session.setAttribute("charges", l[15]);
				session.setAttribute("typebail", l[16]);
				session.setAttribute("meuble", l[17]);
				session.setAttribute("date", l[8]);
				break;
			}

		}

		Chercher chercher = new Chercher();
		session.setAttribute("more", chercher.type_bien(Utilisateur.bien, typebien));
		if (typebien.equals("Entrepot")) { session.setAttribute("equipement", chercher.type_bien(Utilisateur.bien, typebien)[1].split("/")); }
		if (typebien.equals("Terrain")) { session.setAttribute("condition", "Terrain"); }
		/* session.setAttribute("tb",Chercher.typebien); */
		this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
