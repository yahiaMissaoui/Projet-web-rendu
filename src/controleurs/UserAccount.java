package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.ConnexionBDD;
import modeles.User;
import modeles.UserAccountModel;

public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserAccount() {
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
		
		UserAccountModel p = new UserAccountModel();
		
		User u = new User();
		u = p.AfficheLoggedUser(idUser);
		
		request.setAttribute("user", u);
		request.getRequestDispatcher("Account.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
