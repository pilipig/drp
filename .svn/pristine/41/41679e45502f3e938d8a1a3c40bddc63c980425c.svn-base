package com.gmm.drp.service;

import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.Role;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;

import java.util.List;

public interface MenuService {

    //增加
    R save(Menu menu);
    //根据UID显示菜单
    List<String> queryByUid(int userid);

    //删除
    R delete(int id);
    //修改
    R update(Menu menu);

    //查询所有
    List<Menu> queryAll();
    //分页
    PageVo<Menu> queryByPage(int page, int limit);
    List<Role> queryRole(int id);

    //一级菜单
    List<Menu> queryFirst();
}
