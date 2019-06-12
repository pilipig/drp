package com.gmm.drp.manager;

import com.gmm.drp.dao.MenuDao;
import com.gmm.drp.dao.UserDao;
import com.gmm.drp.dao.UserLogDao;
import com.gmm.drp.dao.UserRoleDao;
import com.gmm.drp.entity.*;
import com.gmm.drp.service.UserService;
import com.gmm.drp.utils.PassUtil;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao uDao;

    @Autowired
    private UserLogDao userLogDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private MenuDao menuDao;


    @Override
    public R save(User user) {
        user.setPassword(PassUtil.md5(user.getPassword()));
        return ResultUtil.setRes(uDao.insert(user));
    }

    @Override
    public R checkName(String username) {
        User user = uDao.selectByName(username);
        if (user == null){
            //可用
            return ResultUtil.setOK("用户名可用");
        }else {
            return ResultUtil.setERROR("用户名不可用");
        }
    }

    @Override
    public User login(String username, String password) {
        User user = uDao.selectByName(username);
       if(user!=null){
            //校验密码
            if(Objects.equals(user.getPassword(),PassUtil.md5(password))){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveLog(UserLog userLog) {
        userLogDao.insert(userLog);
    }

    //
    @Override
    public int updatePass(int uid, String newpass, String oldpass) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("newpass",newpass);
        map.put("oldpass",oldpass);
        return uDao.updatePassword(map);
    }


    /*//修改人员角色
    @Override
    public R updateRole(int[] rids, int uid) {
        uDao.deleteByUid(uid);
        for(int rid:rids){
            UserRole userRole=new UserRole();
            userRole.setRoleid(rid);
            userRole.setUserid(uid);
            uDao.insertUserRole(userRole);
        }
        return ResultUtil.setOK("修改用户角色成功");
    }*/

    @Override
    public List<MenuVo> queryMenu(int uid) {
        List<Menu> total=menuDao.selectByMenuUid(uid);
        System.out.println(total);
        List<MenuVo> menuVos=new ArrayList<>();
        for(Menu p:total){
            if(p.getParentid()==-1){
                MenuVo menuVo=new MenuVo();
                menuVo.setParent(p);
                menuVo.setChildrens(new ArrayList<>());
                menuVos.add(menuVo);
            }else{
                //二级菜单
                int index=indexParent(menuVos,p);
                if(index>-1){
                    //找到上级菜单  将当前资源对象添加到对应的孩子中
                    menuVos.get(index).getChildrens().add(p);
                }
            }
        }
        return menuVos;
    }

    @Override
    public List<Role> queryRole(int id) {
        return uDao.queryRole(id);
    }

    @Override
    public PageVo<UserVo> queryAll(int page, int count, String no, int flag) {
        StringBuffer where = new StringBuffer();
        where.append("where flag=" + flag);
        if(no.length()>0){
            where.append("and u.no='"+no+"' or u.username='"+no+"'");
        }
        List<UserRoleVo> list = uDao.queryAll(where.toString());
        List<UserVo> userVos = new ArrayList<>();
        for (UserRoleVo u:list){
            UserVo uv= indexOf(u.getId(),userVos);
            if (uv==null){
                uv = new UserVo(u.getId(),u.getNo(),u.getUsername(),u.getFlag());
                userVos.add(uv);
            }
            uv.getRole().add(u.getRinfo());
            uv.getRnames().add(u.getRname());
            uv.getRids().add(u.getRid());
        }
        PageVo<UserVo> pageVo = new PageVo<>();
        pageVo.setData(userVos);
        pageVo.setCount(pageVo.getData().size());
        pageVo.setCode(0);
        return pageVo;
    }

    //修改角色
    @Override
    public boolean updateRole(int uid, int[] rids) {
        try {
            uDao.deleteByUid(uid);
            for (int id :rids){
                uDao.insertUserRole(uid,id);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private UserVo indexOf(int id,List<UserVo> list){
        for(UserVo u:list){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }
    //修改flag 1 显示 2 隐藏
    @Override
    public boolean updateFlag(int flag, int id) {
        return uDao.updateFlag(flag,id)>0;
    }


    @Override
    public List<User> selectUserNameById() {
        return uDao.selectUserNameById();
    }

    @Override
    public PageVo<User> queryByPage(int page, int limit) {
        PageVo<User> pageVo=new PageVo<>();
        pageVo.setData(uDao.selectByPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(uDao.selectCount().intValue());
        return  pageVo;
    }

    @Override
    public R updateUserById(User user) {
        if (uDao.updateUserById(user) >0){
            return ResultUtil.setOK("修改成功");
        }else {
            return ResultUtil.setERROR("修改失败");
        }
    }

    private int indexParent(List<MenuVo> menuVos, Menu permission){
        for(int i=0;i<menuVos.size();i++){
            if(menuVos.get(i).getParent().getId().intValue()==permission.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }
}
