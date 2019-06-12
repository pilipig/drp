package com.gmm.drp.service;

import com.gmm.drp.entity.Cats;
import com.gmm.drp.entity.Goods;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;

import java.util.List;

public interface CatsService {
    List<Cats> queryAll();

    PageVo<Cats> queryByPage(int page, int limit);

    //显示一级分类
    List<Cats> showRootCats();

    //显示二级分类
    List<Cats> showSecondCats();

    //删除
    R delCatsById(int id);

    //新增
    R save(Cats cats);
}
