package modeles;

import java.util.Date;

public class Track {
	
	private int id_chanson;	
	private String titre;
	private String label;
	private Date duree;
	private Date date_de_sortie;
	private String style;
	private Record record;
	private Artiste artiste;


	public int getId_chanson() {
		return id_chanson;
	}
	public void setId_chanson(int id_chanson) {
		this.id_chanson = id_chanson;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDuree() {
		return duree;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}
	public Date getDate_de_sortie() {
		return date_de_sortie;
	}
	public void setDate_de_sortie(Date date_de_sortie) {
		this.date_de_sortie = date_de_sortie;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public Artiste getArtiste() {
		return artiste;
	}
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}


}
