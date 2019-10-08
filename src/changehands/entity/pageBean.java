package changehands.entity;

import java.util.List;

public class pageBean {
	private int currentpage;// 当前页数-直接获取
	private double totalpage;// 总页数-查询数据库获取
	private int numberpage;// 每页显示多少记录数-直接获取
	private int pre;// 上一页-计算获取
	private int next;// 下一页-计算获取
	private List<ProductBean> productList;// 当前页显示数据列表-查询数据库获取

	public pageBean() {
	}

	public pageBean(int cpage, int npage) {
		this.currentpage = cpage;
		this.numberpage = npage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public double getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(double totalpage) {
		this.totalpage = totalpage;
	}

	public int getNumberpage() {
		return numberpage;
	}

	public void setNumberpage(int numberpage) {
		this.numberpage = numberpage;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public List<ProductBean> getProductlist() {
		return productList;
	}

	public void setProductlist(List<ProductBean> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String values = "当前页:" + this.currentpage + "/总页数:" + this.totalpage + "/每页记录数:" + this.numberpage + "/上一页:"
				+ this.pre + "/下一页:" + this.next;
		System.out.println(values);
		return null;
	}

}
