package com.example.demo.conf.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.UnsupportedEncodingException;

/**
 * @Description:邮件
 * @Author:qiyi.yang@hand-china.com
 * @CreateDate:2017-06-16
 */

@Configuration
@PropertySource(value = "classpath:mail.properties")
@ConfigurationProperties(prefix = "mail")
public class SendMailProperties {

    private String host;
    private String from;
    private String password;
    private String to;
    private String ccs;
    private String subject;
    private String content;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCcs() {
        return ccs;
    }

    public void setCcs(String ccs) {
        this.ccs = ccs;
    }

    public String getSubject() {
        try {
            return new String(subject.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                return new String(subject.getBytes("GBK"), "UTF-8");
            } catch (UnsupportedEncodingException e1) {
                return subject;
            }
        }
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        try {
            return new String(content.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                return new String(content.getBytes("GBK"), "UTF-8");
            } catch (UnsupportedEncodingException e1) {
                return content;
            }
        }
    }

    public void setContent(String content) {
        this.content = content;
    }
}
