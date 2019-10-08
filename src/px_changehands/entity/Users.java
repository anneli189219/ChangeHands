package px_changehands.entity;

public class Users {
	private int id;//id
	private String username;//用户名
	private String password;//密码
	private String realname;//真实姓名
	private String sex;//性别
	private int age;//年龄
	private String email;//邮箱
	private String mobile;//电话
	private String address;//地址
	private String headpath;//头像路径
	private String regtime;//注册时间
	
	public Users(){
		
	}
	public Users(String UserName,
			String RealName,
			String Sex,
			int Age,
			String Email,
			String Mobile,
			String Address){
		this.username = UserName;
		this.realname = RealName;
		this.sex = Sex;
		this.age = Age;
		this.email = Email;
		this.mobile = Mobile;
		this.address = Address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHeadpath() {
		return headpath;
	}
	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	

}
