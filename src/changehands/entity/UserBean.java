package changehands.entity;

public class UserBean {
	private int ID;
	private String UserName;// 用户名
	private String Password;// 密码
	private String RealName;// 真实姓名
	private String Sex;// 性别
	private int Age;// 年龄
	private String Email;// 邮箱
	private String Mobile;// 手机号
	private String Address;// 宿舍（地址）
	private String HeadPath;// 头像路径
	private String RegTime;// 注册时间

	public UserBean() {

	}

	public UserBean(int ID, String UserName, String Password, String RealName, String Sex, int Age, String Email,
			String Mobile, String Address, String HeadPath, String RegTime) {
		this.ID = ID;
		this.UserName = UserName;
		this.Password = Password;
		this.RealName = RealName;
		this.Sex = Sex;
		this.Age = Age;
		this.Email = Email;
		this.Mobile = Mobile;
		this.Address = Address;
		this.HeadPath = HeadPath;
		this.RegTime = RegTime;
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

	public String getRealName() {
		return RealName;
	}

	public void setRealName(String realName) {
		RealName = realName;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getHeadPath() {
		return HeadPath;
	}

	public void setHeadPath(String headPath) {
		HeadPath = headPath;
	}

	public String getRegTime() {
		return RegTime;
	}

	public void setRegTime(String regTime) {
		RegTime = regTime;
	}
}
