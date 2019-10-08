package changehands.entity;

public class AdminBean {
	private int ID;
	private String UserName;// 用户名
	private String Password;// 密码

	public AdminBean() {

	}

	public AdminBean(int ID, String UserName, String Password) {
		this.ID = ID;
		this.UserName = UserName;
		this.Password = Password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
