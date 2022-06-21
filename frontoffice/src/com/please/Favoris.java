package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Favor;
import com.stp.Utilisateur;

public class Favoris extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Favoris() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utilisateur.entrer == 0) {
			request.setAttribute("id", Utilisateur.id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/image1.jsp").forward(request, response);
		}
		if (Utilisateur.entrer == 1) {
			request.setAttribute("id", Utilisateur.id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/image.jsp").forward(request, response);
		}
		if (Utilisateur.entrer == 2) {
			request.setAttribute("id", Utilisateur.id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Utilisateur.id == 0) {

			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		} else {
			Favor favoris = new Favor();
			favoris.inserer(request);
			request.setAttribute("id", Utilisateur.id);
			int fav = 1;
			request.setAttribute("fav", fav);
			request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
			this.getServletContext().getRequestDispatcher("/WEB-INF/image1.jsp").forward(request, response);
		}
	}

}
