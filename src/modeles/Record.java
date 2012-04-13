package modeles;

public class Record {
	
	private int id;
	private String matrix_number;
	private String pressInfo;
	private String typeRecord;
	private int vinyleSize;
	private String name;
	
	private int pressInfo_id;
	private int typeRecord_id;
	private int vinyleSize_id;
	
	public String getMatrix_number() {
		return matrix_number;
	}
	public void setMatrix_number(String matrixNumber) {
		matrix_number = matrixNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPressInfo() {
		return pressInfo;
	}
	public void setPressInfo(String pressInfo) {
		this.pressInfo = pressInfo;
	}
	public String getTypeRecord() {
		return typeRecord;
	}
	public void setTypeRecord(String typeRecord) {
		this.typeRecord = typeRecord;
	}
	public int getVinyleSize() {
		return vinyleSize;
	}
	public void setVinyleSize(int vinyleSize) {
		this.vinyleSize = vinyleSize;
	}
	public int getPressInfo_id() {
		return pressInfo_id;
	}
	public void setPressInfo_id(int pressInfoId) {
		pressInfo_id = pressInfoId;
	}
	public int getTypeRecord_id() {
		return typeRecord_id;
	}
	public void setTypeRecord_id(int typeRecordId) {
		typeRecord_id = typeRecordId;
	}
	public int getVinyleSize_id() {
		return vinyleSize_id;
	}
	public void setVinyleSize_id(int vinyleSizeId) {
		vinyleSize_id = vinyleSizeId;
	}

}
