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
import modeles.Record;
import modeles.User;

public class AddRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AddRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionBDD conn = new ConnexionBDD();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("ok", "true");
		request.getRequestDispatcher("CreateRecord.jsp").forward(request, response);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
