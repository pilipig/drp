package com.gmm.drp.dao;

import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.RoleMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMenuDao {

    /*//根据角色id删除角色菜单
    @Delete("delete from t_rolemenu where roleid=#{roleid}")
    int deleteByRid(Integer roleid);*/

    /*//增加角色
    @Insert("insert into t_rolemenu (roleid, menuid)values (#{roleid}, #{menuid})")
    int insert(RoleMenu roleMenu);*/

    /*//新增角色对应的权限
    @Insert("insert into t_rolemenu(roleid,menuid) values(#{roleid},#{menuid});")
    int insertAuth(@Param("roleid") int roleid, @Param("menuid") int menuid);*/

    /*//查询角色对应的权限
    @Select("select m.* from t_menu m left join t_rolemenu rm on m.id=rm.menuid where rm.roleid=#{roleid}")
    @ResultType(Menu.class)
    List<Menu> queryMenu(int roleid);*/

}