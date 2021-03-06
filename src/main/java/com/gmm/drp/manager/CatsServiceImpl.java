package com.gmm.drp.manager;

import com.gmm.drp.dao.CatsDao;
import com.gmm.drp.entity.Cats;
import com.gmm.drp.entity.Goods;
import com.gmm.drp.service.CatsService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CatsServiceImpl
 * @Description
 * @Author
 * @Date
 * @Version 1.0
 */
@Service
public class CatsServiceImpl implements CatsService {

    @Autowired
    private CatsDao catsDao;
    @Override
    public List<Cats> queryAll() {
        return catsDao.selectAll();
    }

    @Override
    public PageVo<Cats> queryByPage(int page, int limit) {
        PageVo<Cats> pageVo = new PageVo<>();
        pageVo.setData(catsDao.selectByPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(catsDao.selectCount().intValue());
        return pageVo;
    }

    @Override
    public List<Cats> showRootCats() {
        return catsDao.showRoot();
    }

    @Override
    public List<Cats> showSecondCats() {
        return catsDao.showSecond();
    }

    @Override
    public R delCatsById(int id) {
        return ResultUtil.setRes(catsDao.delById(id));
    }

    @Override
    public R save(Cats cats) {
        return ResultUtil.setRes(catsDao.add(cats));
    }
}
