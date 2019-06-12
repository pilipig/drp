package com.gmm.drp.dao;

import com.gmm.drp.entity.Order;
import com.gmm.drp.vo.OrderDetailVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {

    Long increment(String key, long delta);
   /* int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int updateByExampleSelective(@Param("order") Order order, @Param("example") OrderExample example);

    int updateByExample(@Param("order") Order order, @Param("example") OrderExample example);*/

    //根据id查询
    @Select("select * from t_order where id=#{id}")
    Order selectById(Integer id);


    //增加订单
    @Insert("insert into t_order (ordernum, personname, personid, personphone, goodsnum,  paytype, paytime, ordertime,  deliverytime, receivetime, province, " +
            "city, district, address,   orderstatus, goodsprice, orderprice,  phoneip, phonetype, remark, commenttime, deletestatus, actinfo " +
            "values (#{ordernum}, #{personname},#{personid}, #{personphone}, #{goodsnum},#{paytype}, #{paytime}, #{ordertime},  #{deliverytime}, #{receivetime},#{province}," +
            " #{city}, #{district}, #{address},   #{orderstatus}, #{goodsprice}, #{orderprice},#{phoneip}, " +
            "#{phonetype}, #{remark},  #{commenttime}, #{deletestatus},#{actinfo})")
    int insert(Order order);



    //根据orderID查询
    @Select("select o.*,p.personname from t_order o left join t_person p on o.personid = p.id where o.id =#{id}")
    @ResultType(Order.class)
    Order queryByOrderId(Object id);
    //修改订单

   /* @Update(" update t_order set ordernum = #{ordernum}, personname = #{personname},personphone = #{personphone},goodsnum = #{goodsnum},paytype = #{paytype} ," +
            "paytime = #{paytime},ordertime = #{ordertime},deliverytime = #{deliverytime},receivetime = #{receivetime},province = #{province},city = #{city}," +
            "district = #{district},address = #{address}, orderstatus = #{orderstatus}, goodsprice = #{goodsprice},orderprice = #{orderprice},  phoneip = #{phoneip}, phonetype = #{phonetype}, remark = #{remark}, " +
            "commenttime = #{commenttime}, deletestatus = #{deletestatus}, actinfo = #{actinfo,jdbcType=VARCHAR} where id = #{id}")*/
   int updateById(Order order);
    //发货
    @Update("update t_order  set orderstatus=#{orderstatus} where id=#{id}")
    int updateStatus(Order order);

    //确认收货
    //int updateTake(Order order);



    //删除订单
    @Delete("delete from t_order where id=#{id}")
    int deleteByID(int id);
    //查询总数
    @Select("select count(*) from t_order")
    @ResultType(long.class)
    Long selectCount();
    //分页
    //@Select("select id,personname,personphone,number,orderstatus,goodsprice,orderprice,ordertime,deliverytime,phoneip,phonetype,remark,CONCAT(province,city,district,address) as adds from t_order order by ordertime desc limit #{index},#{count}")


    @Select("SELECT o.id,o.ordernum,o.personname,o.paytype,o.personid,o.personphone,o.goodsnum,o.ordertime,o.deliverytime,o.province,o.city,o.district,o.address,o.orderstatus,o.goodsprice,o.orderprice,o.phoneip,o.phonetype,o.remark ,oi.goodsname,oi.goodsprice,oi.goodsimage,oi.goodsnum from t_order o LEFT JOIN t_orderitem oi  ON o.id = oi.orderid order by ordertime desc limit #{index},#{count}")
    //@Select("SELECT id,ordernum,personname,personid,personphone,goodsnum,ordertime,deliverytime,province,city,district,address,orderstatus,goodsprice,orderprice,phoneip,phonetype,remark from t_order  order by ordertime desc limit #{index},#{count}")
    @ResultType(Order.class)
    List<Order> selectByPage(@Param("index") int index,@Param("count") int count);




    /**
     * 获取订单详情
     */
    //包含操作人员历史
    /*@Select("SELECT o.*, oi.id, oi.orderid, oi.ordernum, oi.goodsid , oi.goodsname, oi.goodsprice, oi.goodsimage,  oi.goodsnum , oi.promotionname , oi.goodsquality, oh.id, oh.operateman, oh.createtime, oh.orderstatus, oh.info" +
            " FROM t_order o LEFT JOIN t_orderitem oi ON o.id = oi.orderid LEFT JOIN t_orderhistory oh ON o.id = oh.orderid WHERE o.id = #{id} ORDER BY oi.id ASC,oh.createtime DESC")*/
    @Select("SELECT o.*, oi.id, oi.orderid, oi.ordernum, oi.goodsid , oi.goodsname, oi.goodsprice, oi.goodsimage,  oi.goodsnum , oi.promotionname , oi.goodsquality FROM t_order o LEFT JOIN t_orderitem oi ON o.id = oi.orderid WHERE o.id = #{id}")
    OrderDetailVo getDetail(@Param("id") int id);

    //批量发货
    /*@Update("update t_order set ordernum=#{ordernum} where id=#{id}")
    int delivery(@Param("list") List<Order> orders);*/


   /* *//**
     * 条件查询订单 //模糊查询
     *//*
    @Select("SELECT * FROM t_order WHERE deletestatus = 0\n" +
            "    <if test=\"queryParam.orderNum!=null and queryParam.orderNum!=''\">\n" +
            "      AND ordernum = #{queryParam.orderNum}\n" +
            "    </if>\n" +
            "    <if test=\"queryParam.orderStatus!=null\">\n" +
            "      AND `orderstatus` = #{queryParam.orderStatus}\n" +
            "    </if>\n" +
            "    <if test=\"queryParam.orderTime!=null and queryParam.orderTime!=''\">\n" +
            "      AND ordertime LIKE concat(#{queryParam.orderTime},\"%\")\n" +
            "    </if>\n" +
            "    <if test=\"queryParam.receiverKeyword!=null and queryParam.receiverKeyword!=''\">\n" +
            "      AND (\n" +
            "      takename LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\")\n" +
            "      OR takephone LIKE concat(\"%\",#{queryParam.receiverKeyword},\"%\")\n" +
            "      )\n" +
            "    </if>")
    @ResultType(Order.class)
    List<Order> getList(@Param("queryParam") OrderQueryVo queryParam);

    *//**
     * 批量发货
     *//*
    @Update("UPDATE t_order SET ordernum = CASE id\n" +
            "    <foreach collection=\"list\" item=\"item\">\n" +
            "      WHEN #{item.orderId} THEN #{item.ordernum}\n" +
            "    </foreach> END,\n" +
            "    deliverytime = CASE id\n" +
            "    <foreach collection=\"list\" item=\"item\">\n" +
            "      WHEN #{item.orderId} THEN now()\n" +
            "    </foreach> END,\n" +
            "    `orderstatus` = CASE id\n" +
            "    <foreach collection=\"list\" item=\"item\">\n" +
            "      WHEN #{item.orderId} THEN 2\n" +
            "    </foreach>\n" +
            "    END\n" +
            "    WHERE\n" +
            "    id IN\n" +
            "    <foreach collection=\"list\" item=\"item\" separator=\",\" open=\"(\" close=\")\">\n" +
            "      #{item.orderId}\n" +
            "    </foreach>\n" +
            "    AND `orderstatus` = 1")
    int delivery(@Param("list") List<Order> orders);*/





}