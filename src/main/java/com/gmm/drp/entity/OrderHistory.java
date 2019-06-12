package com.gmm.drp.entity;

import java.util.Date;

public class OrderHistory {
    private Integer id;

    private Integer orderid;

    //操作人
    private String operateman;

    //操作时间
    private Date createtime;

    //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    private Integer orderstatus;

    //操作备注
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOperateman() {
        return operateman;
    }

    public void setOperateman(String operateman) {
        this.operateman = operateman;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}