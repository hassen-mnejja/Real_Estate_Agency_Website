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
 * Servlet implementation class Favoris1
 */
public class Favoris1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Favoris1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setAttribute("id",Utilisateur.id);
		 * this.getServletContext().getRequestDispatcher("/WEB-INF/image.jsp").forward(
		 * request, response);
		 */
		String auto = request.getParameter("auto");
		if (auto == null) {
			Chercher chercher = new Chercher();
			HttpSession session = request.getSession();
			session.setAttribute("Selection", chercher.Selection(request));

			String region = request.getParameter("region");
			String[] bien = request.getParameterValues("bien");
			String budgetmax = request.getParameter("maximum");
			String budgetmin = request.getParameter("minimum");
			String superficiemax = request.getParameter("maxsup");
			String superficiemin = request.getParameter("minsup");
			String[] tab = request.getParameterValues("type");
			// Bien.region=region;
			// type=bien[0];
			// Bien.mode=tab[0];
			session.setAttribute("region", region);
			session.setAttribute("type1", bien[0]);
			session.setAttribute("mode", tab[0]);
			session.setAttribute("budgetmax", budgetmax);
			session.setAttribute("budgetmin", budgetmin);
			session.setAttribute("supmax", superficiemax);
			session.setAttribute("supmin", superficiemin);
		}
		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("nom", Utilisateur.nom + " " + Utilisateur.prenom);
		request.setAttribute("compte", 0);
		this.getServletContext().getRequestDispatcher("/WEB-INF/image1.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
