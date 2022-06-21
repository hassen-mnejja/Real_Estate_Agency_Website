package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Utilisateur;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		if (utilisateur.identifiant(request) == 0) {
			int nb = 0;
			request.setAttribute("nb", nb);
			request.setAttribute("id", utilisateur.identifiant(request));
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		} else {
			request.setAttribute("id", utilisateur.identifiant(request));
			request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
			this.getServletContext().getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}