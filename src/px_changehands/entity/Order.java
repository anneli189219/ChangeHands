package px_changehands.entity;

import java.math.BigDecimal;

public class Order {
	private int id;//买家id
	private int sid;//卖家id
	private int pid;//商品id
	private int oid;//订单编号
	private String tradename;//商品名字
	private String describes;//商品描述
	private int number;//数量
	private BigDecimal price;//价格
	private String buyer;//买家
	private String seller;//卖家
	private String shoptime;//下单时间

	public Order(){
		
	}
	public Order(int id,
			int sid,
			int pid,
			int oid,
			String tradename,
			String describes,
			int number,
			BigDecimal price,
			String shoptime
			){
		this.id=id;
		this.sid=sid;
		this.pid=pid;
		this.oid=oid;
		this.tradename=tradename;
		this.describes=describes;
		this.number=number;
		this.price=price;
		this.shoptime=shoptime;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getShoptime() {
		return shoptime;
	}
	public void setShoptime(String shoptime) {
		this.shoptime = shoptime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	

}
