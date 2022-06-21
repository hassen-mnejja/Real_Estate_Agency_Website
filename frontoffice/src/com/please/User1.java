package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Favor;
import com.stp.Utilisateur;

/**
 * Servlet implementation class User1
 */
public class User1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User1() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Favor favor = new Favor();

		if (Utilisateur.id != 0) {
			favor.inserer(Utilisateur.id, Utilisateur.bien);
			int r = 0;
			request.setAttribute("r", r);
			request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
			request.setAttribute("id", Utilisateur.id);

			this.getServletContext().getRequestDispatcher("/WEB-INF/plus_info.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login2.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
