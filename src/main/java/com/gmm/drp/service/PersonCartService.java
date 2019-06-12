package com.gmm.drp.service;

import com.gmm.drp.entity.PersonCart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonCartService {

    @Transactional
    int add(PersonCart personCart);

    //根据客户id获取购物车
    List<PersonCart> listCart(int personId);

    //修改购物车中的数量 goodsnum购买数量
    int updateNum(int id, int personId,int goodsnum);

    //批量删除商品
    int deleteCart(int id,List<Long> ids);


    //清空购物车
    int cleat(int personId);
}
