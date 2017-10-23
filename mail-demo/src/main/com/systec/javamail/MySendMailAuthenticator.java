import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 向邮件服务器提交认证信息
 * Created by wh on 8/14/2017.
 */

public class MySendMailAuthenticator extends Authenticator {
    String username = "";
    String password = "";

    public MySendMailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username, password);
    }
}
