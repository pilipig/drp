package com.gmm.drp.dao;

import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.Role;
import com.gmm.drp.entity.User;
import com.gmm.drp.entity.UserRole;
import com.gmm.drp.vo.MenuVo;
import com.gmm.drp.vo.UserRoleVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface UserDao {


    //注册
    @Insert("insert into t_user (no, username,password, createdate,flag)values ( #{no}, #{username},#{password},now(),1)")
    int insert(User user);

    //登录
    @Select("select * from t_user where no=#{username} or username =#{username} and flag=1")
    @ResultType(User.class)
    User selectByName(String name);


    //修改密码
    @Update("update t_user set password=#{newpass} where id=#{uid} and password=#{oldpass}")
    @ResultType(Map.class)
    int updatePassword(Map<String, Object> map);
    //int updatePass(@Param("uid") int uid, @Param("oldpass") String oldpass, @Param("newpass") String newPass);

    //查询数量
    @Select("select COUNT(*) from t_user ")
    @ResultType(long.class)
    Long selectCount();

    @Select("select username,no from t_user where id=#{id}")
    @ResultType(User.class)
    List<User> selectUserNameById();

    //分页查询
    @Select("select * from t_user  order by createdate desc limit #{index},#{count}")
    @ResultType(User.class)
    List<User> selectByPage(@Param("index") int index, @Param("count") int count);

    //修改
    @Update("update t_user set no=#{no},username=#{username},flag=#{flag} where id={id}")
    int updateUserById(User user);


    @Update("update t_user set flag=#{flag} where id=#{id}")
    int updateFlag(@Param("flag")int flag,@Param("id") int id);

    //查询用户对应的菜单权限
    @Select("select m.id,m.name,m.icon  from t_menu m left join t_rolemenu rm on m.id=rm.menuid left join t_userrole ur on rm.roleid=ur.roleid  where m.type=1 and m.parentId=-1 and ur.userid=#{userid}")
    @ResultType(MenuVo.class)
    List<MenuVo> queryMenu(int id);

    @Select("select * from t_menu where parentId=#{pid}")
    @ResultType(Menu.class)
    List<Menu> queryMenuChild(int pid);

    @Select("select u.*,r.info rinfo,r.name rname,r.id rid from t_user u left join t_userrole ur on u.id=ur.uid left join t_role r on ur.rid=r.id ${tj}")
    @ResultType(UserRoleVo.class)
    @Options(statementType = StatementType.STATEMENT)
    public List<UserRoleVo> queryAll(@Param("tj") String tj);

    //添加人员角色
    @Insert("insert into t_userrole (userid, roleid)values (#{userid}, #{roleid})")
    int insertUserRole(@Param("userid") int userid,@Param("roleid") int roleid);
    //根据UID删除角色
    @Delete("delete from t_userrole where userid=#{userid}")
    int deleteByUid(Integer userid);
    //查询用户的角色
    @Select("select r.* from t_role r left join t_userrole ur on r.id=ur.roleid left join t_user u on u.id=ur.userid where u.id=#{id}")
    @ResultType(Role.class)
    List<Role> queryRole(int id);
}