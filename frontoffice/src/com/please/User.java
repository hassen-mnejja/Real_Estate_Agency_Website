package com.please;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Utilisateur;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		request.setAttribute("id", utilisateur.identifiant(request));

		int nb = 0;
		request.setAttribute("nb", nb);

		/*
		 * if(Utilisateur.id==0) { /*out.
		 * println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>"
		 * ); out.
		 * println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
		 * ); out.println("<script>"); out.println("$(document).ready(function(){");
		 * out.println("swal('Login','Fail !');"); out.println("});");
		 * out.println("</script>");
		 * 
		 * } else{ /*out.
		 * println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>"
		 * ); out.
		 * println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
		 * ); out.println("<script>"); out.println("$(document).ready(function(){");
		 * out.println("alert ( 'Oops', 'something went wrong!' );");
		 * out.println("});"); out.println("</script>");
		 * 
		 * }
		 */
		request.setAttribute("prenom", Utilisateur.nom + " " + Utilisateur.prenom);
		this.getServletContext().getRequestDispatcher("/WEB-INF/image1.jsp").forward(request, response);
	}

}