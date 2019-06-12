package com.gmm.drp.dao;

import com.gmm.drp.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsDao {

    //置顶
    @Update("UPDATE t_goods SET sequence=9999 WHERE id=#{id}")
    @ResultType(long.class)
    int setTop(int id);

    //假删除
    @Update("update t_goods set issale=0 where id=#{id}")
    @ResultType(long.class)
    int delById(int id);

    //分页,并且根据sequence字段进行排序置顶
    @Select("select * from t_goods where issale=1 order by sequence DESC limit #{page},#{limit}")
    @ResultType(Goods.class)
    List<Goods> selectByPage(@Param("page") int page, @Param("limit") int limit);

    @Select("select COUNT(*) from t_goods where issale=1")
    @ResultType(long.class)
    Long selectCount();

    @Select("select * from t_goods where issale=1")
    @ResultType(Goods.class)
    List<Goods> selectAll();

    //goods表属性详情
    @Select("select g.gname,g.gadd,g.saletime,g.gdesc,g.iseventmer,g.sequence ,q.grading ,d.deliverytime from t_goods as g INNER JOIN t_qualitygrading as q INNER JOIN t_deliverytime as d on g.grad=q.id and g.deliverytime=d.id")
    List<?> showAttribute();

    //新增
/*
    @Insert("insert into t_goods (cats,gname,gadd,saletime,grad,gdesc,deliverytime,iseventmer,sequence) values (#{cats},#{gname},#{gadd},#{saletime},#{grad},#{gdesc},#{deliverytime},#{iseventmer},#{sequence})")
*/

/*
    @Insert("INSERT INTO t_goods (gname,gadd,gimg,saletime,gdesc,iseventmer,sequence,issale,grad,deliverytime,cats)VALUES(#{gname},#{gadd},#{gimg},#{saletime},#{gdesc},DEFAULT,#{sequence},DEFAULT,#{grad},#{deliverytime},#{cats})")
*/

    /*
        @Insert("\"<script>\"+\"INSERT INTO t_goods (gname,gadd,gimg,saletime,gdesc,iseventmer,sequence,issale,grad,deliverytime,cats)VALUES(#{gname},#{gadd},#{gimg},#{saletime},#{gdesc},\"+<if test=\"iseventmer!=null\">+iseventmer=#{iseventmer}+</if>+<if test=\"iseventmer==null\">+iseventmer=DEFAULT+</if>+\",#{sequence},DEFAULT,#{grad},#{deliverytime},#{cats})\"+\"</script>\"")
    */
    @Insert("<script>"
            + "INSERT INTO t_goods (gname,gadd,gimg,saletime,gdesc,iseventmer,sequence,issale,grad,deliverytime,cats)VALUES(#{gname},#{gadd},#{gimg},#{saletime},#{gdesc},"
            + "<if test='iseventmer!=null'>"
            + " 1"
            + "</if>"
            + "<if test='iseventmer==null'>"
            + " DEFAULT"
            + "</if>"
            + ",#{sequence},DEFAULT,#{grad},#{deliverytime},#{cats})"
            + "</script>")
    @Options(useGeneratedKeys = true)
    int add(Goods goods);

    //展示价格
    @Select("SELECT price from t_goods where id=#{id}")
    String showPriceById(int id);

    @Update("UPDATE t_goods SET price=#{price} WHERE id=#{id}")
    @ResultType(long.class)
    int updPriceById(String price,int id);

}
