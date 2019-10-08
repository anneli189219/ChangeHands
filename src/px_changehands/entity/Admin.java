package px_changehands.entity;

public class Admin {
	private int id;
	private String adminname;
	private String adminpassword;
	
	public Admin(){
		
	}
	public Admin(int ID, String AdminName){
		this.id = ID;
		this.adminname = AdminName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}
