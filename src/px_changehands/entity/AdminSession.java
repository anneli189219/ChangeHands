package px_changehands.entity;

public class AdminSession {
	private int id;
	private String adminname;
	public AdminSession(int id, String adminname){
		this.id = id;
		this.adminname = adminname;
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

}
