package com.gmm.drp.service;

import com.gmm.drp.entity.Order;
import com.gmm.drp.vo.OrderDetailVo;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;

import java.util.List;

public interface OrderService {


    //删除
    R deleteOrder(int id);
    //分页
    PageVo<Order> queryByPage(int page, int limit);

    //批量删除订单
    int delete(List<Long> ids);
    //批量关闭订单
    //int close(List<Long> ids, String remark);



    OrderDetailVo getDetail(int id);
    Order queryObject(Integer id);
    //确认收货
    int  confirm(Integer id);

    //发货
    int sendGoods(Order order);


}
