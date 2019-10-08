package px_changehands.entity;

import java.math.BigDecimal;

public class Product {
	private int id;//发布商品用户的ID
	private int pid;//商品的ID
	private int fid;//分类
	private String fidname;
	private boolean flag;//标识
	private String tradename;//名称
	private String describes;//描述
	private BigDecimal price;//价格
	private int number;//数量
	private String showpath;//展示图路径
	private String addtime;//发布时间

	public Product(){
		
	}
	public Product(int id,
			int pid,
			int fid,
			String tradename,
			String showpath,
			String describes,
			BigDecimal price,
			int number,
			String addtime){
		this.id = id;
		this.pid = pid;
		this.fid=fid;
		this.tradename = tradename;
		this.showpath = showpath;
		this.describes = describes;
		this.price = price;
		this.number = number;
		this.addtime = addtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getTradename() {
		return tradename;
	}
	public void setTradename(String tradename) {
		this.tradename = tradename;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getShowpath() {
		return showpath;
	}
	public void setShowpath(String showpath) {
		this.showpath = showpath;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFidname() {
		return fidname;
	}
	public void setFidname(String fidname) {
		this.fidname = fidname;
	}


}
