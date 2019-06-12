package com.gmm.drp.controller;

import com.gmm.drp.entity.Department;
import com.gmm.drp.service.DepartmentService;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //增加部门
    @RequestMapping(value = "departmentadd.do",method = RequestMethod.POST)
    @ResponseBody
    public String add(Department department){
        if (departmentService.insert(department)){
            return "department/departmentlist.html";
        }else {
            return "department/departmentadd";
        }
    }
    //修改
    @RequestMapping(value = "departmentupdate.do",method = RequestMethod.POST)
    @ResponseBody
    public String update(String dname, int id){
        if (departmentService.update(dname,id).getCode()==200){
            return "department/ddepartmentlist";
        }else {
            return "departmentupdate";
        }
    }
    //删除
    @RequestMapping(value = "departmentdelete.do",method = RequestMethod.POST)
    @ResponseBody
    public R delete(int id){
        return departmentService.delete(id);
    }

    //分页查询
    @RequestMapping(value = "departmentpage.do")
    @ResponseBody
    public PageVo<Department> queryPage(int page, int limit){
        return departmentService.queryPage(page,limit);
    }
    //查询名字

    @RequestMapping(value = "selectName.do",method = RequestMethod.POST)
    public List<Department> selectByFlag(){
        return departmentService.selectByFlag();
    }
}
