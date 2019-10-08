package changehands.entity;

import java.math.BigDecimal;

public class ProductBean {
	private int ID;
	private int pID;
	private boolean Flag;// 标识
	private String TradeName;// 名称
	private String Describes;// 描述
	private BigDecimal Price;// 价格
	private int Number;// 数量
	private String ShowPath;// 展示图路径
	private int fID;
	private String AddTime;// 添加时间

	public ProductBean() {

	}

	public ProductBean(int ID, int pID, boolean Flag, String TradeName, String Describes, BigDecimal Price, int Number,
			String ShowPath, int fID, String AddTime) {
		this.ID = ID;
		this.pID = pID;
		this.Flag = Flag;
		this.TradeName = TradeName;
		this.Describes = Describes;
		this.Price = Price;
		this.Number = Number;
		this.ShowPath = ShowPath;
		this.fID = fID;
		this.AddTime = AddTime;
	}

	public int getfID() {
		return fID;
	}

	public void setfID(int fID) {
		this.fID = fID;
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

	public boolean getFlag() {
		return Flag;
	}

	public void setFlag(boolean flag) {
		Flag = flag;
	}

	public String getTradeName() {
		return TradeName;
	}

	public void setTradeName(String tradeName) {
		TradeName = tradeName;
	}

	public String getDescribes() {
		return Describes;
	}

	public void setDescribes(String describes) {
		Describes = describes;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public String getShowPath() {
		return ShowPath;
	}

	public void setShowPath(String showPath) {
		ShowPath = showPath;
	}

	public String getAddTime() {
		return AddTime;
	}

	public void setAddTime(String addTime) {
		AddTime = addTime;
	}
}
