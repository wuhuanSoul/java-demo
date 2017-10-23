package cn.com.systec.utility;

public final class ResponseStatus {
	// 成功码
    public static final int SUCCESS = 200;
    public static final String MSG_SUCCESS = "OK";
    
    // 错误码
    //会议模板
    public static final int ERR_MEETINGTEMPLATE_ADD = 10000;
    public static final int ERR_MEETINGTEMPLATE_REPEAT  = 10001;
    public static final int ERR_MEETINGTEMPLATE_DELETE  = 10002;
    public static final int ERR_MEETINGTEMPLATE_UPDATE  = 10003;
    public static final int ERR_MEETINGTEMPLATE_QUERY  = 10004;
    public static final int ERR_MEETINGTEMPLATE_NUMBERICID = 10005;
  
    //会议预约
    public static final int ERR_MEETING_ADD = 10020;
    public static final int ERR_MEETING_REPEAT  = 10021;
    public static final int ERR_MEETING_DELETE  = 10022;
    public static final int ERR_MEETING_UPDATE  = 10023;
    public static final int ERR_MEETING_QUERY  = 10024;
    public static final int ERR_MEETING_END = 10025;
    public static final int ERR_MEETING_APPROVE_CONFLICT = 10026;   //审批时终端冲突
    public static final int ERR_MEETING_NOAPPROVE_CONFLICT = 10027; //非审批时终端冲突
    public static final int ERR_MEETING_NUMBERICID = 10028;//自定义会议号重复
    public static final int ERR_MEETING_FOREVER = 10029;//永久会议号创建失败
    public static final int ERR_MEETING_QUERY_RECOD_STREAMING = 10030;//查询进行中的录播和直播接口数量失败
    public static final int ERR_MEETING_NOAPPROVE_HANDLE = 10031; //会议重复审批错误
  
    //会议通知
    public static final int ERR_NOTICE_ADD = 10040;
    public static final int ERR_NOTICE_DELETE  = 10041;
    public static final int ERR_NOTICE_UPDATE  = 10042;
    public static final int ERR_NOTICE_QUERY  = 10043;
  
    public static final int ERR_NOTICE_TEMPLATE_ADD = 10044;
    public static final int ERR_NOTICE_TEMPLATE_DELETE = 10045;
    public static final int ERR_NOTICE_TEMPLATE_UPDATE = 10046;
    public static final int ERR_NOTICE_TEMPLATE_QUERY = 10047;
    public static final int ERR_NOTICE_TEST = 10048;
  
    //会议审批
    public static final int ERR_APPROVE_TIMEOUT = 10060;
    public static final int ERR_APPROVE = 10061;
    public static final int ERR_REJECTED = 10062;
    public static final int ERR_APPROVE_REPEAT = 10063;
    public static final int ERR_REJECTED_REPEAT = 10064;
  
    //会议控制
    public static final int ERR_MEETINGCONTROLLER_CALL = 10080;
    public static final int ERR_MEETINGCONTROLLER_MICROPHONE = 10081;
    public static final int ERR_MEETINGCONTROLLER_SPEAKER = 10082;
    public static final int ERR_MEETINGCONTROLLER_LAYOUT = 10083;
    public static final int ERR_MEETINGCONTROLLER_MODE = 10084;
    public static final int ERR_MEETINGCONTROLLER_MESSAGE = 10085;
    public static final int ERR_MEETINGCONTROLLER_ROLLING = 10086;
    public static final int ERR_MEETINGCONTROLLER_DELAY = 10087;
    public static final int ERR_MEETINGCONTROLLER_LOCK = 10088;
    public static final int ERR_MEETINGCONTROLLER_SUMMARY = 10089;
    public static final int ERR_MEETINGCONTROLLER_OCCUPY = 10090;
    public static final int ERR_MEETINGCONTROLLER_CHECKED = 10091;
    public static final int ERR_MEETINGCONTROLLER_URGED = 10092;
    public static final int ERR_MEETINGCONTROLLER_SWITCHCOMPER = 10093;
    public static final int ERR_PARTICIPANT_REPEAT = 10094;
    public static final int ERR_PARTICIPANT_LOGGER = 10095;

    public static final int ERR_RECORDING_START = 10096;
    public static final int ERR_RECORDING_STOP = 10097;
    public static final int ERR_MEETING_QUERYLOAD = 10098;
    public static final int ERR_USER_EXCEL = 10099;
    public static final int ERR_MEETINGCONTROLLER_SETCREEN = 10200;
    public static final int ERR_MEETING_AUTHORITY = 10821;
  
    //与会者控制
    public static final int ERR_PARTICIPANT_ADD = 10100;
    public static final int ERR_PARTICIPANT_DELETE = 10101;
    public static final int ERR_PARTICIPANT_CALL = 10102;
    public static final int ERR_PARTICIPANT_QUERY = 10103;
    public static final int ERR_PARTICIPANT_LAYOUT = 10104;
    public static final int ERR_PARTICIPANT_MICROPHONE = 10105;
    public static final int ERR_PARTICIPANT_SPEAKER = 10106;
    public static final int ERR_PARTICIPANT_BROADCAST = 10107;
    public static final int ERR_PARTICIPANT_PRESENTATION = 10108;
    public static final int ERR_PARTICIPANT_PREVIEW = 10109;
    public static final int ERR_PARTICIPANT_FECC = 10110;
    public static final int ERR_PARTICIPANT_FOCUS = 10111;
    public static final int ERR_PARTICIPANT_DIAGNOSTICINFO = 10112;
    public static final int ERR_PARTICIPANT_FLOOR = 10113;
    public static final int ERR_PARTICIPANT_DIAL = 10114;
    public static final int ERR_PARTICIPANT_MONITORTERMINAL = 10115;

    //系统配置
    public static final int ERR_SYSTEM_APPROVE = 10120;
    public static final int ERR_SYSTEM_APPROVE_QUERY = 10121;
    public static final int ERR_SYSTEM_AD_QUERY = 10122;
    public static final int ERR_SYSTEM_setADSet = 10123;
    public static final int ERR_SYSTEM_TIMEOUT = 10124;  //系统超时
    public static final int ERR_SYSTEM_GLOBALCONFIG = 10125;
    public static final int ERR_SYSTEM_GLOBALCONFIG_QUERY = 10126;
    public static final int ERR_SYSTEM_UPDATESYSTEM = 10127;
    public static final int ERR_SYSTEM_VERSONINFO = 10128;
    public static final int ERR_SYSTEM_SERIALNUMBERINFO = 10129;
    public static final int ERR_SYSTEM_UPDATEPERMIT = 10130;
    public static final int ERR_SYSTEM_VERIFYPERMIT = 10131;
    public static final int ERR_SYSTEM_ANOMALYVERIFYPERMIT = 10132;
    public static final int ERR_SYSTEM_DOWNLOADLOG = 10133;
    public static final int ERR_SYSTEM_BACKUPSQL = 10134;
    public static final int ERR_SYSTEM_NTP = 10135;
    public static final int ERR_SYSTEM_NETWORK = 10136;
    public static final int ERR_SYSTEM_REGISTERSERVER_ADD = 10137;
    public static final int ERR_SYSTEM_REGISTERSERVER_DELETE = 10138;
    public static final int ERR_SYSTEM_REGISTERSERVER_UPDATE = 10139;
    public static final int ERR_SYSTEM_REGISTERSERVER_ADD_IP = 10140;
    public static final int ERR_SYSTEM_importLogo = 10141;
    public static final int ERR_SYSTEM_importTitle = 10142;
    public static final int ERR_SYSTEM_readTitle = 10143;
    public static final int ERR_SYSTEM_RESETDB = 10144;
    public static final int ERR_SYSTEM_SERVERINFO = 10145;
    public static final int ERR_SYSTEM_RECORD_QUERY = 10146;
    public static final int ERR_SYSTEM_RECORD_UPDATE = 10147;
    public static final int ERR_SYSTEM_RECORD_DELETE = 10148;
    public static final int ERR_ATTRIBUTION_QUERY = 10149;
    public static final int ERR_SYSTEM_DBZIP = 10150;
    public static final int ERR_SYSTEM_CPU = 10151;

  
  
  
    public static final int CLEARSESSION = 100000;
    public static final int DOWNLOADERROR = 1100000;
  
    //组织机构
    public static final int ERR_ORGANIZATION_ADD = 100001;
    public static final int ERR_ORGANIZATION_DELETE = 100002;
    public static final int ERR_ORGANIZATION_QUERY = 100003;
    public static final int ERR_ORGANIZATION_UPDATE = 100004;
    public static final int ERR_ORGANIZATION_orgExport = 100005;
    public static final int ERR_ORGANIZATION_orgDownload = 100006;
    public static final int ERR_ORGANIZATION_import = 100007;
    public static final int ERR_ORGANIZATION_SORT = 100008;
    public static final int ERR_ORGANIZATION_DUPLICATE = 100009;
  
    //日志
    public static final int ERR_LOG_QUERY = 1000020;
    public static final int ERR_LOG_logExport = 1000021;
    public static final int ERR_LOG_DELETE = 1000022;
    public static final int ERR_LOG_logExportTXT = 1000023;
    public static final int ERR_LOG_ZIP = 1000024;
  
    //用户
    public static final int ERR_USER_ADD = 1000030;
    public static final int ERR_USER_DELETE = 100031;
    public static final int ERR_USER_QUERY = 1000032;
    public static final int ERR_USER_UPDATE = 100033;
    public static final int ERR_USER_userExport = 100034;
    public static final int ERR_USER_userDownload = 100035;
    public static final int ERR_USER_userImport = 100036;
    public static final int ERR_USER_updateUserRole = 100037;
    public static final int ERR_USER_SORT = 1000038;
    public static final int ERR_USER_ERROR = 1000039;
    public static final int ERR_USER_ISENABLE = 1000040;
    public static final int ERR_USER_importHead = 100041;
    public static final int ERR_USER_UPDATEPWD = 100042;
    public static final int ERR_USER_ISADMIN = 100043;
    public static final int ERR_USER_SIGN = 100044;
    public static final int ERR_USER_UPDATEMAXATTEND = 100045;
    public static final int ERR_USER_QUERYPRIVILEGE = 100046;
    public static final int USER_SIGN_RESULT = 100047;

 

    //角色
    public static final int ERR_ROLE_ADD = 1000050;
    public static final int ERR_ROLE_DELETE = 100051;
    public static final int ERR_ROLE_QUERY = 1000052;
    public static final int ERR_ROLE_UPDATE = 100053;
    public static final int ERR_ROLE_roleExport = 100054;
    public static final int ERR_ROLE_roleDownload = 100055;
    public static final int ERR_ROLE_roleImport = 100056;
  
    //权限
    public static final int ERR_PRIVILEGE_QUERY = 1000070;
    public static final int ERR_PRIVILEGE_ADDALLREADWRITESHOW = 1000071;
    public static final int ERR_PRIVILEGE_DELETEALLREADWRITESHOW = 1000072;
    public static final int ERR_PRIVILEGE_ADDALLSCOPE = 1000073;
  
    //会议室分组
    public static final int ERR_MEETINGGROUP_ADD= 1000090;
    public static final int ERR_MEETINGGROUP_DELETE= 1000091;
    public static final int ERR_MEETINGGROUP_QUERY = 1000092;
    public static final int ERR_MEETINGGROUP_UPDATE = 1000093;
    public static final int ERR_MEETINGGROUP_SORT = 1000094;
    public static final int ERR_MEETINGGROUP_Export = 1000095;
    public static final int ERR_MEETINGGROUP_Download = 1000096;
    public static final int ERR_MEETINGGROUP_Upload = 1000097;
  
    //会议室
    public static final int ERR_MEETINGROOM_ADD= 1000110;
    public static final int ERR_MEETINGROOM_DELETE= 1000111;
    public static final int ERR_MEETINGROOM_QUERY = 1000112;
    public static final int ERR_MEETINGROOM_UPDATE = 1000113;
    public static final int ERR_MEETINGROOM_Export = 1000114;
    public static final int ERR_MEETINGROOM_Download = 1000115;
    public static final int ERR_MEETINGROOM_Upload = 1000116;
    public static final int ERR_MEETINGROOM_configurationProperties = 1000117;
    public static final int ERR_MEETINGROOM_findTerminalModels = 1000118;
    public static final int ERR_MEETINGROOM_SORT = 1000119;
    public static final int ERR_MEETINGROOM_BATCHUPDATE = 1000120;

  
  
    //MCU
    public static final int ERR_MCU_ADD= 1000210;
    public static final int ERR_MCU_DELETE= 1000211;
    public static final int ERR_MCU_QUERY= 1000212;
    public static final int ERR_MCU_UPDATE= 1000213;
    public static final int ERR_MCU_Export= 1000214;
    public static final int ERR_MCU_Download= 1000215;
    public static final int ERR_MCU_Upload= 1000216;
    public static final int ERR_MCU_Excel = 1000217;
    public static final int ERR_MCU_findMcuModels = 1000300;
    public static final int ERR_MCU_findMcuInfo = 1000301;
  
    //资源池
    public static final int ERR_POOL_ADD= 1000310;
    public static final int ERR_POOL_DELETE= 1000311;
    public static final int ERR_POOL_QUERY= 1000312;
    public static final int ERR_POOL_UPDATE= 1000313;
    public static final int ERR_POOL_findTerminalList= 1000314;
    public static final int ERR_POOL_findMcuList= 1000315;
    public static final int ERR_POOL_addTerminal= 1000316;
    public static final int ERR_POOL_addMcu= 1000317;
    public static final int ERR_POOL_sortMcu= 1000318;
    public static final int ERR_POOL_POOLRSMONITORS= 1000319;
  
    //短信
    public static final int ERR_SMS_DELETE= 1000400;
    public static final int ERR_SMS_ADD= 1000401;
    public static final int ERR_SMS_ISUSE= 1000402;
  
    //会议标签
    public static final int ERR_TAG_REPEAT = 1000500;//标签重名
    public static final int ERR_TAG_ADD = 1000501;//标签添加
    public static final int ERR_TAG_UPDATE =1000502;//标签更新
    public static final int ERR_TAG_DELETE =1000503;//删除
  
    //我的联系人
    public static final int ERR_CONTACT_ININT = 1000600;
    public static final int ERR_CONTACT_ADDGROP = 1000601;
    public static final int ERR_CONTACT_UPDATE = 1000602;	
    public static final int ERR_CONTACT_QUERY = 1000603;	
    public static final int ERR_CONTACT_ADDCONTACT = 1000604;
    public static final int ERR_CONTACT_DELETE = 100060;
    public static final int ERR_EXPORT_MYCONTACT = 100061;
    public static final int ERR_CONTACT_contactDownload = 100062;
    public static final int ERR_CONTACT_contactImport = 100063;

    //直播
    public static final int ERR_STREAMING_START = 1000700;  // 直播开启失败
    public static final int ERR_STREAMING_STOP = 1000701; // 直播关闭失败

    public static final int ERR_OVER_LIMIT = 1000702; // 已达到最大方数


    //项目
    public static final int ERR_GET_PROJECT_LIST = 1001000;
    public static final int ERR_GET_NODE_LIST = 1001001;
    public static final int ERR_AUTH_FAILURE = 1001002;
    public static final int ERR_SYNC_USER = 1001003;
    public static final int ERR_FILE_LIST = 1001004;
    public static final int ERR_FILE_UPLOAD = 1001005;
    public static final int ERR_FILE_SUMMARY_ID = 1001006;
    public static final int ERR_SAVE_SUMMARY = 1001007;
    public static final int ERR_GET_APPROVE = 1001008;
    public static final int ERR_GET_PREVIEW = 1001009;
  
    public static final int ERR_EXPORT_EXCEL  = 899;//导出列表失败
    public static final int ERR_UKNOWN  = 900;
    public static final int ERR_UNKNOWN  = 901;


	  // 错误消息
	public static String getErrorMessage(Integer errCode) {
	    switch (errCode) {
	    case ResponseStatus.ERR_MEETINGTEMPLATE_ADD: return "会议模板添加失败";
        case ResponseStatus.ERR_MEETINGTEMPLATE_REPEAT: return "会议模板重名";
        case ResponseStatus.ERR_MEETINGTEMPLATE_DELETE: return "会议模板删除失败";
        case ResponseStatus.ERR_MEETINGTEMPLATE_UPDATE: return "会议模板更新失败";
        case ResponseStatus.ERR_MEETINGTEMPLATE_QUERY: return "会议模板查找失败";
        case ResponseStatus.ERR_MEETINGTEMPLATE_NUMBERICID: return "该自定义会议号已被其他模板占用";
        
        case ResponseStatus.ERR_MEETING_ADD: return "会议添加失败";
        case ResponseStatus.ERR_MEETING_REPEAT: return "会议重名";
        case ResponseStatus.ERR_MEETING_DELETE: return "会议删除失败";
        case ResponseStatus.ERR_MEETING_UPDATE: return "会议更新失败";
        case ResponseStatus.ERR_MEETING_QUERY: return "会议查询失败";
        case ResponseStatus.ERR_MEETING_END: return "会议结束失败";
        case ResponseStatus.ERR_MEETING_APPROVE_CONFLICT: return "存在冲突终端";   //审批时终端冲突
        case ResponseStatus.ERR_MEETING_NOAPPROVE_CONFLICT: return "存在冲突终端"; //非审批时终端冲突
        case ResponseStatus.ERR_MEETING_NUMBERICID: return "该自定义会议号正在被使用"; //该自定义会议号正在被使用
        case ResponseStatus.ERR_MEETING_FOREVER: return "会议创建失败";
        case ResponseStatus.ERR_MEETING_NOAPPROVE_HANDLE: return "会议已经被其他审批员处理，请刷新页面";
        
        
        case ResponseStatus.ERR_NOTICE_ADD: return "通知添加失败";
        case ResponseStatus.ERR_NOTICE_DELETE: return "通知删除失败";
        case ResponseStatus.ERR_NOTICE_UPDATE: return "通知更新失败";
        case ResponseStatus.ERR_NOTICE_QUERY: return "通知查询失败";
        
        case ResponseStatus.ERR_NOTICE_TEMPLATE_ADD: return "通知模板添加失败";
        case ResponseStatus.ERR_NOTICE_TEMPLATE_DELETE: return "通知模板删除失败";
        case ResponseStatus.ERR_NOTICE_TEMPLATE_UPDATE: return "通知模板更新失败";
        case ResponseStatus.ERR_NOTICE_TEMPLATE_QUERY: return "通知模板查询失败";
        case ResponseStatus.ERR_NOTICE_TEST: return "测试邮件发送失败";
        
        case ResponseStatus.ERR_APPROVE_TIMEOUT: return "会议已超期，请驳回";
        case ResponseStatus.ERR_APPROVE: return "会议审批失败";
        case ResponseStatus.ERR_REJECTED: return "会议驳回失败";
        case ResponseStatus.ERR_APPROVE_REPEAT: return "会议已被他人审批";
        case ResponseStatus.ERR_REJECTED_REPEAT: return "会议已被他人驳回";
        
        case ResponseStatus.ERR_MEETINGCONTROLLER_CALL: return "终端全开/全断命令发送失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_MICROPHONE: return "麦克风全开/全断命令发送失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_SPEAKER: return "扬声器全开/全断命令发送失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_LAYOUT: return "设置会议分屏失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_MODE: return "设置会议模式失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_MESSAGE: return "发送字幕失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_ROLLING: return "轮询设置失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_DELAY: return "会议延时失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_LOCK: return "会议锁定或解锁失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_SUMMARY: return "会议记录失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_OCCUPY: return "会议室存在冲突";
        case ResponseStatus.ERR_MEETINGCONTROLLER_CHECKED: return "会议室选择失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_URGED: return "审批催办失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_SWITCHCOMPER: return "切换主持人失败";
        case ResponseStatus.ERR_MEETING_QUERYLOAD: return "获取CMS总负载失败";
        case ResponseStatus.ERR_USER_EXCEL: return "导出与会者详情失败";
        case ResponseStatus.ERR_MEETINGCONTROLLER_SETCREEN: return "设置主席分屏失败";
        case ResponseStatus.ERR_MEETING_AUTHORITY: return "您没有查询会议室的权限";

        //与会者控制
        case ResponseStatus.ERR_PARTICIPANT_ADD: return "添加与会者失败";
        case ResponseStatus.ERR_PARTICIPANT_DELETE: return "移除与会者失败";
        case ResponseStatus.ERR_PARTICIPANT_CALL: return "终端断开或连接命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_FLOOR: return "发言人设置或取消命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_QUERY: return "与会者查询失败";
        case ResponseStatus.ERR_PARTICIPANT_LAYOUT: return "与会者分屏设置失败";
        case ResponseStatus.ERR_PARTICIPANT_MICROPHONE: return "麦克风打开或关闭命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_SPEAKER: return "扬声器打开或关闭命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_BROADCAST: return "广播打开或关闭命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_PRESENTATION: return "双流打开或关闭命令发送失败";
        case ResponseStatus.ERR_PARTICIPANT_PREVIEW: return "获取预览图失败";
        case ResponseStatus.ERR_PARTICIPANT_FECC: return "摄像头控制失败";
        case ResponseStatus.ERR_PARTICIPANT_FOCUS: return "设置或取消观看失败";
        case ResponseStatus.ERR_PARTICIPANT_DIAGNOSTICINFO: return "获取诊断信息失败";
        case ResponseStatus.ERR_PARTICIPANT_DIAL: return "拨号失败";
        case ResponseStatus.ERR_PARTICIPANT_REPEAT: return "与会者已存在";
        case ResponseStatus.ERR_PARTICIPANT_LOGGER: return "会议日志获取失败";
        case ResponseStatus.ERR_PARTICIPANT_MONITORTERMINAL: return "实时监控获取失败";

        //系统配置
        case ResponseStatus.ERR_SYSTEM_APPROVE: return "审批流配置失败";
        case ResponseStatus.ERR_SYSTEM_APPROVE_QUERY: return "审批流查询失败";
        case ResponseStatus.ERR_SYSTEM_AD_QUERY: return "AD域查询失败";
        case ResponseStatus.ERR_SYSTEM_setADSet: return "AD域设置失败";
        case ResponseStatus.ERR_SYSTEM_TIMEOUT: return "系统超期，请联系管理员";
        case ResponseStatus.ERR_SYSTEM_GLOBALCONFIG: return "配置保存失败";
        case ResponseStatus.ERR_SYSTEM_GLOBALCONFIG_QUERY: return "配置查询失败";
        case ResponseStatus.ERR_SYSTEM_UPDATESYSTEM: return "软件升级失败";
        case ResponseStatus.ERR_SYSTEM_VERSONINFO: return "版本信息读取失败";
        case ResponseStatus.ERR_SYSTEM_SERIALNUMBERINFO:return "序列号获取失败";
        case ResponseStatus.ERR_SYSTEM_UPDATEPERMIT:return "许可上传失败";
        case ResponseStatus.ERR_SYSTEM_VERIFYPERMIT:return "登陆失败！用户许可已经过期，请联系管理员";
        case ResponseStatus.ERR_SYSTEM_ANOMALYVERIFYPERMIT:return "授权许可文件出错，请联系管理员更新授权许可";
        case ResponseStatus.ERR_SYSTEM_DOWNLOADLOG:return "日志下载失败";
        case ResponseStatus.ERR_SYSTEM_BACKUPSQL:return "数据库备份失败";
        case ResponseStatus.ERR_SYSTEM_NTP:return "NTP配置异常";
        case ResponseStatus.ERR_SYSTEM_NETWORK:return "网络配置异常";
        case ResponseStatus.ERR_SYSTEM_importLogo:return "用户logo上传失败";
        case ResponseStatus.ERR_SYSTEM_importTitle:return "登录页标题更改失败";
        case ResponseStatus.ERR_SYSTEM_readTitle:return "登录页标题读取失败";
        case ResponseStatus.ERR_SYSTEM_REGISTERSERVER_ADD:return "注册服务器添加失败";
        case ResponseStatus.ERR_SYSTEM_REGISTERSERVER_ADD_IP:return "注册服务器IP地址已存在";
        case ResponseStatus.ERR_SYSTEM_REGISTERSERVER_UPDATE:return "注册服务器更新失败";
        case ResponseStatus.ERR_SYSTEM_REGISTERSERVER_DELETE:return "注册服务器删除失败";
        case ResponseStatus.ERR_SYSTEM_RESETDB:return "数据库还原失败";
        case ResponseStatus.ERR_SYSTEM_SERVERINFO:return "服务器信息读取失败";
        case ResponseStatus.ERR_SYSTEM_RECORD_QUERY:return "录播信息读取失败";
        case ResponseStatus.ERR_SYSTEM_RECORD_UPDATE:return "录播信息更新失败";
        case ResponseStatus.ERR_SYSTEM_RECORD_DELETE:return "录播信息删除失败";
        case ResponseStatus.ERR_ATTRIBUTION_QUERY:return "电话归属地区号匹配失败";
        case ResponseStatus.ERR_SYSTEM_DBZIP:return "数据库文件压缩失败";
        case ResponseStatus.ERR_SYSTEM_CPU:return "CPU信息读取失败";
        


        case ResponseStatus.CLEARSESSION: return "清除session失败";
        case ResponseStatus.DOWNLOADERROR: return "下载失败";
        //组织机构
        case ResponseStatus.ERR_ORGANIZATION_ADD: return "组织机构添加失败";
        case ResponseStatus.ERR_ORGANIZATION_DELETE: return "组织机构删除失败";
        case ResponseStatus.ERR_ORGANIZATION_QUERY: return "组织机构查询失败";
        case ResponseStatus.ERR_ORGANIZATION_UPDATE: return "组织机构修改失败";
        case ResponseStatus.ERR_ORGANIZATION_orgExport: return "组织机构导出失败";
        case ResponseStatus.ERR_ORGANIZATION_orgDownload: return "组织机构模板下载失败";
        case ResponseStatus.ERR_ORGANIZATION_import: return "组织机构导入失败";
        case ResponseStatus.ERR_ORGANIZATION_SORT: return "组织机构排序失败";
        case ResponseStatus.ERR_ORGANIZATION_DUPLICATE: return "重复的组织机构名称";
      
        //日志
        case ResponseStatus.ERR_LOG_QUERY: return "日志查询失败";
        case ResponseStatus.ERR_LOG_logExport: return "日志导出(EXCEL)失败";
        case ResponseStatus.ERR_LOG_DELETE: return "日志删除失败";
        case ResponseStatus.ERR_LOG_logExportTXT: return "日志导出(TXT)失败";
        case ResponseStatus.ERR_LOG_ZIP: return "日志压缩失败";
        
        
        //用户
        case ResponseStatus.ERR_USER_ADD: return "用户添加失败";
        case ResponseStatus.ERR_USER_DELETE: return "用户删除失败";
        case ResponseStatus.ERR_USER_QUERY: return "用户查询失败";
        case ResponseStatus.ERR_USER_UPDATE: return "用户修改失败";
        case ResponseStatus.ERR_USER_userExport: return "用户导出失败";
        case ResponseStatus.ERR_USER_userDownload: return "用户模板下载失败";
        case ResponseStatus.ERR_USER_userImport: return "用户导入失败";
        case ResponseStatus.ERR_USER_updateUserRole: return "修改用户角色失败";
        case ResponseStatus.ERR_USER_SORT: return "用户排序失败";
        case ResponseStatus.ERR_USER_ERROR: return "账号或密码错误,请重新输入!";
        case ResponseStatus.ERR_USER_ISENABLE: return "此用户已被禁用，请联系系统管理员!";
        case ResponseStatus.ERR_USER_importHead: return "用户头像上传失败!";
        case ResponseStatus.ERR_USER_UPDATEPWD: return "用户修改密码失败";
        case ResponseStatus.ERR_USER_ISADMIN: return "该用户不是管理员";
        case ResponseStatus.ERR_USER_SIGN: return "签到失败";
        case ResponseStatus.ERR_USER_UPDATEMAXATTEND: return "更新用户最大方数失败";
        case ResponseStatus.ERR_USER_QUERYPRIVILEGE: return "查询用户会议权限失败";
        case ResponseStatus.USER_SIGN_RESULT: return "签到结果";

        //角色
        case ResponseStatus.ERR_ROLE_ADD: return "角色添加失败";
        case ResponseStatus.ERR_ROLE_DELETE: return "角色删除失败";
        case ResponseStatus.ERR_ROLE_QUERY: return "角色查询失败";
        case ResponseStatus.ERR_ROLE_UPDATE: return "角色修改失败";
        case ResponseStatus.ERR_ROLE_roleExport: return "角色导出失败";
        case ResponseStatus.ERR_ROLE_roleDownload: return "角色模板下载失败";
        case ResponseStatus.ERR_ROLE_roleImport: return "角色导入失败";
        
        //权限
        case ResponseStatus.ERR_PRIVILEGE_QUERY: return "角色权限查询失败";
        case ResponseStatus.ERR_PRIVILEGE_ADDALLREADWRITESHOW: return "新增权限失败";
        case ResponseStatus.ERR_PRIVILEGE_DELETEALLREADWRITESHOW: return "删除权限失败";
        case ResponseStatus.ERR_PRIVILEGE_ADDALLSCOPE: return "修改权限范围失败";
        
        
        //会议室分组
        case ResponseStatus.ERR_MEETINGGROUP_ADD: return "会议室分组添加失败";
        case ResponseStatus.ERR_MEETINGGROUP_DELETE: return "会议室分组删除失败";
        case ResponseStatus.ERR_MEETINGGROUP_QUERY: return "会议室分组查询失败";
        case ResponseStatus.ERR_MEETINGGROUP_UPDATE: return "会议室分组修改失败";
        case ResponseStatus.ERR_MEETINGGROUP_SORT: return "会议室分组排序失败";
        case ResponseStatus.ERR_MEETINGGROUP_Export: return "会议室分组导出失败";
        case ResponseStatus.ERR_MEETINGGROUP_Download: return "会议室分组模板下载失败";
        case ResponseStatus.ERR_MEETINGGROUP_Upload: return "会议室分组导入失败";
        
        //会议室
        case ResponseStatus.ERR_MEETINGROOM_ADD: return "会议室添加失败";
        case ResponseStatus.ERR_MEETINGROOM_DELETE: return "会议室删除失败";
        case ResponseStatus.ERR_MEETINGROOM_QUERY: return "会议室查询失败";
        case ResponseStatus.ERR_MEETINGROOM_UPDATE: return "会议室修改失败";
        case ResponseStatus.ERR_MEETINGROOM_Export: return "会议室导出失败";
        case ResponseStatus.ERR_MEETINGROOM_Download: return "会议室模板下载失败";
        case ResponseStatus.ERR_MEETINGROOM_Upload: return "会议室导入失败";
        case ResponseStatus.ERR_MEETINGROOM_configurationProperties: return "获取会议室设备失败";
        case ResponseStatus.ERR_MEETINGROOM_findTerminalModels: return "获取終端型號失败";
        case ResponseStatus.ERR_MEETINGROOM_SORT: return "排序会议室失败";
        case ResponseStatus.ERR_MEETINGROOM_BATCHUPDATE: return "批量更新会议室失败";

 
        
        //MCU
        case ResponseStatus.ERR_MCU_ADD: return "新增MCU失败";
        case ResponseStatus.ERR_MCU_DELETE: return "删除MCU失败";
        case ResponseStatus.ERR_MCU_QUERY: return "查询MCU失败";
        case ResponseStatus.ERR_MCU_UPDATE: return "修改MCU失败";
        case ResponseStatus.ERR_MCU_findMcuModels: return "获取MCU型號失败";
        case ResponseStatus.ERR_MCU_Export: return "MCU导出失败";
        case ResponseStatus.ERR_MCU_Download: return "MCU模板下载失败";
        case ResponseStatus.ERR_MCU_Upload: return "MCU导入失败";
        case ResponseStatus.ERR_MCU_findMcuInfo: return "MCU读取失败，请检查MCU配置";
        case ResponseStatus.ERR_MCU_Excel: return "MCU列表导出失败";
        
        //资源池
        case ResponseStatus.ERR_POOL_ADD: return "新增资源池失败";
        case ResponseStatus.ERR_POOL_DELETE: return "删除资源池失败";
        case ResponseStatus.ERR_POOL_QUERY: return "查询资源池失败";
        case ResponseStatus.ERR_POOL_UPDATE: return "修改资源池失败";
        case ResponseStatus.ERR_POOL_findTerminalList: return "获取指定资源池下的所有会议室失败";
        case ResponseStatus.ERR_POOL_findMcuList: return "获取指定资源池下的所有MCU失败";
        case ResponseStatus.ERR_POOL_addTerminal: return "更新指定的终端到资源池失败";
        case ResponseStatus.ERR_POOL_addMcu: return "更新指定的MCU到资源池失败";
        case ResponseStatus.ERR_POOL_sortMcu: return "资源池下的MCU排序失败";
        case ResponseStatus.ERR_POOL_POOLRSMONITORS: return "资源池监控失败";
        
        //短信
        case ResponseStatus.ERR_SMS_ADD: return "短信模板添加失败";
        case ResponseStatus.ERR_SMS_ISUSE: return "短信模板状态更新失败";
        case ResponseStatus.ERR_SMS_DELETE: return "短信模板删除失败";
      
        //会议标签
        case ResponseStatus.ERR_TAG_REPEAT: return "会议标签重名";
        case ResponseStatus.ERR_TAG_ADD: return "会议标签添加失败";
        case ResponseStatus.ERR_TAG_UPDATE: return "会议标签更新失败";
        case ResponseStatus.ERR_TAG_DELETE: return "会议标签删除失败";
        
        //我的联系人
        case ResponseStatus.ERR_CONTACT_ININT: return "读取联系人分组失败";
        case ResponseStatus.ERR_CONTACT_ADDGROP: return "添加联系人分组失败";
        case ResponseStatus.ERR_CONTACT_UPDATE: return "更新失败";
        case ResponseStatus.ERR_CONTACT_QUERY: return "联系人查询失败";
        case ResponseStatus.ERR_CONTACT_ADDCONTACT: return "添加分组联系人失败";
        case ResponseStatus.ERR_CONTACT_DELETE: return "删除失败";
        case ResponseStatus.ERR_EXPORT_MYCONTACT: return "导出我的联系人失败";
        case ResponseStatus.ERR_CONTACT_contactDownload: return "下载我的联系人模板失败";
        case ResponseStatus.ERR_CONTACT_contactImport: return "导入我的联系人失败";

        //项目
        case ResponseStatus.ERR_GET_PROJECT_LIST: return "获取项目失败";
        case ResponseStatus.ERR_GET_NODE_LIST: return "获取节点列表失败";
        case ResponseStatus.ERR_AUTH_FAILURE: return "Invalid api key or secret";
        case ResponseStatus.ERR_SYNC_USER: return "同步用户和组织失败";
        case ResponseStatus.ERR_FILE_LIST: return "获取文件列表失败";
        case ResponseStatus.ERR_FILE_UPLOAD: return "上传文件失败";
        case ResponseStatus.ERR_FILE_SUMMARY_ID: return "获取纪要id失败";
        case ResponseStatus.ERR_SAVE_SUMMARY: return "上传纪要失败";
        case ResponseStatus.ERR_GET_APPROVE: return "获取审批失败";
        case ResponseStatus.ERR_GET_PREVIEW: return "获取预览文件失败";

        case ResponseStatus.ERR_EXPORT_EXCEL: return "导出列表失败";
        case ResponseStatus.ERR_UKNOWN: return "未知错误";
        case ResponseStatus.ERR_UNKNOWN: return "";
	    default: return "未知错误";
	    }
	}
}
