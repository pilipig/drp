package com.gmm.drp.dao;

import com.gmm.drp.entity.Cats;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CatsDao {

  //假删除
  @Update("update t_cats set dataflag=1 where id=#{id}")
  @ResultType(long.class)
  int delById(int id);

  //分页
  @Select("select * from t_cats where dataflag=0 limit #{index},#{count}")
  @ResultType(Cats.class)
  List<Cats> selectByPage(@Param("index") int index, @Param("count") int count);

  @Select("select COUNT(*) from t_cats where dataflag=0")
  @ResultType(long.class)
  Long selectCount();

  @Select("select * from t_cats where dataflag=0")
  @ResultType(Cats.class)
  List<Cats> selectAll();

  @Select("select * from t_cats where parentid=-1 and dataflag=0")
  @ResultType(Cats.class)
  List<Cats> showRoot();

  @Select("SELECT * from t_cats where parentid <> -1 and dataflag=0")
  @ResultType(Cats.class)
  List<Cats> showSecond();

  //新增
  @Insert("insert into t_cats VALUES(default,#{parentid},1,#{catname},0,NOW())")
  @Options(useGeneratedKeys = true)
  int add(Cats cats);


}
