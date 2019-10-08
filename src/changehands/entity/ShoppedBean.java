package changehands.entity;

public class ShoppedBean {
	private int ID;
	private int pID;
	private int sID;// 主键
	private int Number;// 数量
	private String ShopTime;// 添加时间

	public ShoppedBean() {

	}

	public ShoppedBean(int ID, int pID, int sID, int Number, String ShopTime) {
		this.ID = ID;
		this.pID = pID;
		this.sID = sID;
		this.Number = Number;
		this.ShopTime = ShopTime;
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

	public String getShopTime() {
		return ShopTime;
	}

	public void setShopTime(String shopTime) {
		ShopTime = shopTime;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

}
