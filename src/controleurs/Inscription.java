package controleurs;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeles.ConnexionBDD;
import modeles.InscriptionModel;
import modeles.User;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Statement St;
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException {
		//getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		ConnexionBDD conn = new ConnexionBDD();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("formInscription.jsp").forward(request, response);
		request.setAttribute("ok", "true");
		request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		InscriptionModel i = new InscriptionModel();
		
		String spseudo = request.getParameter("username");
		String smotDePasse = request.getParameter("password");
		String semail = request.getParameter("email");
		String sprenom = request.getParameter("prenom");
		String snom = request.getParameter("nom");
		int slangue = 2;
		if(request.getParameter("langue").equals("English") || request.getParameter("langue").equals("--Select a language--")){
			slangue = 2;
		} else {
			slangue = 1;
		}
		
		if(!spseudo.equals("") && !smotDePasse.equals("") && !semail.equals("") && !sprenom.equals("") && !snom.equals("")){
			User u = new User();
			u.setPseudo(spseudo);
			u.setMot_de_passe(smotDePasse);
			u.setEmail(semail);
			u.setPrenom(sprenom);
			u.setNom(snom);
			u.setId_langue(slangue);
			
			try {
				if(i.AjoutUser(u)){
					request.setAttribute("ok", "existe");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				} else {
					request.setAttribute("ok", "false");
					request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("ok", "null");
			request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
		}
		
	}
}
