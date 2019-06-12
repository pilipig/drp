package com.gmm.drp.controller;

import com.gmm.drp.entity.Grading;
import com.gmm.drp.service.GradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName GradingController
 * @Description 产品品质分级
 * @Author baohaipeng
 * @Date 2019-04-15
 * @Version 1.0
 */
@RestController
public class GradingController {
    @Autowired
    private GradingService gradingService;

    @RequestMapping("showgrading.do")
    public List<Grading> showGrading(){return gradingService.showGrading();}

}
