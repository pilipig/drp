package com.gmm.drp.dao;

import com.gmm.drp.entity.PersonCart;
import com.gmm.drp.vo.CartPromotionItem;
import com.gmm.drp.vo.PersonCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonCartDao {


    int countByExample(PersonCartExample example);

    int deleteByExample(PersonCartExample example);

    int deleteByPrimaryKey(Integer id);

    //添加购物车
    /*@Insert("insert into t_personcart (personid, personname, goodsid, goodsname, retailprice,marketprice, goodsimage, goodsnum,goodsdeliverytime, createtime, catsid, " +
            "catsname, goodsgrad) values ( #{personid}, #{personname}, #{goodsid}, #{goodsname}, #{retailprice},#{marketprice}, #{goodsimage}, #{goodsnum}," +
            "#{goodsdeliverytime}, #{createtime}, #{catsid},#{catsname}, #{goodsgrad})")*/
    int insert(PersonCart record);


    int insertSelective(PersonCart record);

    List<PersonCart> selectByExample(PersonCartExample example);

    PersonCart selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") PersonCart record, @Param("example") PersonCartExample example);

    int updateByExample(@Param("record") PersonCart record, @Param("example") PersonCartExample example);

    int updateByPrimaryKeySelective(PersonCart record);

    //修改购物车
    /*@Update("update t_personcart set personid = #{personid},personname = #{personname},goodsid = #{goodsid},goodsname = #{goodsname},retailprice = #{retailprice}," +
            "marketprice = #{marketprice},goodsimage = #{goodsimage},goodsnum = #{goodsnum},goodsdeliverytime = #{goodsdeliverytime},createtime = #{createtime}, " +
            "catsid = #{catsid},catsname = #{catsname},goodsgrad = #{goodsgrad} where id = #{id}")*/
    int updateById(PersonCart personCart);
}