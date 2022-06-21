package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Favor;
import com.stp.Utilisateur;

/**
 * Servlet implementation class User3
 */
public class User3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User3() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		int id = utilisateur.identifiant(request);
		Favor favor = new Favor();
		if (id != 0) {
			request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
			request.setAttribute("id", id);
			if (favor.Chercher(Utilisateur.id, Utilisateur.bien).equals("oui")) {
				int r = 0;
				request.setAttribute("r", r);
			}
			if (favor.Chercher(Utilisateur.id, Utilisateur.bien).equals("non")) {
				int b = 0;
				request.setAttribute("b", b);

			}
		} else {
			int nb = 0;
			int b = 0;
			request.setAttribute("b", b);
			request.setAttribute("nb", nb);
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/login2.jsp").forward(request, response);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);

	}

}
