package changehands.entity;

public class GuestBookBean {
	private int setID=0;
	private int getID=0;
	private int pID;
	private int gID;
	private String Message;// 留言内容
	private String ReleaseTime;// 发布时间
	private String ModifyTime;// 修改时间

	public GuestBookBean() {

	}

	public GuestBookBean(int setID, int getID, int pID, int gID, String Message, String ReleaseTime, String ModifyTime) {
		this.setID = setID;
		this.getID = getID;
		this.pID = pID;
		this.gID = gID;
		this.Message = Message;
		this.ReleaseTime = ReleaseTime;
		this.ModifyTime = ModifyTime;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}
	
	public int getgetID() {
		return getID;
	}

	public void setgetID(int getID) {
		this.getID = getID;
	}
	
	public int getsetID() {
		return setID;
	}

	public void setsetID(int setID) {
		this.setID = setID;
	}
	
	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getReleaseTime() {
		return ReleaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		ReleaseTime = releaseTime;
	}

	public String getModifyTime() {
		return ModifyTime;
	}

	public void setModifyTime(String modifyTime) {
		ModifyTime = modifyTime;
	}
}
