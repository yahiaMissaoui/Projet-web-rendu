package modeles;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscriptionModel {
	
	private PreparedStatement st = null;
	public String ajouter_ok;
	
	public boolean AjoutUser(User u) throws SQLException{
		try{
			st=ConnexionBDD.Con.prepareStatement("insert into mydb.Utilisateur(pseudo,mot_de_passe,nom,prenom,email,id_langue) values (?,?,?,?,?,?)");
			st.setString(1, u.getPseudo());
			st.setString(2, u.getMot_de_passe());
			st.setString(3, u.getNom());
			st.setString(4, u.getPrenom());
			st.setString(5, u.getEmail());
			st.setInt(6, u.getId_langue());

			st.executeUpdate();
			
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("ici");
			return false;
		}
	}

}
