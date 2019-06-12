package com.gmm.drp.controller;

import com.gmm.drp.service.DeliverytimeService;
import com.gmm.drp.vo.Deliverytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DeliverytimeController
 * @Description
 * @Author baohaipeng
 * @Date
 * @Version 1.0
 */
@RestController
public class DeliverytimeController {
    @Autowired
    private DeliverytimeService deliverytimeService;

    @RequestMapping("showdeliverytime.do")
    public List<Deliverytime> showTime(){
        System.out.println("------showTime-----");
        return deliverytimeService.showTime();}

}
