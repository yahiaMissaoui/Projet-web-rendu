package controleurs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.ConnexionBDD;
import modeles.EditUserModel;
import modeles.User;

public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> liste = null;
	
	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionBDD conn = new ConnexionBDD();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int idUser;
		ArrayList<User> liste = (ArrayList<User>) session.getAttribute("listes");
		idUser = liste.get(0).getId_Utilisateur();
		
		EditUserModel e = new EditUserModel();
		
		User u = new User();
		u = e.AfficheLoggedUser(idUser);
		
		request.setAttribute("user", u);
		request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idUser;
		ArrayList<User> liste = (ArrayList<User>) session.getAttribute("listes");
		idUser = liste.get(0).getId_Utilisateur();
		
		EditUserModel eu = new EditUserModel();
		
		String spseudo = request.getParameter("pseudo");
		String semail = request.getParameter("email");
		String sprenom = request.getParameter("prenom");
		String snom = request.getParameter("nom");
		int slangue = 2;
		if(request.getParameter("langue").equals("English")){
			slangue = 2;
		} else {
			slangue = 1;
		}
		
		User u = new User();
		u.setId_Utilisateur(idUser);
		u.setPseudo(spseudo);
		u.setEmail(semail);
		u.setPrenom(sprenom);
		u.setNom(snom);
		u.setId_langue(slangue);
		
		try {
			eu.ModifUser(u, idUser);
			liste.clear();
			liste.add(u);
			session.setAttribute("listes", liste);
			
			request.setAttribute("user", u);
			request.getRequestDispatcher("Account.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
