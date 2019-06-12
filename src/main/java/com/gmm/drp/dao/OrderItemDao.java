package com.gmm.drp.dao;

import com.gmm.drp.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;

public interface OrderItemDao {

    //增加订单详情
    @Insert("insert into t_orderitem (orderid, ordernum, goodsid, goodsname, goodsprice, goodsimage, goodsnum, promotionname, " +
            "goodsquality) values ( #{orderid}, #{ordernum},#{goodsid}, #{goodsname}, #{goodsprice},#{goodsimage}, #{goodsnum}," +
            " #{promotionname},#{goodsquality})")
    int insert(OrderItem record);



}