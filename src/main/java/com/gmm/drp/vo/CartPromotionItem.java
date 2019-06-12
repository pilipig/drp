package com.gmm.drp.vo;

import com.gmm.drp.entity.PersonCart;

/**
 * Created by macro on 2018/8/27.
 * 购物车中促销信息的封装
 */
public class CartPromotionItem extends PersonCart{
    //促销活动信息
    private String promotionMessage;
    //商品的真实库存（剩余库存-锁定库存）
    private Integer gstock;
    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }
}
