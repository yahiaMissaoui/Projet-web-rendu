package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.ConnexionBDD;
import modeles.LoginModel;
import modeles.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> liste = null;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionBDD conn = new ConnexionBDD();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String lien=request.getParameter("lien");
		
		if(lien != null){
			if(lien.equals("logoff"))
			{
				liste.clear();
				session.setAttribute("liste", liste);
				request.setAttribute("ok", "exist");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("ok", "exist");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		LoginModel l = new LoginModel();

		String user = request.getParameter("pseudo");
		String mdp = request.getParameter("motdepasse");

		User u = new User();
		u.setPseudo(user);
		u.setMot_de_passe(mdp);

		liste = l.RechercheUser(u);
		if (liste.size() != 0) {
			session.setAttribute("listes",liste);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("ok", "notExist");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}
}
