package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Utilisateur;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("id", Utilisateur.id);
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = new Utilisateur();
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String email = request.getParameter("email");

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String tel = request.getParameter("num");
		request.setAttribute("pwd1", pwd1);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("tel", tel);
		request.setAttribute("email", email);
		String Message;
		if (pwd1.equals(pwd2)) {
			u.addClient(request);
			Utilisateur.id = u.dernierligne();
			Message = "succes inscription ";
			request.setAttribute("message", Message);

		} else {
			Message = "inscription echou� , verifier votre mot de passe";
			request.setAttribute("message", Message);
		}
		request.setAttribute("id", Utilisateur.id);
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

}
