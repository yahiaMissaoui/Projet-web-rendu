package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountModel {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public User AfficheLoggedUser(int idUser){
		try {
		st = ConnexionBDD.Con.prepareStatement("select * from Utilisateur where id_utilisateur=?");
		st.setInt(1, idUser);
		
		rs = st.executeQuery();
		
		User u = new User();
		
		while (rs.next()) {
			u.setId_Utilisateur(rs.getInt("id_utilisateur"));
			u.setPseudo(rs.getString("pseudo"));
			u.setMot_de_passe(rs.getString("mot_de_passe"));
			u.setEmail(rs.getString("email"));
			u.setPrenom(rs.getString("prenom"));
			u.setNom(rs.getString("nom"));
			u.setId_langue(rs.getInt("id_langue"));
		}
		
		return u;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}

}
