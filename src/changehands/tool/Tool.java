package changehands.tool;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 该类包含除了操作数据库方法外的一切方法
 * 
 * @author 17软工莫培文
 *
 */
public class Tool {
	/**
	 * 用与EL表达式string转int的方法
	 * @param value 传回的string
	 * @return 返回int类型的值
	 */
	public static int StringToInt(String value) {
		double doubleValue = Double.valueOf(value);
		int intValue = (int)doubleValue;
		return intValue;
	}
	
	/**
	 * 获得随机数
	 * 
	 * @param Length
	 *            需要的随机位数
	 * @return 返回length位随机数
	 */
	public int getRandom(int Length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < Length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return Integer.parseInt(val);
		//这里转int 如果出来的随机值是0开头 则只有5位数
	}

	/**
	 * 去除取自数据库保存的时间出现的".0" 运用replaceAll替换法
	 */
	public static String gainString(String date) {
		String reg = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2}).(\\d{1})";
		date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
		return date;
	}

	/**
	 * 将date转换成String 得到像 2018-11-26 这种格式的日期字符串
	 */
	public static String gainDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将date转换成String 得到像 2018-11-26 11:04:34 这种格式的时间字符串
	 */
	public static String gainTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 获得当前系统时间 返回String类型
	 * 
	 * @return 返回系统时间
	 */
	public String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTimes = df.format(new Date());
		return nowTimes;
	}

	/**
	 * 获取系统当前日期 返回Date类型 返回格式是这样的：Mon Nov 26 00:00:00 CST 2018
	 * 
	 * @return 返回系统时间
	 * @throws ParseException
	 */
	public static Date getSystemDate() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return simpleDateFormat.parse(simpleDateFormat.format(date));
	}

	/**
	 * 获取系统当前时间 返回Date类型 返回格式是这样的：Mon Nov 26 11:14:26 CST 2018
	 * 
	 * @return 返回系统时间
	 * @throws ParseException
	 */
	public static Date getSystemTime() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return simpleDateFormat.parse(simpleDateFormat.format(date));
	}

	/**
	 * 将ResultSet结果集转List集合
	 * @param rs ResultSet结果集
	 * @return 返回List集合
	 */
	public static List<Map<String, Object>> convertList(ResultSet rs) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 将ResultSet结果集转List集合
	 * @param rs ResultSet结果集
	 * @return 返回List集合
	 */
	public List<Map<String, Object>> convertList_(ResultSet rs) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}