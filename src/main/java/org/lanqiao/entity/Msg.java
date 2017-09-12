package org.lanqiao.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Msg {
    private Integer msgId;

    private String userSay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date time;

    private String userName;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getUserSay() {
        return userSay;
    }

    public void setUserSay(String userSay) {
        this.userSay = userSay == null ? null : userSay.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}