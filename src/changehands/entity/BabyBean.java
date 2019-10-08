package changehands.entity;

public class BabyBean {
	private int ID;
	private int pID;
	private int bID;
	private String AddTime;// 添加时间

	public BabyBean(){
		
	}
	
	public BabyBean(int ID, int pID, int bID, String AddTime) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.pID = pID;
		this.bID = bID;
		this.AddTime = AddTime;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getbID() {
		return bID;
	}

	public void setbID(int bID) {
		this.bID = bID;
	}

	public String getAddTime() {
		return AddTime;
	}

	public void setAddTime(String addTime) {
		AddTime = addTime;
	}
	
}
