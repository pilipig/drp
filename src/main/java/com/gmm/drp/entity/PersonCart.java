package com.gmm.drp.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PersonCart {
    private Integer id;

    private Integer personid;

    private String personname;

    private Integer goodsid;

    private String goodsname;

    private BigDecimal retailprice;

    private BigDecimal marketprice;

    private String goodsimage;

    private Integer goodsnum;

    private Integer goodsdeliverytime;

    private Date createtime;

    private Integer catsid;

    private String catsname;

    private Integer goodsgrad;

    private Integer goodsgradid;

    public Integer getGoodsgradid() {
        return goodsgradid;
    }

    public void setGoodsgradid(Integer goodsgradid) {
        this.goodsgradid = goodsgradid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname == null ? null : personname.trim();
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public BigDecimal getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(BigDecimal retailprice) {
        this.retailprice = retailprice;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public String getGoodsimage() {
        return goodsimage;
    }

    public void setGoodsimage(String goodsimage) {
        this.goodsimage = goodsimage == null ? null : goodsimage.trim();
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Integer getGoodsdeliverytime() {
        return goodsdeliverytime;
    }

    public void setGoodsdeliverytime(Integer goodsdeliverytime) {
        this.goodsdeliverytime = goodsdeliverytime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCatsid() {
        return catsid;
    }

    public void setCatsid(Integer catsid) {
        this.catsid = catsid;
    }

    public String getCatsname() {
        return catsname;
    }

    public void setCatsname(String catsname) {
        this.catsname = catsname == null ? null : catsname.trim();
    }

    public Integer getGoodsgrad() {
        return goodsgrad;
    }

    public void setGoodsgrad(Integer goodsgrad) {
        this.goodsgrad = goodsgrad;
    }
}