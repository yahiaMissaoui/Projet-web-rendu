package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnRecordModel {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public ArrayList<Record> recupOwnedRecord(int idUser){
		ArrayList<Record> arrayOfRecord = new ArrayList<Record>();
		
		try {
			st = ConnexionBDD.Con.prepareStatement("select re.id, re.name, re.matrix_number, re.PressInfo_id, re.TypeRecord_id, re.VinyleSize_id, tre.name, vs.name, pi.name " +
													"from Record re, TypeRecord tre, VinyleSize vs, PressInfo pi, User_has_Record uhr " +
													"where uhr.User_id=? " +
													"and re.id=uhr.Record_id " +
													"and tre.id=re.TypeRecord_id " +
													"and vs.id=re.VinyleSize_id " +
													"and pi.id=re.PressInfo_id ");
			st.setInt(1, idUser);
			
			rs = st.executeQuery();
			
			while (rs.next()) {
				Record record = new Record();
				
				record.setId(rs.getInt("re.id"));
				record.setName(rs.getString("re.name"));
				record.setMatrix_number(rs.getString("re.matrix_number"));
				record.setPressInfo(rs.getString("pi.name"));
				record.setTypeRecord(rs.getString("tre.name"));
				record.setVinyleSize(rs.getInt("vs.name"));
				
				arrayOfRecord.add(record);
			}
			
			return arrayOfRecord;
			
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
			return null;
		
	}

}
