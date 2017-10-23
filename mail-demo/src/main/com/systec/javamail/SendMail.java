import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.Map.Entry;
/**
 * Created by wh on 8/14/2017.
 */
public class SendMail {

    private String smtp = "";   //邮件服务器主机名
    private String protocol = "";   //邮件传输协议
    private String username = "";   //登录用户名
    private String password = ""; //登录密码
    private String from = "";   //发件人地址
    private String to = "";     //收件人地址
    private String subject = "";    //邮件主题
    private String body = "";   //邮件内容

    Map<String, String> map;    //一个有规则的map, 用作嵌入图片
    //存放附件
    List<String> list;

    public SendMail(Map<String, String> map, Map<String, String> image, List<String> list) {
        this.smtp = map.get("smtp");
        this.protocol = map.get("protocol");
        this.username = map.get("username");
        this.password = map.get("password");
        this.from = map.get("from");
        this.to = map.get("to");
        this.subject = map.get("subject");
        this.body = map.get("body");
        this.map = image;
        this.list = list;
    }

    public void send() throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", this.protocol);
        props.setProperty("mail.host", this.smtp);
        props.put("mail.smtp.auth", true);

        //开启ssl加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        MySendMailAuthenticator ma = new MySendMailAuthenticator(this.username, this.password);
        Session session = Session.getInstance(props, ma);
        session.setDebug(false);

        MimeMessage msg = createMessage(session);
        Transport ts = session.getTransport();
        ts.connect();
        ts.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
        ts.close();
    }

    public MimeMessage createMessage(Session session) throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(this.from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(this.subject);

        MimeMultipart allMultipart = new MimeMultipart();

        //创建代表邮件正文和附件的各个MimeBodyPart对象
        MimeBodyPart contentPart = createContent(this.body);
        allMultipart.addBodyPart(contentPart);

        //设置整个邮件内容为最终组合出的MimeMultiPart对象
        message.setContent(allMultipart);
        message.saveChanges();
        return message;
    }

    public MimeBodyPart createContent(String body) throws Exception {
        //创建代表组合Mime消息的MimeMultipart对象, 将该MimeMultipart对象保存到MimeBodyPart对象
        MimeBodyPart contentPart = new MimeBodyPart();
        MimeMultipart contentMultipart = new MimeMultipart("related");

        //创建用于保存HTML正文的MimeBodyPart对象, 并将它保存到MimeMultipart中
        MimeBodyPart htmlbodypart = new MimeBodyPart();
        htmlbodypart.setContent(body, "text/html;charset=UTF-8");
        contentMultipart.addBodyPart(htmlbodypart);

        /**显示邮件内容内嵌的图片 */
        if (map != null && map.size() > 0) {
            Set<Entry<String, String>> set = map.entrySet();
            for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
                Entry<String, String> entry = (Entry<String, String>) iterator.next();

                //创建用于保存图片的MimeBodyPart对象, 并将它保存到MimeMultipart中
                MimeBodyPart gifBodyPart = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(entry.getValue());  //图片所在地的目录的绝对路径

                gifBodyPart.setDataHandler(new DataHandler(fds));
                gifBodyPart.setContentID(entry.getKey());   //cid的值
                contentMultipart.addBodyPart(gifBodyPart);
            }
        }
        /**  邮件附件 */
        //创建用于组合邮件正文和附件的MimeMultiPart对象
        if (list != null &&  list.size()>0){
            for (int i =0;i<list.size();i++){
                MimeBodyPart fileBodyPart = new MimeBodyPart();
                FileDataSource fsd = new FileDataSource(list.get(i));
                fileBodyPart.setDataHandler(new DataHandler(fsd));
                String filename = list.get(i).substring(list.get(i).lastIndexOf("//") + 2, list.get(i).length());
                fileBodyPart.setFileName(MimeUtility.encodeText(filename));
                contentMultipart.addBodyPart(fileBodyPart);
            }
        }
        //将MimeMultiPart对象保存到MimeBodyPart对象
        contentPart.setContent(contentMultipart);
        return contentPart;
    }

}
