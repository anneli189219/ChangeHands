package changehands.entity;

public class ShoppingBean {
	private int ID;
	private int pID;
	private int Number;// 数量
	private String AddTime;// 添加时间

	public ShoppingBean() {

	}

	public ShoppingBean(int ID, int pID, int Number, String AddTime) {
		this.ID = ID;
		this.pID = pID;
		this.Number = Number;
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

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public String getAddTime() {
		return AddTime;
	}

	public void setAddTime(String addTime) {
		AddTime = addTime;
	}

}
