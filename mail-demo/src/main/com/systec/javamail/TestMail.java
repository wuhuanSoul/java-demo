import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wh on 8/14/2017.
 */
public class TestMail {

    public static void main(String[] args) throws Exception {
        String content = "<a href=http://www.baidu.com>点击进入百度</a><br/>" +
                "<img src=\"cid:aaa01\"><br/><br/>";

        Map<String, String> map = new HashMap<String, String>();
        map.put("smtp", "smtp.qq.com");
        map.put("protocol", "smtp");
        map.put("username", "2907524789@qq.com");
        map.put("password", "znzjuryhtoahddeb");
        map.put("from", "2907524789@qq.com");
        map.put("to", "1014256925@qq.com");
        map.put("subject", "标题");
        map.put("body", content);

        Map<String, String> image = new HashMap<String, String>();
        image.put("aaa01", "D://default.jpg");

        List<String> list = new ArrayList<String>();
        list.add("D://idea注册码.txt");
        list.add("D://会议管理功能清单-20170414.xlsx");

        SendMail sm = new SendMail(map, image, list);
        sm.send();
    }
}
