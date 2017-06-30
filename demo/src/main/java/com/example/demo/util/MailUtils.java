package com.example.demo.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 邮件发送
 *
 * @author qiyi.yang@hand-china.com
 * @create 2017-06-08
 */

public class MailUtils {

    private String protocol = "smtp";//邮件发送协议，默认是smtp;
    private String mailAuth = "true";//邮件发送身份验证，默认是smtp;
    private String mailHost;//邮件发送服务器地址

    private String subject;//邮件主题
    private String from;//发件人
    private String to;//收件人
    private List<String> ccs;//抄送
    private String content;//邮件正文

    private List<String> attachments;//附件

    private String userName;//邮件发送账号
    private String password;//邮件发送账号密码

    public MailUtils() {
    }

    public MailUtils(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMailAuth() {
        return mailAuth;
    }

    public void setMailAuth(String mailAuth) {
        this.mailAuth = mailAuth;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        if (StringUtils.isBlank(this.userName)) {
            return this.from.substring(0, this.from.indexOf("@") + 1);
        }
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getCcs() {
        return ccs;
    }

    public void setCcs(List<String> ccs) {
        this.ccs = ccs;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public void sendMail() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", this.protocol);
        properties.setProperty("mail.host", this.mailHost);
        properties.setProperty("mail.smtp.auth", this.mailAuth);

        Session session = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(session);//创建邮件
        message.setFrom(new InternetAddress(this.from));//设置发件人
        message.setRecipients(Message.RecipientType.TO, this.to);//设置收件人

        //抄送多人
        if (CollectionUtils.isNotEmpty(ccs)) {
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(getMailList(ccs)));
        }

        message.setSubject(this.subject);
        //文本部分
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent(this.content, "text/html;charset=UTF-8");

        //附件部分
        MimeMultipart mpart = new MimeMultipart();
        mpart.addBodyPart(textPart);
        if (CollectionUtils.isNotEmpty(attachments)) {
            for (String attachment : attachments) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                DataHandler dh = new DataHandler(new FileDataSource(attachment));
                String filename = dh.getName();//获取文件名
                attachmentPart.setDataHandler(dh);
                attachmentPart.setFileName(MimeUtility.encodeText(filename,"GBK",null));
                mpart.addBodyPart(attachmentPart);
            }
        }

        message.setContent(mpart);
        message.saveChanges();

        //发送邮件
        Transport ts = session.getTransport();
        ts.connect(this.userName, this.password);//连接
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    private String getMailList(List<String> ccs) {
        StringBuffer toList = new StringBuffer();
        for (int i = 0; i < ccs.size(); i++) {
            toList.append(ccs.get(i));
            if (i != (ccs.size() - 1)) {
                toList.append(",");
            }
        }
        return toList.toString();
    }

    public static List<String> strToList(String str) {
        List<String> list = new ArrayList();
        String[] split = str.split(";");
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

}
