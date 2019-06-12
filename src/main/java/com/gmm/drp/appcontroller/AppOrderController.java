package com.gmm.drp.appcontroller;

import com.gmm.drp.entity.Order;
import com.gmm.drp.service.OrderService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppOrderController {

    @Autowired
    private OrderService orderService;

    //下单




    //收货
    @RequestMapping( value = "confirm.do",method = RequestMethod.POST)
    @ResponseBody
    public R sendGoods(Integer id){
        orderService.confirm(id);
        return ResultUtil.setOK("发货成功");
    }

}
