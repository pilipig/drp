package com.gmm.drp.dao;

import com.gmm.drp.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentDao {

    //删除部门 1显示 2 隐藏
    @Delete("update t_department set flag = 2 where id = #{id}")
    int deleteById(Integer id);

    //增加部门
    @Insert("insert into t_department (dname,uid ,createdate,flag) values ( #{dname},#{uid}, now(), 1)")
    int insert(Department department);

    ////查询名字根据falg
    @Select("select id,name from t_department where flag=1 ")
    @ResultType(Department.class)
    List<Department> selectByFlag();

    @Update("update t_department set dname = #{dname} where flag=1 and id = #{id}")
    //修改
    int updateById(@Param("dname") String dname, @Param("id") int id);

    //查询总数
    @Select("select count(*) from t_department where flag =1")
    @ResultType(long.class)
    Long selectCount();
    //分页
    @Select("select * from t_department where flag=1 order by createdate desc limit #{index},#{count}")
    @ResultType(Department.class)
    List<Department> selectByPage(@Param("index") int index, @Param("count") int count);

}