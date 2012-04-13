package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modeles.ConnexionBDD;
import modeles.Record;
import modeles.SearchTrackViewModel;
import modeles.Track;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Search() {
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
		
		String srecherche = request.getParameter("recherche");
		String styleRecherche = request.getParameter("menu");
		String filterRecherche = request.getParameter("filter");
		

			SearchTrackViewModel rtvm = new SearchTrackViewModel();
			ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
			

			if(filterRecherche == null || filterRecherche.equals("none")){
				arrayOfTrack = rtvm.RecupListOfTrackByFullText(srecherche);
			} else if(filterRecherche.equals("track")){
				arrayOfTrack = rtvm.RecupListOfTrackByTitleName(srecherche);
			} else if(filterRecherche.equals("artiste")){
				arrayOfTrack = rtvm.RecupListOfTrackByPersonName(srecherche);
			} else if(filterRecherche.equals("record")){
				arrayOfTrack = rtvm.RecupListOfTrackByRecordName(srecherche);
			}

			request.setAttribute("arrayOfTrack", arrayOfTrack);
			request.getRequestDispatcher("SearchTrackView.jsp").forward(request, response);
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
