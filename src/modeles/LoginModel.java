package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginModel {

	private PreparedStatement st = null;
	private ResultSet rs = null;

	public ArrayList<User> RechercheUser(User user) {
		ArrayList<User> liste = new ArrayList<User>();
		try {
			st = ConnexionBDD.Con.prepareStatement("select * from Utilisateur where pseudo=? and mot_de_passe=?");
			st.setString(1, user.getPseudo());
			st.setString(2, user.getMot_de_passe());

			rs = st.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setId_Utilisateur(rs.getInt("id_utilisateur"));
				u.setPseudo(rs.getString("pseudo"));
				u.setMot_de_passe(rs.getString("mot_de_passe"));	
				u.setEmail(rs.getString("email"));
				u.setPrenom(rs.getString("prenom"));
				u.setNom(rs.getString("nom"));
				u.setId_langue(rs.getInt("id_langue"));

				liste.add(u);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return liste;
	}

}
