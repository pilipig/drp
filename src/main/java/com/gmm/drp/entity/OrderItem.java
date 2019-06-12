package com.gmm.drp.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private Integer orderid;

    private String ordernum;

    private Integer goodsid;

    private String goodsname;

    private BigDecimal goodsprice;

    private String goodsimage;

    private String goodsnum;

    private String promotionname;

    private String goodsquality;

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

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
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

    public BigDecimal getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(BigDecimal goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsimage() {
        return goodsimage;
    }

    public void setGoodsimage(String goodsimage) {
        this.goodsimage = goodsimage == null ? null : goodsimage.trim();
    }

    public String getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(String goodsnum) {
        this.goodsnum = goodsnum == null ? null : goodsnum.trim();
    }

    public String getPromotionname() {
        return promotionname;
    }

    public void setPromotionname(String promotionname) {
        this.promotionname = promotionname == null ? null : promotionname.trim();
    }

    public String getGoodsquality() {
        return goodsquality;
    }

    public void setGoodsquality(String goodsquality) {
        this.goodsquality = goodsquality == null ? null : goodsquality.trim();
    }
}