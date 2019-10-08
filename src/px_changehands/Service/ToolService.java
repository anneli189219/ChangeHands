package px_changehands.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import px_changehands.dao.impl.UsersDaoImpl;

public class ToolService {
	
	/**
	 *获取时间
	 */
	public String GetisTime(){
		DateFormat format2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format2.format(new Date());
		return time;
	}
	
	/**
	 *获取ip
	 */
	public String Getip(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	/**
	 *获取系统环境
	 */
	public String Getsystemname(){
		return System.getProperty("os.name");
	}
	
	/**
	 *获取系统版本
	 */
	public String Getsystemversion(){
		return System.getProperty("os.version");
	}
	
	/**
	 *获取系统架构
	 */
	public String Getsystemarchitecture(){
		return System.getProperty("os.arch");	
	}
	
	/**
	 * MD5加密
	 */
	public String MD5(String plainText){
		//定义一个字节数组
        byte[] secretBytes = null;
        try {
              // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行加密
            md.update(plainText.getBytes());
            //获得加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败");
        }
        //将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
	}
	/**
	 * 获取总页数
	 */
	public int totalPages(int count){
		int totalPages = 0; //总页数
		int limit = 10; //每页的条数
		if (count>limit) {
			totalPages = count/limit+1;
			return totalPages;
		}else{
			return 1;
		}
	}
	/**
	 * 分页
	 * @param operation 操作
	 * @param nowpage 当前页数
	 * @param totalPages 总页数
	 * @return
	 */
	public int paging(String operation ,int nowpage, int totalPages){
		if (operation.equals("lower")) {
			if (nowpage<totalPages) {
				++nowpage;
			}
		}else if (operation.equals("upper")) {
			if (nowpage>1) {
				--nowpage;
			}
		}
		return nowpage;
	}
	/**
	 * 去除取自数据库保存的时间出现的".0" 运用replaceAll替换法
	 */
	public String getsqltime(String date){
		String reg = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2}).(\\d{1})";
		date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
		return date;
	}
	/**
	 * 生成随机值并查重
	 */
	public int Randomvalue(){
		Random ran = new Random();
		ToolService toolService = new ToolService();
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		int rand = ran.nextInt(999999-100000+1)+100000;//生成随机数
		if (usersDaoImpl.RepeatQuery(rand)) {
			return rand;
		}else {
			toolService.Randomvalue();
		}
		return rand;
	}
	/**
	 * 分类转换
	 */
	public String GoodsTransform(int fid){
		String sort;
		if (fid==0) {
			sort = "新鲜";
			return sort;
		}else if (fid==1) {
			sort = "书籍";
			return sort;
		}else if (fid==2) {
			sort = "手机";
			return sort;
		}else if (fid==3) {
			sort = "服装";
			return sort;
		}else if (fid==4) {
			sort = "家电";
			return sort;
		}else if (fid==5) {
			sort = "电脑";
			return sort;
		}else if (fid==6) {
			sort = "运动";
			return sort;
		}else if (fid==7) {
			sort = "美妆";
			return sort;
		}
		return null;
	}
	/**
	 * 生成订单ID
	 */
	public String OrderID(int id, int pid){
		String orderid = String.valueOf(id)+String.valueOf(pid);
		return orderid;
	}
	/**
	 * 计算订单价格
	 * @param Number 数量
	 * @param price 单价
	 * @return 订单价格
	 */
	public BigDecimal OrderPrice(int Number, BigDecimal price){
		BigDecimal ordepriceprice = new BigDecimal(Number).multiply(price);
		return ordepriceprice;
	}
}
