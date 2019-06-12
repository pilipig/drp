package com.gmm.drp.manager;

import com.gmm.drp.dao.DepartmentDao;
import com.gmm.drp.entity.Department;
import com.gmm.drp.entity.User;
import com.gmm.drp.service.DepartmentService;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public boolean insert(Department department) {
        //获取userID 添加
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        department.setUid(user.getId());
        return departmentDao.insert(department) > 0;
    }

    @Override
    public R update(String dname, int id) {
        if (departmentDao.updateById(dname,id)>0){
            return ResultUtil.setOK("修改部门成功");
        }else {
            return ResultUtil.setERROR("修改部门失败");
        }
    }

    @Override
    public R delete(int id) {
        if (departmentDao.deleteById(id)>0){
            return ResultUtil.setOK("删除成功");
        }else {
            return ResultUtil.setERROR("删除失败");
        }
    }

    @Override
    public PageVo<Department> queryPage(int page, int limit) {
       PageVo<Department> pageVo = new PageVo<>();
       pageVo.setData(departmentDao.selectByPage((page - 1)*limit,limit));
       pageVo.setCode(0);
       pageVo.setCount(departmentDao.selectCount().intValue());
       return pageVo;
    }

    @Override
    public List<Department> selectByFlag() {
        return departmentDao.selectByFlag();
    }
}
