package com.please;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stp.Chercher;
import com.stp.Utilisateur;

public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Image() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("id", Utilisateur.id);

		List<String> lieu = new ArrayList<String>();
		lieu.add("Tunis");
		lieu.add("Djerba");
		lieu.add("Nabeul");
		lieu.add("Sfax");
		lieu.add("Sidi Bouzid");
		lieu.add("Siliana");
		lieu.add("Sousse");
		lieu.add("Tataouine");
		lieu.add("Tozeur");
		lieu.add("Zaghouan");
		lieu.add("Ariana");
		lieu.add("Ben Arous");
		lieu.add("Bizerte");
		lieu.add("Beja");
		lieu.add("El Kasserine");
		lieu.add("Gabes");
		lieu.add("Gafsa");
		lieu.add("Jendouba");
		lieu.add("Kairouan");
		lieu.add("Kebili");
		lieu.add("La Manouba");
		lieu.add("Le Kef");
		lieu.add("Mahdia");
		lieu.add("Mednine");
		lieu.add("Monastir");
		List<String> Type = new ArrayList<String>();
		Type.add("Appartement");
		Type.add("Maison");
		Type.add("Studio");
		Type.add("Emplacement");
		Type.add("Entrepot");
		Type.add("Terrain");
		HttpSession session = request.getSession();
		session.setAttribute("lieu", lieu);
		session.setAttribute("type", Type);
		Chercher chercher = new Chercher();
		session.setAttribute("tous", chercher.Tout());
		session.setAttribute("taille", chercher.Tout().size());
		session.setAttribute("verif", Chercher.verif);
		String nombre = request.getParameter("nombre");
		session.setAttribute("nombre", nombre);
		String nombre1 = request.getParameter("nombre1");
		session.setAttribute("nombre1", nombre1);
		this.getServletContext().getRequestDispatcher("/WEB-INF/image.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Chercher chercher = new Chercher();
		HttpSession session = request.getSession();
		session.setAttribute("Selection", chercher.Selection(request));
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		request.setAttribute("id", Utilisateur.id);

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
		/*
		 * if(chercher.Selection(request).isEmpty()) request.setAttribute("chaineee",
		 * "empty");
		 */
		this.getServletContext().getRequestDispatcher("/WEB-INF/image1.jsp").forward(request, response);

	}

}