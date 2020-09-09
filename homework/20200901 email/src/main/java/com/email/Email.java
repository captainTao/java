package com.email;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws MessagingException {
        // 服务器地址:
        String smtp = "smtp.exmail.qq.com";
        // 登录用户名:
        final String username = "1@camera360.com";
        // 登录口令:
        final String password = "*****";//qq邮箱是口令牌，需要在账户->设置中开启smtp,获取口令牌
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "465"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        // props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        props.put("mail.smtp.ssl.enable", "true"); // ssl
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址:
        message.setFrom(new InternetAddress("1@camera360.com"));
        /**
        * 设置接收方地址:set,add方法都有添加单个，数组的方法
         * message.setRecipient(Message.RecipientType.TO, new InternetAddress("578628438@qq.com"));
         * 多个地址添加数组
         * message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("508628438@qq.com")});
         *
         * Message.RecipientType.TO是主送人，Message.RecipientType.CC抄送，BCC是密送
        * */
        String recipientUserString = "a@camera360.com,b@camera360.com";
        if (recipientUserString !=null && !recipientUserString.isEmpty()){
            InternetAddress[] addresses = new InternetAddress().parse(recipientUserString);
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setRecipients(Message.RecipientType.CC, "1@camera360.com");
        }
        // 设置邮件主题:
        message.setSubject("HomeWork: Email from a robot", "UTF-8");
        // 设置邮件纯文本的时候:
        // message.setText("Hi Xiaoming...", "UTF-8");

        // 一个multipart可以添加多个BodyPart
        Multipart multipart = new MimeMultipart();

        /*添加正文文本: */
        BodyPart textPart = new MimeBodyPart();
        String body = "<h3 align ='left'>Hi, buddy:<br>I'm a email robot!</h3>";
        textPart.setContent(body, "text/html;charset=utf-8");// 设置为网页格式:
        // textPart.setContent(body, "text/plain;charset=utf-8");// 设置为文字格式:
        multipart.addBodyPart(textPart);

        /*添加内嵌网页：*/
        // html text:
        BodyPart emTextPart = new MimeBodyPart();
        // 需要对图
        emTextPart.setContent("<h4>给你看个老照片：</h4><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
        multipart.addBodyPart(emTextPart);
        // html image:
        BodyPart emImagePart = new MimeBodyPart();
        emImagePart.setFileName("1.jpg");
        try(InputStream input = new FileInputStream("/Users/captain/Desktop/old.jpg")){
            emImagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "image/jpeg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置header, 与HTML的<img src="cid:img01">关联:
        emImagePart.setHeader("Content-ID", "<img01>");
        multipart.addBodyPart(emImagePart);

        /*添加image附件: */
        BodyPart imagePart = new MimeBodyPart();
        imagePart.setFileName("vivo.gif");// 文件名和真实名字可以不一致
        /*
        如果添加附件，需要设置文件名，并且添加一个DataHandler()，传入文件的MIME类型。
        二进制文件可以用application/octet-stream，Word文档则是application/msword
        */
        try (InputStream input = new FileInputStream("/Users/captain/Desktop/vivo.gif")){
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
            multipart.addBodyPart(imagePart);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置邮件内容为multipart:
        message.setContent(multipart);
        // 发送:
        Transport.send(message);
    }
}
