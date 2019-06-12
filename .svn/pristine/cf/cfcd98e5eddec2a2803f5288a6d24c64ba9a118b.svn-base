package com.gmm.drp.dao;

import com.gmm.drp.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonDao {

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商品信息列表
     */
   /* @Select("select * from t_person")
    @ResultType(Person.class)
    List<Person> personList();*/

    /**
     * @Author:fuyinggang
     * @Date:分页
     * @Depict:
     */
    @Select("select * from t_person limit #{page},#{limit}")
    @ResultType(Person.class)
    List<Person> selectByPage(@Param("page") int page, @Param("limit") int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:总条数
     */
    @Select("select count(*) from t_person")
    @ResultType(Long.class)
    Long selectCount();

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户详情
     */
    @Select("select * from t_person where id=#{id}")
    @ResultType(Person.class)
    List<Person> personDetails(@Param("id") int id);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户喜欢
     */
    @Select("select l.create_time,p.personname,p.shopname,p.address,p.phone,p.sex,g.gname,l.is_delete from t_love as l left join t_person as p on p.id=l.pid left join t_goods as g on g.id=l.goods_id where p.id=#{pid}")
    @ResultType(Person.class)
    List<Person> personLove(@Param("pid") int pid);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户浏览记录
     */
    @Select("select p.personname,p.sex,p.shopname,p.phone,g.gname,r.begin_time,r.end_time from t_record as r left join t_person as p on p.id=r.pid left join t_goods as g on g.id=r.goods_id where p.id=#{pid}")
    @ResultType(Person.class)
    List<Person> personRcord(@Param("pid") int pid);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户登录日志
     */
    @Select("select l.login_time,l.quit_time,p.phoneip,p.personname,p.phone,p.phonetype,p.shopname,p.address from t_logs as l left join t_person as p on p.id=l.pid where p.id=#{pid}")
    @ResultType(Person.class)
    List<Person> personLoginLog(@Param("pid") int pid);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户搜索
     */
    @Select("<script>"
            + "select * from t_person"
            + "<where>"
            + "<choose>"
            + "<when  test='opValue==\"默认\"'>"
            + "concat(id,shopname,personname,sex,birthday,phone,address,phonetype,createdate,phoneip) like CONCAT('%',#{keyword},'%') "
            + "</when>"
            + "<when test='opValue==\"商铺名\"'>"
            + "shopname LIKE  CONCAT('%',#{keyword},'%')"
            + "</when>"
            + "<when test='opValue==\"联系人\"'>"
            + "personname LIKE  CONCAT('%',#{keyword},'%')"
            + "</when>"
            + "<when test='opValue==\"电话\"'>"
            + "phone LIKE  CONCAT('%',#{keyword},'%')"
            + "</when>"
            + "<when test='opValue==\"地址\"'>"
            + "address LIKE  CONCAT('%',#{keyword},'%')"
            + "</when>"
            + "</choose>"
            + "<if test='splitDateStart!=\"\" | splitDateEnd!=\"\" '>"
            + "  AND createdate BETWEEN #{splitDateStart} AND #{splitDateEnd}"
            + "</if>"
            + " limit #{page},#{limit}"
            + "</where>"
            + "</script>")
    @ResultType(Person.class)
    List<Person> personsearch(@Param("opValue") String opValue, @Param("keyword") String keyword, @Param("splitDateStart") String splitDateStart, @Param("splitDateEnd") String splitDateEnd, @Param("page") int page, @Param("limit") int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:查询后总条数
     */
    /*@Select("select count(*) from (select * from t_person where concat(id,shopname,personname,sex,birthday,phone,address,phonetype,createdate,phoneip) like CONCAT('%',#{keyword},'%') )a")*/
    @Select("<script>"
            + "select count(*) from "
            + "(select * from t_person where "
            + "<if test='opValue==\"默认\"'>"
            + " concat(id,shopname,personname,sex,birthday,phone,address,phonetype,createdate,phoneip) like CONCAT('%',#{keyword},'%')"
            + "</if>"
            + "<if test='opValue==\"商铺名\"'>"
            + " shopname like CONCAT('%',#{keyword},'%')"
            + "</if>"
            + "<if test='opValue==\"联系人\"'>"
            + " personname like CONCAT('%',#{keyword},'%')"
            + "</if>"
            + "<if test='opValue==\"电话\"'>"
            + " phone like CONCAT('%',#{keyword},'%')"
            + "</if>"
            + "<if test='opValue==\"地址\"'>"
            + " address like CONCAT('%',#{keyword},'%')"
            + "</if>"
            + "<if test='splitDateStart!=\"\" | splitDateEnd!=\"\" '>"
            + "  AND createdate BETWEEN #{splitDateStart} AND #{splitDateEnd}"
            + "</if>"
            + ") a"
            + "</script>")
    @ResultType(Long.class)
    Long personsearchtCount(@Param("opValue") String opValue, @Param("keyword") String keyword, @Param("splitDateStart") String splitDateStart, @Param("splitDateEnd") String splitDateEnd);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户喜欢的商品搜索
     */
    @Select("<script>"
            + "select * from (select l.create_time,p.personname,p.shopname,p.address,p.phone,p.sex,g.gname,p.id from t_love as l left join t_person as p on p.id=l.pid left join t_goods as g on g.id=l.goods_id where p.id=#{pid}) a"
            + "<where>"
            + "<if test='loveKeyword!=\"\" '>"
            + " a.gname like CONCAT('%',#{loveKeyword},'%')"
            + "</if>"
            + "<if test='splitDateLoveTimeStart!=\"\" | splitDateLoveTimeEnd!=\"\" '>"
            + "  and create_time BETWEEN #{splitDateLoveTimeStart} AND #{splitDateLoveTimeEnd}"
            + "</if>"
            + "<if test='splitDateLoveTimeStart==\"\" | splitDateLoveTimeEnd==\"\" | loveKeyword==\"\" '>"
            + " and a.id=#{pid} "
            + "</if>"
            + " limit #{page},#{limit}"
            + "</where>"
            + "</script>")
    @ResultType(Person.class)
    List<Person> loveSearch(@Param("loveKeyword") String loveKeyword, @Param("splitDateLoveTimeStart") String splitDateLoveTimeStart, @Param("splitDateLoveTimeEnd") String splitDateLoveTimeEnd, @Param("pid") int pid, @Param("page") int page, @Param("limit") int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户喜欢商品查询后总条数
     */
    @Select("<script>"
            + "select count(*) from "
            + "(select * from (select l.create_time,p.personname,p.shopname,p.address,p.phone,p.sex,g.gname from t_love as l left join t_person as p on p.id=l.pid left join t_goods as g on g.id=l.goods_id where p.id=#{pid}) a"
            + "<where>"
            + "a.gname like CONCAT('%',#{loveKeyword},'%')"
            + "<if test='splitDateLoveTimeStart!=\"\" | splitDateLoveTimeEnd!=\"\" '>"
            + "  AND create_time BETWEEN #{splitDateLoveTimeStart} AND #{splitDateLoveTimeEnd}"
            + "</if>"
            + "</where>"
            + ") b"
            + "</script>")
    @ResultType(Long.class)
    Long loveSearchCount(@Param("loveKeyword") String loveKeyword, @Param("splitDateLoveTimeStart") String splitDateLoveTimeStart, @Param("splitDateLoveTimeEnd") String splitDateLoveTimeEnd, @Param("pid") int pid);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索
     */
    @Select("<script>"
            + "select * from (select p.personname,p.sex,p.shopname,p.phone,g.gname,r.begin_time,r.end_time,p.id from t_record as r left join t_person as p on p.id=r.pid left join t_goods as g on g.id=r.goods_id where p.id=#{pid}) a"
            + "<where>"
            + "<if test='recordKeyword!=\"\" '>"
            + " a.gname like CONCAT('%',#{recordKeyword},'%')"
            + "</if>"
            + "<if test='startRecordTime!=\"\"'>"
            + "  and begin_time &gt;= DATE(#{startRecordTime})"
            + "</if>"
            + "<if test='endRecordTime!=\"\"'>"
            + "  and end_time &lt;= DATE(#{endRecordTime})"
            + "</if>"
            + "<if test='startRecordTime==\"\" | endRecordTime==\"\" | recordKeyword==\"\" '>"
            + " and a.id=#{pid} "
            + "</if>"
            + " limit #{page},#{limit}"
            + "</where>"
            + "</script>")
    @ResultType(Person.class)
    List<Person> recordSearch(@Param("recordKeyword") String recordKeyword, @Param("startRecordTime") String startRecordTime, @Param("endRecordTime") String endRecordTime, @Param("pid") int pid, @Param("page") int page, @Param("limit") int limit);


    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索后总条数
     */
    @Select("<script>"
            + "select count(*) from "
            + "(select * from (select p.personname,p.sex,p.shopname,p.phone,g.gname,r.begin_time,r.end_time,p.id from t_record as r left join t_person as p on p.id=r.pid left join t_goods as g on g.id=r.goods_id where p.id=#{pid}) a"
            + "<where>"
            + "<if test='recordKeyword!=\"\" '>"
            + " a.gname like CONCAT('%',#{recordKeyword},'%')"
            + "</if>"
            + "<if test='startRecordTime!=\"\"'>"
            + "  and begin_time &gt;= DATE(#{startRecordTime})"
            + "</if>"
            + "<if test='endRecordTime!=\"\"'>"
            + "  and end_time &lt;= DATE(#{endRecordTime})"
            + "</if>"
            + "<if test='startRecordTime==\"\" | endRecordTime==\"\" | recordKeyword==\"\" '>"
            + " and a.id=#{pid} "
            + "</if>"
            + "</where>"
            + ") b"
            + "</script>")
    @ResultType(Long.class)
    Long recordSearchCount(@Param("recordKeyword") String recordKeyword, @Param("startRecordTime") String startRecordTime, @Param("endRecordTime") String endRecordTime, @Param("pid") int pid);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户登录的日志
     */
    @Select("<script>"
            + "select * from (select l.login_time,l.quit_time,p.phoneip,p.personname,p.phone,p.phonetype,p.shopname,p.address,p.id from t_logs as l left join t_person as p on p.id=l.pid where p.id=#{pid}) a"
            + "<where>"
            + "<if test='logKeyword!=\"\" '>"
            + " a.phoneip like CONCAT('%',#{logKeyword},'%')"
            + "</if>"
            + "<if test='startLogTime!=\"\"'>"
            + "  and login_time &gt;= DATE(#{startLogTime})"
            + "</if>"
            + "<if test='endLogTime!=\"\"'>"
            + "  and quit_time &lt;= DATE(#{endLogTime})"
            + "</if>"
            + "<if test='startLogTime==\"\" | endLogTime==\"\" | logKeyword==\"\" '>"
            + " and a.id=#{pid} "
            + "</if>"
            + " limit #{page},#{limit}"
            + "</where>"
            + "</script>")
    @ResultType(Person.class)
    List<Person> logSearch(@Param("logKeyword") String logKeyword, @Param("startLogTime") String startLogTime, @Param("endLogTime") String endLogTime, @Param("pid") int pid, @Param("page") int page, @Param("limit") int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索后总条数
     */
    @Select("<script>"
            + "select count(*) from "
            + "(select * from (select l.login_time,l.quit_time,p.phoneip,p.personname,p.phone,p.phonetype,p.shopname,p.address,p.id from t_logs as l left join t_person as p on p.id=l.pid where p.id=#{pid}) a"
            + "<where>"
            + "<if test='logKeyword!=\"\" '>"
            + " a.phoneip like CONCAT('%',#{logKeyword},'%')"
            + "</if>"
            + "<if test='startLogTime!=\"\"'>"
            + "  and login_time &gt;= DATE(#{startLogTime})"
            + "</if>"
            + "<if test='endLogTime!=\"\"'>"
            + "  and quit_time &lt;= DATE(#{endLogTime})"
            + "</if>"
            + "<if test='startLogTime==\"\" | endLogTime==\"\" | logKeyword==\"\" '>"
            + " and a.id=#{pid} "
            + "</if>"
            + "</where>"
            + ") b"
            + "</script>")
    @ResultType(Long.class)
    Long logSearchCount(@Param("logKeyword") String logKeyword, @Param("startLogTime") String startLogTime, @Param("endLogTime") String endLogTime, @Param("pid") int pid);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:注册接口
     */
    @Insert("insert into t_person (password,shopname,personname,sex,birthday,phone,address,createdate) values (#{password},#{shopname},#{personname},#{sex},#{birthday},#{phone},#{address},now())")
    void personRegister(Person person);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:登录接口
     */
    @Select("select count(*) from t_person where phone = #{phone} and password = #{password}")
    int personLogin(Person person);
}