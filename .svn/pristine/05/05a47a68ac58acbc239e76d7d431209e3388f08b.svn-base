package com.gmm.drp.service;

import com.gmm.drp.entity.Role;
import com.gmm.drp.entity.User;
import com.gmm.drp.entity.UserLog;
import com.gmm.drp.vo.MenuVo;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import com.gmm.drp.vo.UserVo;

import java.util.List;

public interface UserService {

    //注册
    R save(User user);
    //校验是否存在
    R checkName(String username);
    //登录---账号是否存在临时无效
    User login(String username,String password);
    void saveLog(UserLog userLog);
    //修改密码
    int updatePass(int uid, String newpass, String oldpass);

    //登录名
    List<User> selectUserNameById();
    //分页
    PageVo<User> queryByPage(int page, int limit);
    //修改人员
    R updateUserById(User user);
    //显示菜单
    List<MenuVo> queryMenu(int uid);

    //查询用户的角色
    List<Role> queryRole(int id);
    PageVo<UserVo> queryAll(int page, int count, String no, int flag);

    //更新角色
    boolean updateRole(int uid,int[] rids );
    boolean updateFlag(int flag,int id);
}
