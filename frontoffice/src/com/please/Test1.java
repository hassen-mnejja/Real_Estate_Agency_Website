package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stp.Chercher;
import com.stp.Favor;
import com.stp.Utilisateur;

/**
 * Servlet implementation class Test1
 */
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test1() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cliqued = request.getParameter("clique");
		String typebien = "";
		Utilisateur.bien = Integer.parseInt(cliqued);
		Utilisateur.entrer = 1;
		Favor favor = new Favor();
		if (Utilisateur.id != 0) {
			if (favor.Chercher(Utilisateur.id, Integer.parseInt(cliqued)).equals("oui")) {
				int r = 0;
				request.setAttribute("r", r);
			}
			if (favor.Chercher(Utilisateur.id, Integer.parseInt(cliqued)).equals("non")) {
				int b = 0;
				request.setAttribute("b", b);

			}
		} else {
			int b = 0;
			request.setAttribute("b", b);
		}
		HttpSession session = request.getSession();
		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		session.setAttribute("cliqued", cliqued);
		session.setAttribute("entrer", Utilisateur.entrer);
		Chercher chercher = new Chercher();
		for (String[] l : chercher.Tout()) {
			if (l[0].equals(cliqued)) {
				session.setAttribute("nombree", l[5]);
				typebien = l[18];
				session.setAttribute("typebien", l[18]);
				session.setAttribute("description", l[4]);
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
		session.setAttribute("more", chercher.type_bien(Utilisateur.bien, typebien));
		if (typebien.equals("Entrepot")) { session.setAttribute("equipement", chercher.type_bien(Utilisateur.bien, typebien)[1].split("/")); }
		if (typebien.equals("Terrain")) { session.setAttribute("condition", "Terrain"); }
		/* session.setAttribute("tb",Chercher.typebien); */
		this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		Favor favor = new Favor();
		int id = utilisateur.identifiant(request);
		if (Utilisateur.id != 0) {
			if (favor.Chercher(id, Utilisateur.bien).equals("oui")) {
				int r = 0;
				request.setAttribute("r", r);
			}
			if (favor.Chercher(id, Utilisateur.bien).equals("non")) {
				int b = 0;
				request.setAttribute("b", b);

			}
		} else {
			int b = 0;
			request.setAttribute("b", b);
		}

		request.setAttribute("id", id);
		int nb = 0;
		request.setAttribute("nb", nb);
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);
	}

}
