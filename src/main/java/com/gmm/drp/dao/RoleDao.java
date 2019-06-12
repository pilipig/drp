package com.gmm.drp.dao;

import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.Role;
import com.gmm.drp.entity.User;
import com.gmm.drp.vo.TreeNode;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    //新增角色
    @Insert("insert into t_role ( rname, rinfo,createuserid,createdate,flag)values ( #{rname}, #{rinfo}, #{createuserid},now(),1)")
    int insert(Role role);
    //删除角色
    @Delete("delete from t_role where id=#{id}")
    int delete(int id);

    //修改
    @Update("update t_role set rname=#{rname},rinfo=#{rinfo},flag=#{flag} where id=#{id}")
    int updateRole(Role role);
    //查询角色
    @Select("select * from t_role")
    List<Role> queryAll();
    //总数
    @Select("select count(*) from t_role")
    @ResultType(long.class)
    Long selectCount();

    //分页查询
    @Select("select * from t_role order by createdate desc limit #{index},#{count}")
    @ResultType(Role.class)
    List<Role> selectByPage(@Param("index") int index, @Param("count") int count);


    //查询角色对应的权限
    @Select("select m.* from t_menu m left join t_rolemenu rm on m.id=rm.menuid where rm.roleid=#{roleid}")
    @ResultType(Menu.class)
    List<Menu> queryMenuByRid(int roleid);
    @Select("select m.id,m.name,m.url,m.parentid from t_menu m order by m.parentid ")
    @ResultType(TreeNode.class)
    List<TreeNode> queryMenu();

    //修改角色对应的权限
    //新增角色对应的权限
    @Insert("insert into t_rolemenu(roleid,menuid) values(#{roleid},#{menuid});")
    int insertRoleMenu(@Param("roleid") int roleid, @Param("menuid") int menuid);
    //删除
    @Delete("delete from t_rolemenu where roleid=#{roleid}")
    int delAuth(int rid);
}