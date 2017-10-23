package cn.com.systec.utility;

import cn.com.systec.core.MySessionContext;
import jersey.repackaged.com.google.common.collect.Lists;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class CommonFunctions {
	
	public static Timer timer = null;
	
	/**
	 * Timer单粒2016-10-24 15:21:26.505 |DEBUG |http-bio-8080-exec-8 |ConferenceResource    - RESTFul: find conferences by ids=["0497bd2a-7d98-49b5-a90c-d3b607cc0ee8"]

	 * @return
	 */
	public synchronized static Timer getInstanceTimer(){  
	    if(timer==null){ 
	    	timer=new Timer();  
	    }
	    return timer;  
	}
	
	/**
	 * 把特定日期格式的字符串转换为Date对象
	 * @param str
	 * @param format
	 * @param defDate
	 * @return
	 */
	public static Date stringToDate(String str, String format, Date defDate) {
		if (str == null)
			return defDate;
		
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		
		try {
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			return defDate;
		}
	}
	
	/**
	 * 把日期格式为“yyyy-MM-dd HH:mm:ss”的字符串转换为Date对象
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str) {
		return CommonFunctions.stringToDate(str, null, null);
	}
	
	/**
	 * 将毫秒值转换为“yyyy-MM-dd HH:mm:ss”的字符串转换为Date对象
	 * @param l
	 * @return
	 */
	public static String TimeToDate(Long l) {
		 Date dat=new Date(l);  
         GregorianCalendar gc = new GregorianCalendar();   
         gc.setTime(dat);  
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String sb=format.format(gc.getTime());  
         return sb;
	}
	
	/**
	 * 把Date对象转换为特定格式字符串
	 * @param date
	 * @param format
	 * @param defValue
	 * @return
	 */
	public static String dateToString(Date date, String format, String defValue) {
		if (date == null)
			return defValue;
		
		if (format == null)
			format = "yyyy-MM-dd HH:mm:ss";
		
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 把Date对象转换为格式为“yyyy-MM-dd HH:mm:ss”字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return CommonFunctions.dateToString(date, null, null);
	}
	
	/**
	 * 把毫秒转换成特定格式
	 * @param ms
	 * @return
	 */
	public static String msToString(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		String strDay = day < 10 ? "0" + day : "" + day;
		String strHour = hour < 10 ? "0" + hour : "" + hour;
		String strMinute = minute < 10 ? "0" + minute : "" + minute;
		String strSecond = second < 10 ? "0" + second : "" + second;
		String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
//		return strDay + " " + strHour + ":" + strMinute + ":" + strSecond + " " + strMilliSecond;
		return strHour + "小时" + strMinute + "分钟";
	}
	
	/**
	 * 按照不同算法进行字符串编码
	 * @param s
	 * @param algorithm
	 * @return
	 */
	public static String encodeString(String s, String algorithm) {
	    try {
	        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
	        
	        messageDigest.update(s.getBytes());
	        
            return DatatypeConverter.printHexBinary(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
	}
	
	/**
	 * 获取Cookie值
	 * @param cookies
	 * @param cookieName
	 * @param defaultValue
	 * @return
	 */
	public static String getCookieValue(Cookie[] cookies, String cookieName, String defaultValue) {
        String result = defaultValue;
        
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        
        return result;
    }
	
	/**
	 * 获取本周第一天0点时间
	 * @return
	 */
	public static Date getBeginOfWeek() {
	    Calendar cal = Calendar.getInstance();
	    
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        return  cal.getTime();
	}
	
	/**
	 * 从URL地址中获取指定参数名的参数
	 * @param url
	 * @param parameterName
	 * @return
	 */
	public static String getParameterFromURLByName(String url, String parameterName) {
		if (!StringUtils.isEmpty(url)) {
	    	int start = url.indexOf(parameterName + "=");
	    	
	    	if (start >= 0) {
	    		int end = url.indexOf("&", start);
	    		String[] params = null;
	    		
	    		if (end < 0)
	    			params = url.substring(start).split("=");
	    		else
	    			params = url.substring(start, end).split("=");
	    		
	    		if (params.length == 2) {
	    			return params[1];
	    		}
	    	}
	    }
		
		return null;
	}
	
	/**
	 * 获取指定数量的随机验证码
	 * @param numberFlag
	 * @param length
	 * @return
	 */
	public static String getRandomCode(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";

        int len = strTable.length();
        boolean bDone = true;
        
        do {
            retStr = "";
            int count = 0;
            
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                
                retStr += strTable.charAt(intR);
            }
            
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }
	
	/**
	 * 通过HTTP头部中的User-Agent判断终端类型
	 * @param userAgent
	 * @return
	 */
	public static int getEndPointType(String userAgent) {
	    // 手机终端正则表达式
	    String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i" 
	            + "|windows (phone|ce)|blackberry" 
	            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp" 
	            + "|laystation portable)|nokia|fennec|htc[-_]" 
	            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
	    // 平板终端正则表达式
	    String tabletReg = "\\b(ipad|tablet|(Nexus 7)|up.browser" 
	            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    
	    
	    if (Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE).matcher(userAgent).find()) {
	        // 手机终端
	        return CommonConstants.EndPointType.EPTYPE_MOBILE;
	    }
	    else if (Pattern.compile(tabletReg, Pattern.CASE_INSENSITIVE).matcher(userAgent).find()) {
	        // 平板终端
            return CommonConstants.EndPointType.EPTYPE_TABLET;
        }
	    else {
	        // PC终端
	        return CommonConstants.EndPointType.EPTYPE_PC;
	    }
	}
	
	//删除字符串中重复的值
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String delReplayStr(String str) {
		ArrayList al =new ArrayList();
        String[] arr = str.split(",");
        for (int i=0; i<arr.length; i++){
            if (al.contains(arr[i]) == false)  {
                al.add(arr[i]);
            }
        }
        return StringUtils.join(al.toArray(), ",");
	}
	
	/**
	 * 把List集合转化成json数组
	 * @param list
	 * @return string json数组
	 */
	@SuppressWarnings("rawtypes")
	public static String toJsonArray(List list) {
		JSONArray jsonArray =  JSONArray.fromObject(list);
		 return jsonArray.toString();
	}
	
	/**
	 * 把对象转化成json数据
	 * @param o
	 * @return string json数据
	 */
	public static String toJson(Object o) {
		JSONObject jsonObject = JSONObject.fromObject(o);
		 return jsonObject.toString();
	}
	
	/**
	 * 对异常的处理
	 * @param status
	 * @param message
	 * @return
	 */
	public static String exceptionJson(int status, String message, String systemMsg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", status);
		jsonObject.put("message", message);
		jsonObject.put("systemMsg", systemMsg);
		return jsonObject.toString();
	}
	
	
/*	*//**
	 * 取出session中的对象
	 * @return
	 *//*
	public static Object getSessionO(HttpSession session, String str) {
		return session.getAttribute(str);
	}
	

	@SuppressWarnings("rawtypes")
	public static List getSessionList(HttpSession session, String str) {
		return (List) session.getAttribute(str);
	}*/
	
	public static Map<String, String> exception(String status, String message, String systemMsg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status);
		map.put("message", message);
		map.put("systemMsg", systemMsg);
		return map;
	}
	
	/**
	 * 把逗号分隔的字符串处理成sql语句
	 * @param Str
	 * @return
	 */
    public static String format(String Str) {
    	StringBuffer sbSql = new StringBuffer();
    	if (!"".equals(Str) && null != Str) {
	    	String[] ids = Str.split(",");
	    	for (int i=0; i<ids.length; i++) {
//	    		sbSql.append("'" + ids[i] + "'");
	    		sbSql.append(ids[i]);
	    		if (i < ids.length-1) {
	    			sbSql.append(",");
	    		}
	    	}
	    	return sbSql.toString();
    	}
    	return null;
    }

	/**
	 *格式化数字
	 * @param doubleNumber
	 * @param formatString
	 * @return
	 */
	public static String formatNumber(Double doubleNumber, String formatString) {
		DecimalFormat df = new DecimalFormat(formatString);
		return df.format(doubleNumber);
	}


    /**
     * 通过sessioniD获取Session
     * @param request
     * @param response
     * @return
     */
//	public static HttpSession findSessionBySessionID(HttpServletRequest request, HttpServletResponse response) {
//		response.setHeader("Access-Control-Allow-Origin", "*"); 
//		HttpSession session = null;
//		if (request.getParameter("sessionId") == null && request.getAttribute("sessionId") == null) {
//			session = request.getSession();
//		} else {
//			session = MySessionContext.getSession(request.getParameter("sessionId"));
//		}
//		return session;
//	}
    
    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest findRequest(){
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	return request;
    }
    
    /**
     * 获取HttpSession
     * @return
     */
    public static HttpSession findSession(HttpServletRequest request){
		HttpSession session = null;
//		HttpServletRequest request = findRequest();
		String sessionId = request.getParameter("sessionId") == null ? (String)request.getAttribute("sessionId") : request.getParameter("sessionId");
	
		if (sessionId == null) {
			session = request.getSession();
		} else {
			session = MySessionContext.getSession(sessionId);
		}
    	return session;
    }
    
    /**
     * 获取HttpSession
     * @return
     */
    public static HttpSession findSession(){
		HttpSession session = null;
		HttpServletRequest request = findRequest();
		String sessionId = request.getParameter("sessionId") == null ? (String)request.getAttribute("sessionId") : request.getParameter("sessionId");
	
		if (sessionId == null) {
			session = request.getSession();
		} else {
			session = MySessionContext.getSession(sessionId);
		}
    	return session;
    }
    
    /**
     * 获取session中的用户
     * @return
     */
//    public static User findUserBySession(){
//    	HttpSession session = findSession();
//    	User user = (User) session.getAttribute(UserSession.USER);
//    	return user;
//    }
    
    /**
     * 获取session中的权限
     * @return
     */
//    public static List<RoleAndPrivilege> findRoleAndPrivilegeBySession(){
//    	HttpSession session = findSession();
//    	List<RoleAndPrivilege>  roleAndPrivileges = (List<RoleAndPrivilege>) session.getAttribute(UserSession.RAPS);
//    	return roleAndPrivileges;
//    }
    
    /**
     * 获取HTTP响应数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte [8192];  
        int len = 0;
        
        while ((len = inStream.read(buffer)) != -1 ) {  
            outStream.write(buffer, 0, len);  
        }
        
        inStream.close();  
        return outStream.toByteArray();
    }
    
    
    /**
     * 判断对象是否为空指针
     * @param reference
     * @return
     */
    public static <T> Boolean isNull(T reference) {
        return reference == null || ("").equals(reference)? Boolean.TRUE : Boolean.FALSE;
    }
    
    /**
     * 判断字符串是否为空
     * @param str
     * @return   true  为空，  false 不为空
     */
    public static Boolean isNull(String str) {
    	if (str != null && str.length() > 0) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * 判断对象是否为空指针
     * @param
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static <T> Boolean isEmpty(Collection c) {
        return c.size() == 0 ? Boolean.TRUE : Boolean.FALSE;
    }
    
    /**
     * 空指针封装
     * @return
     */
    public static <T> T nullPointer() {
        return null;
    }
    
    /**
     * 把对象某属性组成字符串
     * @param T
     * @param attribute
     * @return
     */
    @SuppressWarnings("static-access")
	public static <T> String valueToStr (List<T> T, String attribute) {
    	if (!CommonFunctions.isNull(T) && !T.isEmpty()) {
    		StringBuffer values = new StringBuffer();
	    	for (int i=0; i<T.size(); i++) {
	    		JSONObject jsonO = new JSONObject().fromObject(T.get(i));
	    		values.append(jsonO.getString(attribute));
	    		if (i < T.size() - 1) {
	    			values.append(",");
	    		}
	    	}
	    	return values.toString();
    	}
    	return null;
    }
    
    /**
     * 字符串转换成Integer类型数组
     * @param str
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Integer> StringToInteger(String str) {
    	if (!isNull(str)) {
	    	return Lists.transform(Arrays.asList(str.split(",")), new jersey.repackaged.com.google.common.base.Function<String, Integer>() {
				public Integer apply(String arg0) {
					return Integer.valueOf(arg0);
				}
	    	});
    	}
    	return null;
    }
    
    /**     
     * 从json HASH表达式中获取一个map，该map支持嵌套功能     
     * 形如：{"id" : "johncon", "name" : "小强"}     
     * 注意commons-collections版本，必须包含org.apache.commons.collections.map.MultiKeyMap     
     * @param jsonString
     * @return     
     */       
    @SuppressWarnings("rawtypes")
	public static Map<String,Object> getMapFromJson(String jsonString) {        
        JSONObject jsonObject = JSONObject.fromObject(jsonString);        
        Map<String,Object> map = new HashMap<String,Object>();        
        for(Iterator iter = jsonObject.keys(); iter.hasNext();){        
            String key = (String)iter.next();        
            map.put(key, jsonObject.get(key));        
        }        
        return map;  
    }


	/**
	 * 得到一周的周日
	 *
	 */
	public static Date getSundayOfThisWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 7);
		return c.getTime();
	}

	/**
	 * 获取这个月的最后一天
	 * @param date
	 * @return
	 */
	public static Date getEndOfThisMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		return calendar.getTime();
	}

	/**
	 * 获取某年最后一天日期
	 * @param date
	 * @return Date
	 */
	public static Date getEndOfThisYear(Date date){
		Calendar currCal=Calendar.getInstance();
		currCal.setTime(date);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, currCal.get(Calendar.YEAR));
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期段所在年的第一天
	 * @param dBegin
	 * @param dEnd
	 * @return
	 */
	public static List<Date> findYears(Date dBegin, Date dEnd) {
		Calendar c_begin = Calendar.getInstance();

		Calendar c_end = Calendar.getInstance();
		Collection<Date> weeks = new HashSet<Date>();
		c_begin.setTime(dBegin);
		c_end.setTime(dEnd);

		while (c_begin.before(c_end)) {
			Calendar c_temp = Calendar.getInstance();
			c_temp.clear();
			c_temp.set(Calendar.YEAR, c_begin.get(Calendar.YEAR));
			c_temp.set(Calendar.HOUR_OF_DAY, 8);
			weeks.add(c_temp.getTime());
			c_begin.add(Calendar.DAY_OF_YEAR, 1);
		}
		ArrayList arrList = new ArrayList(weeks);
		Collections.sort(arrList, new Comparator<Date>() {
			public int compare(Date o1, Date o2) {
				return o1.compareTo(o2);
			}
		});
		return arrList;
	}

	/**
	 * 获取指定日期段所在月的第一天
	 * @param dBegin
	 * @param dEnd
	 * @return
	 */
    public static List<Date> findMonths(Date dBegin, Date dEnd) {
		Calendar c_begin = Calendar.getInstance();

		Calendar c_end = Calendar.getInstance();
		Collection<Date> weeks = new HashSet<Date>();
		c_begin.setTime(dBegin);
		c_end.setTime(dEnd);

		while (c_begin.before(c_end)) {
			Calendar c_temp = Calendar.getInstance();
			c_temp.setTime(c_begin.getTime());
			c_temp.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
			weeks.add(c_temp.getTime());
			c_begin.add(Calendar.DAY_OF_YEAR, 1);
		}
		ArrayList arrList = new ArrayList(weeks);
		Collections.sort(arrList, new Comparator<Date>() {
			public int compare(Date o1, Date o2) {
				return o1.compareTo(o2);
			}
		});
		return arrList;
	}

	/**
	 * 获取时间段之间的周 的周一
	 * @param dBegin
	 * @param dEnd
	 */
	public static List<Date> findWeeks(Date dBegin, Date dEnd) {
		Calendar c_begin = Calendar.getInstance();

		Calendar c_end = Calendar.getInstance();
		Collection<Date> weeks = new HashSet<Date>();
		c_begin.setTime(dBegin);
		c_end.setTime(dEnd);

		while (c_begin.before(c_end)) {
			Calendar c_temp = Calendar.getInstance();
			c_temp.setTime(c_begin.getTime());
			int dayWeek = c_temp.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
			if(1 == dayWeek) {
				c_temp.add(Calendar.DAY_OF_MONTH, -1);
			}

			c_temp.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

			int day = c_temp.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
			c_temp.add(Calendar.DATE, c_temp.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
			weeks.add(c_temp.getTime());
			c_begin.add(Calendar.DAY_OF_YEAR, 1);
		}
  		ArrayList arrList = new ArrayList(weeks);
		Collections.sort(arrList, new Comparator<Date>() {
			public int compare(Date o1, Date o2) {
				return o1.compareTo(o2);

			}
		});
		return arrList;
//		return new ArrayList<Date>(weeks);
	}
    
    /**
     * 起止时间到结束时间的所有日期
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> DateArray = new ArrayList<Date>();
//        DateArray.add(dBegin);
        Calendar calBegin = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间    
        calBegin.setTime(dBegin);  
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间    
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后    
        while (dEnd.after(calBegin.getTime())) {  
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            DateArray.add(calBegin.getTime());
            calBegin.add(Calendar.DAY_OF_MONTH, 1);  
        }
		if (calEnd.get(Calendar.HOUR_OF_DAY) == calBegin.get(Calendar.HOUR_OF_DAY)) {
			DateArray.add(dEnd);
		}

        return DateArray;
    }
  
    
    /**
     * 根据开始日期 ，需要的工作日天数 ，计算工作截止日期，并返回截止日期
     * @param startDate 开始日期
     * @param count 工作日天数(周一到周五)
     * @return Date类型
     * @createTime 2014-2-14
     * @author Sunqinbo
     */
    public static Date getWorkDay(Date startDate, int count) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(startDate);
        for (int i = 0; i < count; i++) {
            c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
            if (Calendar.SATURDAY == c1.get(Calendar.SATURDAY) || Calendar.SUNDAY == c1.get(Calendar.SUNDAY)) {
            	count = count + 1;
                c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
                continue;
            }
        }
        return c1.getTime();
    }
    
    /**
     * 获取工作日天数的数组
     * @param startDate   total开始日期
     * @param total  多少天
     * @return
     */
    public static List<Date> getWorkDays(Date startDate, int total) {
    	List<Date> DateArray = new ArrayList<Date>();
    	 for (int i = 0; i < total; i++) {
    		 DateArray.add(getWorkDay(startDate, i));
    	    }
    	 return DateArray;
    }
    
    /**
     * 获取工作日天数的数组
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> getWorkDays(Date dBegin, Date dEnd) {
    	List<Date> dates = findDates(dBegin, dEnd);
    	List<Date> DateArray = new ArrayList<Date>();
    	Calendar c1 = Calendar.getInstance();
    	 for (int i = 0; i < dates.size(); i++) {
    		 c1.setTime(dates.get(i));
    		 if (Calendar.SATURDAY != c1.get(Calendar.DAY_OF_WEEK) && Calendar.SUNDAY != c1.get(Calendar.DAY_OF_WEEK)) {
        		 DateArray.add(dates.get(i));
    		 }
    	    }
    	 return DateArray;
    }
    
    /**
     * 获取某时间段内的所有需要的周
     * @param dBegin
     * @param dEnd
     * @param weeks
     * @return
     */
    public static List<Date> getWeekDays(Date dBegin, Date dEnd, List<String> weeks) {
    	List<Date> dates = findDates(dBegin, dEnd);
    	List<Date> DateArray = new ArrayList<Date>();
    	Calendar c1 = Calendar.getInstance();
    	for (int i=0; i<dates.size(); i++) {
    		c1.setTime(dates.get(i));
    		if (weeks.contains(c1.get(Calendar.DAY_OF_WEEK)+"")) {
    			DateArray.add(dates.get(i));
    		}
    	}
    	 return DateArray;
    }
    
    /**
     * 根据周获取N次后的日期
     * @param startDate
     * @param weeks
     * @param count
     * @return
     */
        public static Date getWeekDay(Date startDate, List<String> weeks, int count) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(startDate);
            for (int i = 0; i < count; i++) {
                c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
                if (!weeks.contains(c1.get(Calendar.DAY_OF_WEEK) + "")) {
                	count = count + 1;
//                    c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);
                    continue;
                }
            }
            return c1.getTime();
        }

    /**
     * 根据周获取N次后的日期数组
     * @param startDate
     * @param total
     * @return
     */
    public static List<Date> getWeekDays(Date startDate,List<String> weeks, int total) {
    	List<Date> DateArray = new ArrayList<Date>();
    	 for (int i = 1; i < total+1; i++) {
    		 DateArray.add(getWeekDay(startDate, weeks, i));
    	    }
    	 return DateArray;
    }

    /**
     * 把字符串中1-7转换成SUN-SAT
     * @param weeks
     * @return
     */
    public static String intWeekToStrWeek(String weeks) {
    	StringBuffer sb = new StringBuffer();
    	String[] weekStr = weeks.split(",");
    	String[] weekArray = "SUN,MON,TUE,WED,THU,FRI,SAT".split(",");
    	for (int i=0; i < weekStr.length; i++) {
    		sb.append(weekArray[Integer.parseInt(weekStr[i])-1]);
    		if (i<weekStr.length-1) {
    			sb.append(",");
    		}
    	}
    	return sb.toString();
    }

    /**
     * 在某一时间段内获取第N周周N的所有日期
     * @param
     * @param
     * @param whichArray
     * @return
     */
	public static List<Date> getWhickWeeks(Date dBegin, Date dEnd, String[] whichArray) {
    	List<Date> dates = findDates(dBegin, dEnd);
    	List<Date> DateArray = new ArrayList<Date>();
    	Calendar c1 = Calendar.getInstance();
    	
    	for (int i=0; i<dates.size(); i++) {
    		c1.setTime(dates.get(i));
    		int which = c1.get(Calendar.WEEK_OF_MONTH);
    		int week = c1.get(Calendar.DAY_OF_WEEK);
//    		System.out.println("which================"+which +  "----------------week===============" + week);
    		if (which == Integer.parseInt(whichArray[0]) && week == Integer.parseInt(whichArray[1])) {
    			DateArray.add(dates.get(i));
    		}
    	}
    	 return DateArray;
	}
	
	  /**
     * 根据每月第N周的第周N获取N次的日期
     * @param startDate
     * @param whichArray
     * @param count
     * @return
     */
        public static Date getWhickWeek(Date startDate, String[] whichArray, int count) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(startDate);
            for (int i = 0; i < count; i++) {
                c1.set(Calendar.WEEK_OF_MONTH, c1.get(Calendar.WEEK_OF_MONTH) + 1);
                int which = c1.get(Calendar.WEEK_OF_MONTH);
                int week = c1.get(Calendar.DAY_OF_WEEK);
                if (which != Integer.parseInt(whichArray[0])) {
                	count = count + 1;
                	continue;
                } else {
                	c1.set(Calendar.DAY_OF_WEEK, week);
                    }
        	
            }
            return c1.getTime();
        }

    /**
     * 根据每月第N周的第周N获取N次的日期数组
     * @param startDate
     * @param total
     * @return
     */
    public static List<Date> getWhickWeeks(Date startDate,String[] whichArray, int total) {
    	List<Date> DateArray = new ArrayList<Date>();
    	 for (int i = 1; i < total+1; i++) {
    		 DateArray.add(getWhickWeek(startDate, whichArray, i));
    	    }
    	 return DateArray;
    }
    
    /**
     * 根据间隔返回距离间隔最近的还未发生的时间差
     * @param interval
     * @return
     */
    public static Long getFirstTime(String interval) {
    	int inter = Integer.parseInt(interval);
    	Long time = 0L;
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	int hour = calendar.get(Calendar.HOUR_OF_DAY);
    	int min = calendar.get(Calendar.MINUTE);
    	for (int i=0; i < 25; i++) {
    		if (i*inter > hour && i*inter < 24) {
    			time = (long) (((i*inter-hour)*60-min)*60*1000);
    			break;
    		}else if (i*inter == hour && min == 0) {
    			time = 0L;
    			break;
    		} else if (i*inter >= 24) {
    			time = (long) (((24-hour)*60-min)*60*1000);
    		}
    	}
    	return time;
    }
    /**
     * 获取一个字符串在另一个字符串中出现的次数
     * @param str1
     * @param str2
     * @return
     */
    public static int  getSubString(String str1,String str2){
        int count = 0;
        int index = 0;
        while((index=str1.indexOf(str2,index))!=-1){
            index = index+str2.length();
            count++;
        }
        return count;
    }
    
    /** 
     * 两日期之间相隔的天数
    *字符串的日期格式的计算 
    */  
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }
    
    /**
       * 取出数组中的最大值
       * @param arr
       * @return
       */
    public static int getMax(List<Integer> arr){
           int max=arr.get(0);
           
           for(int i=1;i<arr.size();i++){
               if(arr.get(i)>max){
                   max=arr.get(i);
               }
            }
            return max;
        }

	/**利用MD5进行加密
	 * @param str  待加密的字符串
	 * @return  加密后的字符串
	 * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//确定计算方法
		MessageDigest md5=MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		//加密后的字符串
		String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}

    /** 
     * 大陆号码或香港号码均可 
     */  
    public static boolean isPhoneLegal(String str)throws PatternSyntaxException {  
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);  
    }  
  
    /** 
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
     * 此方法中前三位格式有： 
     * 13+任意数 
     * 15+除4的任意数 
     * 18+除1和4的任意数 
     * 17+除9的任意数 
     * 147 
     */  
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {  
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
  
    /** 
     * 香港手机号码8位数，5|6|8|9开头+7位任意数 
     */  
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {  
        String regExp = "^(5|6|8|9)\\d{7}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }  
    /** 
     * 验证邮箱格式
     */  
    public static boolean isEmailLegal(String str)throws PatternSyntaxException {  
    	String regExp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";  
    	Pattern p = Pattern.compile(regExp);  
    	Matcher m = p.matcher(str);  
    	return m.matches();  
    }  
    
    /**
     * list 转 String
     * @param list
     * @param separator
     * @return
     */
    public static String listToString(List list, String separator) {    
    	StringBuilder sb = new StringBuilder();    
    	for (int i = 0; i < list.size(); i++) {       
    		sb.append(list.get(i)).append(separator);    
    	}    
    	return sb.toString().substring(0,sb.toString().length()-1);
    }
    
    /**
     * 获取xml中某个节点的text
     * @param xmltext
     * @param node
     * @return
     * @throws Exception
     */
    public static String getNodeText(String xmltext , String node) throws Exception{
 	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 		DocumentBuilder db = dbf.newDocumentBuilder();
 		StringReader sr = new StringReader(xmltext);
 		InputSource is = new InputSource(sr);
 		Document document = db.parse(is);
 		Element root = document.getDocumentElement();
 		NodeList nodelist = root.getElementsByTagName(node);
 		return nodelist.item(0).getTextContent();
   }
    
}




















