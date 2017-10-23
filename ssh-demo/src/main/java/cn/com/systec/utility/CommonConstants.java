package cn.com.systec.utility;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public final class CommonConstants {
	
	
    // 轮询模式
    public final static class RollingMode {
        public static final int ROLLING_FOR_CHAIR = 1;
        public static final int ROLLING_FOR_ALL = 2;
        public static final int ROLLING_FOR_CHAIR_4LAYOUT = 3;
        public static final int ROLLING_FOR_CHAIR_NLAYOUT = 4;
    }
    
    // 会话属性
    public final static class SessionConstants {
        public static final String ENDPOINT_TYPE = "endPointType";
        public static final String AUTHORITY = "authority";
    }
    
    // 终端类型
    public final static class EndPointType {
        public static int EPTYPE_PC = 0;
        public static int EPTYPE_MOBILE = 1;
        public static int EPTYPE_TABLET = 2;
    }
    
    // 非权限URL
    public final static class NoPrivilageURL {
    	public static String NOPRIVILEGEQUERY = "/noPrivilegeQuery";
    	public static String QUERYROLEANDPRIVILEGEBYSESSIONID = "/queryRoleAndPrivilegeBySessionId";
    	public static String INIT = "/init";
    	public static String GETUSERS = "/getUsers";
    	public static String QUERYUSERBYSESSIONID = "/queryUserBySessionId";
    	public static String IMPORTHEAD = "/importHead";
    	public static String SHOWUSERHEAD = "/showUserHead";
    	public static String GETADSET = "/getADSet";    	 
    	public static String QUERYPARTICIPANTSTATUSALL = "/queryParticipantStatusAll";
    	public static String QUERYPOOLSMONITOR = "/poolsMonitor";
		public static String SERIALNO = "/serialNo";
		public static String GETSET = "/getSet";
		public static String GETAPISET = "/getApiSet";
		public static String SHOWMEETINGROOMLOGO = "/showlogo";
		public static String SHOWLOGO = "/showLogo";
		public static String FINDALLMEETINGTAG = "/findAll";
		public static String QUERYMCU = "/query";
		public static String FINDMCUINFO = "/findMcuInfo";
		public static String SERVERTIME = "/serverTime";
		public static String USERPHONEPRIVILEGE = "/queryUserPhonePri";
		public static String GETGROUPUSERS = "/getGroupUsers";
		public static String VERSIONINFO = "/versonInfo";
		public static String UPDATEPWD = "/updatePwd";
		public static String GETUSERINFO = "/queryByUserId";

    }
    
    public final static class UserSession {
    	public static String USER = "sessionUser";
    	public static String RAPS = "seesionRoleAndPrivileges";
    	public static String ROLE = "role";
    }
    
    public final static class ConfStatus {
    	public static String CONF_PENDING = "CONF_PENDING";    //连接中
    	public static String CONF_SCHEDULE = "CONF_SCHEDULE";  //已预约
    	public static String CONF_ONLINE = "CONF_ONLINE";      //在线
    	public static String CONF_OFFLINE = "CONF_OFFLINE";	   //离线
    	public static String CONF_DELETE = "CONF_DELETE";      //MCU中删除的
    	public static String CONF_EXPIRED = "CONF_EXPIRED";    //已过期的
    	public static String CONF_NOAPPROVA = "CONF_NOAPPROVA"; //未审批状态
//    	public static String CONF_APPROVAL = "CONF_APPROVAL"; //审批状态
    	public static String CONF_REJECTED = "CONF_REJECTED"; //驳回状态
		public static String CONF_MOREEXPIRED = "CONF_MORE_EXPIRED";  //严重超期
    }
    
    public final static class NoticeMessage{
    	public static String CREATE = "会议需要您参加！";
    	public static String UPDATE = "会议已更新！";
    	public static String DELETE = "会议已取消！";
    	public static String NEED_APPROVE = "会议需要您审批！";
    	public static String APPROVE = "会议已被审批！";
    	public static String REJECTED = "会议已被驳回！";
    	public static String DEL_APPROVAL = "会议已被取消！";
    }
    
   public final static class MeetingNotice{
	   public static String CREATE = "create";  //预约会议创建
	   public static String UPDATE = "update";  //预约会议更新
	   public static String DELETE = "delete";   //预约会议删除
	   public static String NEED_APPROVAL = "need_approval";  //需要审批的会议
	   public static String APPROVAL = "approval";   //会议已审批
	   public static String REJECTED = "rejected";   //会议已驳回
	   public static String DEL_APPROVAL = "del_approval";  //会议已删除
	   public static String RECORD = "record"; //会议纪要
   }
   
   /**
    * spring任务调度
    * @author wwf
    *
    */
   public final static class JobMethod{
	   public static String TASKJOB = "cn.com.systec.vcm.quartz.TaskJob";
	   public static String	START = "conferenceStart";
	   public static String END = "conferenceEnd";
	   public static String REMIND = "conferenceRemind";
	   public static String REPEAT = "conferenceRepeat";
   }

	/**
	 * 可用路径
	 */
	public final static class Path{
//		public static String RECORD_PATH = "/home/wwf/systec/project/syvcm-web/public/video";
		public static String RECORD_PATH = "/opt/apps/syvcm_nodeproxy/public/video";

		public static String LINUX_PREFIX = "";
   }

   public final static class MarkerUtils {
	   public static final Marker LOGIN = MarkerFactory.getMarker("LOGIN");
   }

	public final static class SystemModul {
		public static final String LOGIN = "[系统登录模块]-";
		public static final String INIT = "[初始化模块]-";
		public static final String SCHEDULE = "[任务调度模块]-";
		public static final String PERMIT = "[授权初始化模块]-";
		public static final String INITLIS = "[初始化监听模块]-";
		public static final String NTP = "[NTP模块]-";
		public static final String SYSTEMSET = "[系统配置模块]-";
		public static final String ADSYNC = "[AD域同步模块]-";
		public static final String CONTACT = "[联系人分组模块]-";
		public static final String SYSTEMLOG = "[系统日志模块]-";
		public static final String MACLOGIN = "[电子标牌日志模块]-";
		public static final String MCU = "[MCU配置模块]-";
		public static final String MEETINGAPPROVE = "[会议审批模块]-";
		public static final String MEETING = "[会议配置模块]-";
		public static final String MEETINGGROUP = "[会议室分组配置模块]-";
		public static final String MEETINGROOM = "[会议室配置模块]-";
		public static final String MEETINGLOG = "[会议日志配置模块]-";
		public static final String MEETINGTAG = "[会议标签配置模块]-";
		public static final String MEETINGTEMPLATE = "[会议模板配置模块]-";
		public static final String MONITOR = "[监控配置模块]-";
		public static final String NOTICE = "[系统通知配置模块]-";
		public static final String NOTICETEMP = "[邮件通知模板配置模块]-";
		public static final String ORGANIZATION = "[机构配置模块]-";
		public static final String PARTICIPANT = "[与会者配置模块]-";
		public static final String POOL = "[资源池配置模块]-";
		public static final String PRIVILEGE = "[权限配置模块]-";
		public static final String RCORD = "[录播配置模块]-";
		public static final String REGISTERSERVER = "[注册服务器配置模块]-";
		public static final String ROLE = "[角色配置模块]-";
		public static final String SMS = "[短信配置模块]-";
		public static final String USER = "[用户配置模块]-";
		public static final String ATTENDEE = "[会议与会者服务模块]-";
		public static final String STREAMING = "[直播配置模块]-";
		public static final String GLOBALCONFIGUR = "[全局配置模块]";
		public static final String ROLLINGMANAGER = "[轮询配置模块]";
		public static final String PROJECT = "[项目配置模块]";
		public static final String LOGIFO = "[日志信息]";
	}

	public final static class Utils {
		public static final String  ENCRYPTKEY = "PJac407p";
	}
}
