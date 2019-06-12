package com.gmm.drp.controller;

import com.gmm.drp.entity.Cats;
import com.gmm.drp.service.CatsService;

import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CatsController
 * @Description 产品分类
 * @Author baohaipeng
 * @Date 2019-04-09
 * @Version 1.0
 */
@RestController
public class CatsController {
    @Autowired
    private CatsService catsService;

    //分页
    @RequestMapping("catslist.do")
    public PageVo<Cats> list(int page, int limit) {

        return catsService.queryByPage(page, limit);
    }

    //展示一级分类
    @RequestMapping("showrootcats.do")
    public List<Cats> rootlist() {
        return catsService.showRootCats();
    }

    //展示二级分类
    @RequestMapping("showsecondcats.do")
    public List<Cats> secondlist() {
        return catsService.showSecondCats();
    }

    //删除分类
    @RequestMapping("delcatsbyid.do")
    public R delCatsById(int id) {
        return catsService.delCatsById(id);
    }

    //增加分类
    @RequestMapping("catsadd.do")
    public R save(Cats cats){
        return catsService.save(cats);
    }


}
