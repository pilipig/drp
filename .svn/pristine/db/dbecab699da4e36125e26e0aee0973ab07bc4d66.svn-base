package com.gmm.drp.controller;

import com.gmm.drp.entity.Menu;
import com.gmm.drp.entity.User;
import com.gmm.drp.entity.UserLog;
import com.gmm.drp.service.UserService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.MenuVo;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import com.gmm.drp.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/userlogin.do")
    public R login(String username, String password, HttpServletRequest request) {
        User user = userService.login(username, password);
        if (user != null) {
            //登录成功
            //记录登录日志
            UserLog userLog = new UserLog();
            userLog.setPcip(request.getRemoteAddr());
            userLog.setUserid(user.getId());
            userService.saveLog(userLog);
            //通知Shiro登录成功
            Subject subject= SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            subject.getSession().setAttribute("user",user);

            subject.login(token);
            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }
    }

    //注册(人员添加)
    @PostMapping("userregister.do")
    public R save(User user){
        return userService.save(user);
    }

    //修改密码
    @PostMapping("updatepass.do")
    public R updatePass(String newpass,String oldpass){
        newpass = new Sha256Hash(newpass).toHex();
        oldpass = new Sha256Hash(oldpass).toHex();
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        //role.setCreateuserid(user.getId());
        int count = userService.updatePass(user.getId(),newpass,oldpass);
        if (count == 0){
            return ResultUtil.setERROR("原密码不正确");
        }
        SecurityUtils.getSubject().logout();
        return ResultUtil.setOK("修改成功");
    }

    //查询左菜单
    @GetMapping("/usermenus.do")
    public List<MenuVo> menus(){
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return userService.queryMenu(user.getId());
    }

    //人员展示
    @RequestMapping("userlist.do")
    @ResponseBody
    public PageVo<User> list(int page, int limit){
        return userService.queryByPage(page, limit);
    }

    //修改
    @RequestMapping("userupdate.do")
    public String updateUserByID(User user){

        if (userService.updateUserById(user).getCode()==200){
            return "userlist";
        }else {
            return "userupdate";
        }
    }


    @RequestMapping("username.do")
    public List<User> selectUsername(){
        return userService.selectUserNameById();
    }

    //退出注销
    @RequestMapping("userloginout.do")
    public String loginout(){
        Subject subject = SecurityUtils.getSubject();

        subject.logout();
        return "static/login";
    }


    //查询所有的用户对应的角色
    @RequestMapping("userall.do")
    @ResponseBody
    public PageVo<UserVo> queryAll(int page, int limit, @RequestParam(defaultValue = "") String no, @RequestParam(defaultValue = "1") int flag)
    {
        return userService.queryAll(page,limit,no,flag);
    }

    //有效--无效
    @RequestMapping("userdel.do")
    @ResponseBody
    public R del(int id)
    {
        if(userService.updateFlag(2,id)){
            return ResultUtil.setOK("OK");
        }else{
            return ResultUtil.setERROR("ERROR");
        }
    }
    //无效--有效
    @RequestMapping("userchange.do")
    @ResponseBody
    public R change(int id)
    {
        if(userService.updateFlag(1,id)){
            return ResultUtil.setOK("OK");
        }else{
            return ResultUtil.setERROR("ERROR");
        }
    }


    //编辑用户的角色
   @RequestMapping("userroleedit.do")
    @ResponseBody
    public R edit(int id,int[] rids){
        if(userService.updateRole(id,rids)){
            return ResultUtil.setOK("OK");
        }else{
            return ResultUtil.setERROR("ERROR");
        }
    }
}
