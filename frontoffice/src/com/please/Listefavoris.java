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
import com.stp.Favor;
import com.stp.Utilisateur;

public class Listefavoris extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Listefavoris() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Favor favor = new Favor();
		HttpSession session = request.getSession();
		String verif = request.getParameter("verif");
		if (verif != null) { favor.effacer(Utilisateur.id, Integer.parseInt(verif)); }
		Chercher chercher = new Chercher();
		List<String[]> favorisclient = new ArrayList<String[]>();
		if (!favor.favoris(Utilisateur.id).isEmpty()) {
			for (String ch : favor.favoris(Utilisateur.id)) { for (String[] l : chercher.toute_la_base()) { if (l[0].equals(ch)) { favorisclient.add(l); } } }
		} else {
			request.setAttribute("ch", "ok");
		}
		Utilisateur.listefavoris = favorisclient;
		request.setAttribute("favoris", favorisclient);
		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("nom", Utilisateur.nom + " " + Utilisateur.prenom);

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

		session.setAttribute("lieu", lieu);
		session.setAttribute("type", Type);

		session.setAttribute("tous", chercher.Tout());
		session.setAttribute("taille", chercher.Tout().size());
		session.setAttribute("verif", Chercher.verif);
		String nombre = request.getParameter("nombre");
		session.setAttribute("nombre", nombre);
		String nombre1 = request.getParameter("nombre1");
		session.setAttribute("nombre1", nombre1);
		this.getServletContext().getRequestDispatcher("/WEB-INF/favoris.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
