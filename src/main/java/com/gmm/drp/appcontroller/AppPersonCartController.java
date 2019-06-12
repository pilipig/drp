package com.gmm.drp.appcontroller;


import com.gmm.drp.entity.PersonCart;
import com.gmm.drp.service.PersonCartService;
import com.gmm.drp.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppPersonCartController {

    @Autowired
    private PersonCartService personCartService;

    //添加购物车

    @RequestMapping(value = "addcart.do",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody PersonCart personCart){
        int count = personCartService.add(personCart);
        if (count > 0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
