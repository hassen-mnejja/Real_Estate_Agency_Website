package com.please;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stp.Mess;
import com.stp.MessControler;
import com.stp.MessageModel;
import com.stp.Utilisateur;

/**
 * Servlet implementation class ControleurMessageServlet
 */
public class ControleurMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleurMessageServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageModel model = new MessageModel();
		String message;
		String temps = request.getParameter("temps");
		MessControler Messcont = new MessControler();
		String action = request.getParameter("action");
		String mesg = request.getParameter("mesg");
		request.setAttribute("id", Utilisateur.id);
		request.setAttribute("nom", Utilisateur.nom + " " + Utilisateur.prenom);
		System.out.println(Utilisateur.id);
		if (action != null) {
			if (action.equals("boite du discussion")) {
				List<Mess> messages = Messcont.listMessage(Utilisateur.id); // il faut id du client apres login
				for (Mess msg : messages) { System.out.println(msg.getMessText()); }
				model.setMsgs(messages);
				request.setAttribute("model", model);
			} else if (action.equals("envoyer")) {
				if (mesg != null) {
					Mess m = new Mess();
					m.setMessFromId(Utilisateur.id);// id cleint
					m.setMessToId(0); // admin toujours de id==0
					m.setMessText(mesg);

					m.setSendDate(temps);
					model.setMessage(m);
					Messcont.addMessage(m);
					List<Mess> messages = Messcont.listMessage(Utilisateur.id); // il faut id du client apres login
					model.setMsgs(messages);
					request.setAttribute("model", model);
				} else {
					message = "votre message est vide on ne peut l'envoyer";
					request.setAttribute("message", message);
				}

			} else {
				String MessId = request.getParameter("MessId");
				int id = Integer.parseInt(MessId);
				Messcont.deleteMessage(id);
			}

		}

		request.getRequestDispatcher("/WEB-INF/Mess.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
