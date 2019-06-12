package com.gmm.drp.service;

import com.gmm.drp.entity.Goods;
import com.gmm.drp.vo.Price;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAll();

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    PageVo<Goods> queryByPage(int page,int limit);

    /**
     * 保存
     * @param goods
     * @return
     */
    R save(Goods goods);

    int add(Goods goods);

    List<?> showAttribute();

    Price showPriceById(int id);

    R delGoodsById(int id);

    R setTop(int id);

    /**
     * 保存价格系统
     * @param price
     * @return
     */
    R savePrice(Price price);
}
