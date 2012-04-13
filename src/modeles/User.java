package modeles;

public class User {
	
	private int id_Utilisateur;
	private String pseudo;
	private String mot_de_passe;
	private String email;
	private String prenom;
	private String nom;
	private int id_langue;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId_Utilisateur() {
		return id_Utilisateur;
	}
	public void setId_Utilisateur(int id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}
	public int getId_langue() {
		return id_langue;
	}
	public void setId_langue(int id_langue) {
		this.id_langue = id_langue;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	
}
