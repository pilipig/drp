package com.gmm.drp.manager;

import com.gmm.drp.dao.RoleDao;
import com.gmm.drp.dao.RoleMenuDao;
import com.gmm.drp.dao.UserRoleDao;
import com.gmm.drp.entity.*;
import com.gmm.drp.service.RoleService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import com.gmm.drp.vo.TreeNode;
import com.gmm.drp.vo.TreeRoot;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao rDao;

    //添加角色
    @Override
    public R save(Role role) {
        //获取userID 添加
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        role.setCreateuserid(user.getId());
        //System.out.println(user.getId());
        return ResultUtil.setRes(rDao.insert(role));
    }

    @Override
    public List<Role> queryAll() {
        return rDao.queryAll();
    }

    @Override
    public R delete(int id) {
        if (rDao.delete(id)>0){
            return ResultUtil.setOK("删除成功");
        }else {
            return ResultUtil.setERROR("删除失败");
        }
    }

    @Override
    public R update(Role role) {
        if (rDao.updateRole(role) > 0){
            return ResultUtil.setOK("修改成功");
        }else {
            return ResultUtil.setERROR("修改失败");
        }
    }


    //分页展示
    @Override
    public PageVo<Role> queryByPage(int page, int limit) {
        PageVo<Role> pageVo = new PageVo<>();
        pageVo.setData(rDao.selectByPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(rDao.selectCount().intValue());
        return pageVo;
    }

    //修改角色权限
    @Override
    public boolean updateMenu(int rid, int[] mids) {
        try{
            rDao.delAuth(rid);
            for(int i=0;i<mids.length;i++){
                rDao.insertRoleMenu(rid,mids[i]);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Menu> queryMenuByRid(int roleid) {
        return rDao.queryMenuByRid(roleid);
    }

    private TreeRoot indexOf(int id, List<TreeRoot> list){
        for(TreeRoot u:list){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

    //查询角色对应的权限
    @Override
    public List<TreeRoot> queryMenus() {
        List<TreeNode> list =  rDao.queryMenu();
        List<TreeRoot> roots = new ArrayList<>();
        for (TreeNode n:list){
            TreeRoot root ;
            if (n.getParentid()==-1){
                root = indexOf(n.getId(),roots);
                if (root == null){
                    root = new TreeRoot();
                    root.setId(n.getId());
                    root.setName(n.getName());
                    root.setChildren(new ArrayList<>());
                }
            }else {
                root = indexOf(n.getParentid(),roots);
                root.getChildren().add(n);
            }
        }
        return roots;
    }
}
