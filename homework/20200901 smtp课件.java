package lianxi1;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.util.MailSSLSocketFactory;
public class Lianxi1 {
	public static void main (String[] args) throws Exception{
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.qq.com");//邮件服务器地址
        /*SMTP服务器地址：一般是 smtp.xxx.com，比如163邮箱是smtp.163.com，qq邮箱是smtp.qq.com。
        通常把处理用户smtp请求(邮件发送请求)的服务器称之为SMTP服务器(邮件发送服务器)
         */
		prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
	    prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名和授权码
        //设置ssl加密
	    MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //使用JavaMail发送邮件的5个步骤

        //创建定义整个应用程序所需的环境信息的 Session 对象

        Session session = Session.getInstance(prop);
        /*getDefaultInstance是真正单例模式，而且，里面的username和password属性是final型的，无法更改。
        所以，你会发现两封email都是由同一个人发出来的。
        所以这个时候你要使用javax.mail.Session.getInstance()方法来创建session对象。
         */
      //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        /*javax.mial.Transport类用于执行邮件的发送任务，
        其可以将Message对象中的封装的邮件数据发送到指定的SMTP服务器。
         */
        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "xx@qq.com", "xxxx");
        //4、创建邮件

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("xx@qq.com"));

        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("a@camera360.com"));
        //增加收件人
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("b@camera360.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("c@camera360.com") );
        //Message.RecipientType.TO是主送人，Message.RecipientType.cc抄送，bcc是密送
        //邮件的标题
        message.setSubject("测试发邮件");
        //准备图片数据
   //     MimeBodyPart image = new MimeBodyPart();
      //  DataHandler dh = new DataHandler(new FileDataSource("/Users/liuxinglong/Desktop/banner@2x的副本.png"));
       // image.setDataHandler(dh);
       // image.setContentID("banner@2x的副本.png");

        //邮件的文本内容
        message.setContent("你好啊！", "text/html;charset=UTF-8");

        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        //ts.close();
    }

}
	


