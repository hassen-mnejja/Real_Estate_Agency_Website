package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Utilisateur;

public class Personnel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Personnel() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pwd1", Utilisateur.password);
		request.setAttribute("nom", Utilisateur.nom);
		request.setAttribute("prenom", Utilisateur.prenom);
		request.setAttribute("numtel", Utilisateur.numtel);
		request.setAttribute("email", Utilisateur.email);
		request.setAttribute("id", Utilisateur.id);
		request.getRequestDispatcher("/WEB-INF/personnel.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd1");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String tel = request.getParameter("num");
		String message;
		if (email == null && pwd == null && nom == null && prenom == null && tel == null) {
			message = "entrez-vous votre nouveaux coordonnes ";
		} else {
			Utilisateur u = new Utilisateur();
			boolean flag = u.UpdateClient(request);
			if (flag) {
				message = "la mise a jour est valid�";
				Utilisateur.email = request.getParameter("email");
				Utilisateur.password = request.getParameter("pwd1");
				Utilisateur.nom = request.getParameter("nom");
				Utilisateur.numtel = request.getParameter("num");
				// request.setAttribute("message", message);
			} else {
				message = "La mises a jour est echou� !! ";
				// request.setAttribute("message", message);
			}
		}
		request.setAttribute("pwd1", Utilisateur.password);
		request.setAttribute("nom", Utilisateur.nom);
		request.setAttribute("prenom", Utilisateur.prenom);
		request.setAttribute("numtel", Utilisateur.numtel);
		request.setAttribute("email", Utilisateur.email);
		request.setAttribute("message", message);
		request.setAttribute("id", Utilisateur.id);
		request.getRequestDispatcher("/WEB-INF/personnel.jsp").forward(request, response);
	}

}
