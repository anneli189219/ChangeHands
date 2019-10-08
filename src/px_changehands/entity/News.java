package px_changehands.entity;

public class News {
	private int id;
	private int gid;
	private int pid;
	private String message;
	private String releasetime;
	private String modifytime;
	public News(){
		
	}
	public News(int id,
			int gid,
			int pid,
			String message,
			String releasetime,
			String modifytime){
		this.id=id;
		this.gid=gid;
		this.pid=pid;
		this.message=message;
		this.releasetime=releasetime;
		this.modifytime=modifytime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}
