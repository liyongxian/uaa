package com.hollysys.hiadsp.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
/**
 * 
 * <p>
 * 字符串处理工具类。
 * <p>
 *
 * 创建日期 2015年7月13日<br>
 * @author  $litong$<p>
 * @since  1.0.0
 */
public class StringOption {
	/**
	 * 检测名字的合法性 (数字和英文字符开头,长度 4--50,可以使邮箱 )
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean checkLoginName(String userName) {
		if (null != userName) {
			String regex = "(^[0-9A-Za-z][0-9A-Za-z\\_\\@\\.]{4,50}$)";
			if(Pattern.matches(regex, userName)){
				return true;
			}else{
				regex ="[\u4E00-\u9FA5]{2,8}";
				return Pattern.matches(regex, userName);
			}
		} 
			return false;
	}

	/**
	 * 检测密码的合法性 (以字母开头，长度在6~40之间，只能包含字母、数字和下划线)
	 * 
	 * @param password
	 * @return
	 */
	public static boolean checkPassword(String password) {
		if (null != password) {
			String regex = "(^[A-Za-z0-9\\_]{6,20}$)";
			return Pattern.matches(regex, password);
		} else
			return false;
	}

	/**
	 * 检测邮箱 ()
	 * 
	 * @param emailAddress
	 * @return
	 */
	public static boolean checkEmail(String emailAddress) {
		if (null != emailAddress && emailAddress.length() < 100) {
			String regex = "(^([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|-|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,3}$)";
			return Pattern.matches(regex, emailAddress);
		} else
			return false;
	}

//	/**
//	 * 检测邮箱 (长度小于 50,字母和中字)
//	 * 
//	 * @param loginName
//	 * @return
//	 */
//	public static boolean checkLoginName(String loginName) {
//		if (null != loginName) {
//			String regex = "(^[A-Za-z\\u4e00-\\u9fa5]{1,50}$)";
//			return Pattern.matches(regex, loginName);
//		} else
//			return false;
//	}

	/**
	 * 检测类是否空
	 * 
	 * @param obj
	 *            = null 返回true
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj || "".equals(obj)||"null".equals(obj)||"".equals(obj.toString().trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 检测是否为非空 obj = null 返回false
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 获取 时间戳
	 * 
	 * @return
	 */
	public static String getSequenceId() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 获取标准日期格式
	 * 
	 * @return
	 */
	public static String getCurrentlyDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	/**
	 * 根据时间戳获取时间
	 * 
	 * @return
	 */
	public static String transformDateTime(long t) {
		Date date = new Date(t);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */

	public static String getCurrentlyDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	/**
	 * 验证List 是否为空
	 * 
	 * @param list
	 * @return
	 */
	public static boolean checkList(List<?> list) {
		if (null != list && list.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 验证对象是否为空(非空:返回true 空:返回false)
	 * 
	 * @param obj
	 * @return
	 */

	public static boolean checkObj(Object obj) {
		return isNotEmpty(obj);
	}

	/**
	 * 验证对象是否为空
	 * 
	 * @param obj
	 * @return
	 */

	public static int getInt(String str) {
		int a = 0;
		if (checkObj(str)) {
			try {
				a = Integer.parseInt(str);
			} catch (Exception e) {
			}
		}
		return a;
	}

	/**
	 * 日期转换方法
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 日期转换方法
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatString(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
}
