package com.gmm.drp.manager;

import com.gmm.drp.dao.MenuDao;
import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.Role;
import com.gmm.drp.service.MenuService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao mDao;

    @Override
    public R save(Menu menu) {
        return ResultUtil.setRes(mDao.insert(menu));
    }

    @Override
    public List<String> queryByUid(int userid) {
        return mDao.selectByUid(userid);
    }

    @Override
   public R delete(int id) {
        if (mDao.delete(id)>0){
            return ResultUtil.setOK("删除成功");
        }else {
            return ResultUtil.setERROR("删除失败");
        }
    }


    @Override
    public R update(Menu menu) {
        if (mDao.updateMenu(menu)>0){
            return ResultUtil.setOK("修改成功");
        }else {
            return ResultUtil.setERROR("修改失败");
        }
    }

    @Override
    public List<Menu> queryAll() {
        return mDao.selectAll();
    }

    @Override
    public PageVo<Menu> queryByPage(int page, int limit) {
        PageVo<Menu> pageVo=new PageVo<>();
        pageVo.setData(mDao.selectByPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(mDao.selectCount().intValue());
        return  pageVo;
    }

    @Override
    public List<Role> queryRole(int id) {
        return null;
    }

    @Override
    public List<Menu> queryFirst() {
        return mDao.queryFirst();
    }
}
