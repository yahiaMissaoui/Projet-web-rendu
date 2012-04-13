package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchTrackViewModel {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public ArrayList<Track> RecupListOfTrackByTitleName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionBDD.Con.prepareStatement("select ch.id_chanson, ch.titre, ch.label, ch.duree, ch.date_de_sortie, ch.style, ge.id_genre, ge.nom_genre, ar.nom, ar.id_artiste, alb.id_album, alb.titre " +
												"from Chanson ch, Album alb, Artiste ar, Genre ge, ordre_chanson_album oca " +
												"where ch.titre=? " +
												"and ge.id_genre=ch.id_genre " +
												"and ar.id_artiste=ch.id_artiste " +
												"and oca.album_id_album=alb.id_album " +
												"and oca.chanson_id_chanson=ch.id_chanson");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artiste a = new Artiste();
			Record r = new Record();
			
			track.setId_chanson(rs.getInt("ch.id_chanson"));
			track.setTitre(rs.getString("ch.titre"));
			track.setStyle(rs.getString("ch.style"));
			track.setLabel(rs.getString("ch.label"));
			track.setDuree(rs.getTime("ch.duree"));
			track.setDate_de_sortie(rs.getDate("tr.release_date"));
			
			a.setNom(rs.getString("ar.name"));
			a.setId_artiste(rs.getInt("ar.id"));
			track.setArtiste(a);
			
			r.setId(rs.getInt("alb.id_album"));
			r.setName(rs.getString("alb.titre"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	public ArrayList<Track> RecupListOfTrackByFullText(String text){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionBDD.Con.prepareStatement("select ch.id_chanson, ch.titre, ch.label, ch.duree, ch.date_de_sortie, ch.style, ge.id_genre, ge.nom_genre, ar.nom, ar.id_artiste, alb.id_album, alb.titre " +
				"from Chanson ch, Album alb, Artiste ar, Genre ge, ordre_chanson_album oca " +
												"where (ch.titre=? " +
												"or ch.label=? " +
												"or ge.nom_genre=? " +
												"or ar.nom=? " +
												"or alb.titre=?)" +
												"and ge.id_genre=ch.id_genre " +
												"and ar.id_artiste=ch.id_artiste " +
												"and oca.album_id_album=alb.id_album " +
												"and oca.chanson_id_chanson=ch.id_chanson");

		st.setString(1, text);
		st.setString(2, text);
		st.setString(3, text);
		st.setString(4, text);
		st.setString(5, text);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artiste a = new Artiste();
			Record r = new Record();
			
			track.setId_chanson(rs.getInt("ch.id_chanson"));
			track.setTitre(rs.getString("ch.titre"));
			track.setStyle(rs.getString("ch.style"));
			track.setLabel(rs.getString("ch.label"));
			track.setDuree(rs.getTime("ch.duree"));
			track.setDate_de_sortie(rs.getDate("tr.release_date"));
			
			a.setNom(rs.getString("ar.name"));
			a.setId_artiste(rs.getInt("ar.id"));
			track.setArtiste(a);
			/*
			r.setId(rs.getInt("alb.id_album"));
			r.setName(rs.getString("alb.titre"));
			track.setRecord(r);
*/
			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	public ArrayList<Track> RecupListOfTrackByPersonName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionBDD.Con.prepareStatement("select ch.id_chanson, ch.titre, ch.label, ch.duree, ch.date_de_sortie, ch.style, ge.id_genre, ge.nom_genre, ar.nom, ar.id_artiste, alb.id_album, alb.titre " +
				"from Chanson ch, Album alb, Artiste ar, Genre ge, ordre_chanson_album oca " +
												"where ar.nom=? " +
												"and ge.id_genre=ch.id_genre " +
												"and ar.id_artiste=ch.id_artiste " +
												"and oca.album_id_album=alb.id_album " +
												"and oca.chanson_id_chanson=ch.id_chanson");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artiste a = new Artiste();
			Record r = new Record();
			
			track.setId_chanson(rs.getInt("ch.id_chanson"));
			track.setTitre(rs.getString("ch.titre"));
			track.setStyle(rs.getString("ch.style"));
			track.setLabel(rs.getString("ch.label"));
			track.setDuree(rs.getTime("ch.duree"));
			track.setDate_de_sortie(rs.getDate("tr.release_date"));
			
			a.setNom(rs.getString("ar.name"));
			a.setId_artiste(rs.getInt("ar.id"));
			track.setArtiste(a);
			
			r.setId(rs.getInt("alb.id_album"));
			r.setName(rs.getString("alb.titre"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	public ArrayList<Track> RecupListOfTrackByRecordName(String name){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionBDD.Con.prepareStatement("select ch.id_chanson, ch.titre, ch.label, ch.duree, ch.date_de_sortie, ch.style, ge.id_genre, ge.nom_genre, ar.nom, ar.id_artiste, alb.id_album, alb.titre " +
				"from Chanson ch, Album alb, Artiste ar, Genre ge, ordre_chanson_album oca " +
												"where alb.titre=? " +
												"and ge.id_genre=ch.id_genre " +
												"and ar.id_artiste=ch.id_artiste " +
												"and oca.album_id_album=alb.id_album " +
												"and oca.chanson_id_chanson=ch.id_chanson");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artiste a = new Artiste();
			Record r = new Record();
			
			track.setId_chanson(rs.getInt("ch.id_chanson"));
			track.setTitre(rs.getString("ch.titre"));
			track.setStyle(rs.getString("ch.style"));
			track.setLabel(rs.getString("ch.label"));
			track.setDuree(rs.getTime("ch.duree"));
			track.setDate_de_sortie(rs.getDate("tr.release_date"));
			
			a.setNom(rs.getString("ar.name"));
			a.setId_artiste(rs.getInt("ar.id"));
			track.setArtiste(a);
			
			r.setId(rs.getInt("alb.id_album"));
			r.setName(rs.getString("alb.titre"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	
	public ArrayList<Track> RecupListOfAllTrack(){
		
		ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
		
		try {
		st = ConnexionBDD.Con.prepareStatement("select ch.id_chanson, ch.titre, ch.label, ch.duree, ch.date_de_sortie, ch.style, ge.id_genre, ge.nom_genre, ar.nom, ar.id_artiste, alb.id_album, alb.titre " +
				"from Chanson ch, Album alb, Artiste ar, Genre ge, ordre_chanson_album oca " +
												"where st.id=tr.Style_id " +
												"and ge.id_genre=ch.id_genre " +
												"and ar.id_artiste=ch.id_artiste " +
												"and oca.album_id_album=alb.id_album " +
												"and oca.chanson_id_chanson=ch.id_chanson");
		
		rs = st.executeQuery();
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Track track = new Track();
			Artiste a = new Artiste();
			Record r = new Record();
			
			track.setId_chanson(rs.getInt("ch.id_chanson"));
			track.setTitre(rs.getString("ch.titre"));
			track.setStyle(rs.getString("ch.style"));
			track.setLabel(rs.getString("ch.label"));
			track.setDuree(rs.getTime("ch.duree"));
			track.setDate_de_sortie(rs.getDate("tr.release_date"));
			
			a.setNom(rs.getString("ar.name"));
			a.setId_artiste(rs.getInt("ar.id"));
			track.setArtiste(a);
			
			r.setId(rs.getInt("alb.id_album"));
			r.setName(rs.getString("alb.titre"));
			track.setRecord(r);

			arrayOfTrack.add(track);
		}
		
		return arrayOfTrack;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
	
	

}
