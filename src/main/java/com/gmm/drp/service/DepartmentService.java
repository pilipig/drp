package com.gmm.drp.service;

import com.gmm.drp.entity.Department;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;

import java.util.List;

public interface DepartmentService {

    //增加
    boolean insert(Department department);

    //修改
    R update(String dname,int id);

    //删除
    R delete(int id);

    //分页
    PageVo<Department> queryPage(int page, int limit);

    //查询名字根据falg
    List<Department> selectByFlag();

}
