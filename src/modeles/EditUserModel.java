package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditUserModel {
	
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
	
	
	public void ModifUser(User u, int id) throws SQLException{
		try{
			st=ConnexionBDD.Con.prepareStatement("update mydb.Utilisateur set pseudo=?, email=?, prenom=?, nom=?, id_langue=? where id_utilisateur=?");
			st.setString(1, u.getPseudo());
			st.setString(2, u.getEmail());
			st.setString(3, u.getPrenom());
			st.setString(4, u.getNom());
			st.setInt(5, u.getId_langue());
			st.setInt(6, id);

			st.executeUpdate();
		}
		catch(Exception E){
			System.out.println("Erreurs dans la requte d'inscription");
		}
	}
	

}
