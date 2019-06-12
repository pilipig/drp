package com.gmm.drp.manager;

import com.gmm.drp.dao.GoodsDao;
import com.gmm.drp.entity.Goods;
import com.gmm.drp.vo.Price;
import com.gmm.drp.service.GoodsService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Description
 * @Author baohaipeng
 * @Date
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public R delGoodsById(int id) {
        return ResultUtil.setRes(goodsDao.delById(id));
    }


    /**
     * 置顶
     *
     * @param id
     * @return
     */
    @Override
    public R setTop(int id) {
        return ResultUtil.setRes((goodsDao.setTop(id)));
    }


    /**
     * 保存
     *
     * @param goods
     * @return
     */
    @Override
    public R save(Goods goods) {
        return ResultUtil.setRes(goodsDao.add(goods));
    }

    @Override
    public List<Goods> queryAll() {
        return goodsDao.selectAll();
    }

    /**
     * 分页
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageVo<Goods> queryByPage(int page, int limit) {
        PageVo<Goods> pageVo = new PageVo<Goods>();
        pageVo.setData(goodsDao.selectByPage((page - 1) * limit, limit));
        pageVo.setCode(0);
        pageVo.setCount(goodsDao.selectCount().intValue());
        return pageVo;
    }

    @Override
    public int add(Goods goods) {

        return goodsDao.add(goods);
    }

    /*@Override
    public int insert(Goods goods) {

        return null;
    }*/

    @Override
    public List<?> showAttribute() {

        return goodsDao.showAttribute();
    }

    /**
     * 拆分t_goods表中的price字段，提取其中的阶梯定价关键数据
     *
     * @param id
     * @return price对象
     */
    @Override
    public Price showPriceById(int id) {
        Price price = new Price();
        BigDecimal bigDecimal;
        double[] numlist = new double[4];//存放[num1_min,num2_min,num3_min,num4_min]
        BigDecimal[] pricelist = new BigDecimal[4]; //存放[price1,price2,price3,price4]
        String str = goodsDao.showPriceById(id);
        if (str != null) {
            String[] strings = str.split("\\|");
            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
                String[] num = strings[i].split("<=");
                numlist[i] = Double.valueOf(num[0]);
                int idx = num[1].lastIndexOf(":");
                str = num[1].substring(idx + 1, num[1].length());
                bigDecimal = new BigDecimal(str);
                pricelist[i] = bigDecimal;
            }
        }
        //将产品ID，num和price封装进Price实体类中
        price.setGoodsId(id);
        price.setNum1_min(numlist[0]);
        price.setNum2_min(numlist[1]);
        price.setNum3_min(numlist[2]);
        price.setNum4_min(numlist[3]);
        price.setPrice1(pricelist[0]);
        price.setPrice2(pricelist[1]);
        price.setPrice3(pricelist[2]);
        price.setPrice4(pricelist[3]);
        System.out.println("****************************************************");
        System.out.println(price.toString());
        return price;
    }

    /**
     * 通过拼接，将价格系统中的数据合成一个字段，保存在商品表中
     *
     * @param price
     * @return
     */
    @Override
    public R savePrice(Price price) {

        String str = null;
        Integer id = price.getGoodsId();
        // 0<=x<5:12|5<=x<10:13|10<=x<15:14|15<=x:15
        str = price.getNum1_min() + "<=x<" + price.getNum2_min() + ":" + price.getPrice1()
                + "|" +
                price.getNum2_min() + "<=x<" + price.getNum3_min() + ":" + price.getPrice2()
                + "|" +
                price.getNum3_min() + "<=x<" + price.getNum4_min() + ":" + price.getPrice2()
                + "|" +
                price.getNum4_min() + "<=x:" + price.getPrice4();

        return ResultUtil.setRes(goodsDao.updPriceById(str, id));
    }


}
