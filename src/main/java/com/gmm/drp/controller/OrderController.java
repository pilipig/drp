package com.gmm.drp.controller;

import com.gmm.drp.entity.Order;
import com.gmm.drp.service.OrderService;
import com.gmm.drp.utils.CommonResult;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.OrderDetailVo;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    //分页
    @RequestMapping("orderlist.do")
    //@ResponseBody
    public PageVo<Order> list(int page, int limit){
        return orderService.queryByPage(page,limit);
    }

    //删除
    @RequestMapping("orderdel.do")
    @ResponseBody
    public R delete(int id){
        return orderService.deleteOrder(id);
    }

    //获取订单详细信息
    @RequestMapping("getdetail.do")
    public Object getDetail(int id){
        OrderDetailVo orderDetailVo = orderService.getDetail(id);
        return new CommonResult().success(orderDetailVo);
    }

    /*
    确认收货
     */
    /*@RequestMapping("confirm.do")
    public R confirm(Integer id){
        orderService.confirm(id);
        return ResultUtil.setOK("收货成功");
    }*/
    /*
    发货
     */
    @RequestMapping( value = "sendGoods.do",method = RequestMethod.POST)
    @ResponseBody
    public R sendGoods(Order order){
        orderService.sendGoods(order);
        return ResultUtil.setOK("发货成功");
    }
}
