package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Favor;
import com.stp.Utilisateur;

/**
 * Servlet implementation class User2
 */
public class User2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User2() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Favor favor = new Favor();
		favor.effacer(Utilisateur.id, Utilisateur.bien);
		int b = 0;
		request.setAttribute("b", b);
		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
