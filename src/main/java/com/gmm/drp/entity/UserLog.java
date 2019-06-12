package com.gmm.drp.entity;

import java.util.Date;

public class UserLog {
    private Integer id;

    private Integer userid;

    private String username;

    private Date createdate;

    private String pcip;

    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getPcip() {
        return pcip;
    }

    public void setPcip(String pcip) {
        this.pcip = pcip == null ? null : pcip.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }
}