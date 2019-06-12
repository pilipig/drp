package com.gmm.drp.dao;

import com.gmm.drp.vo.Deliverytime;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeliverytimeDao {
    @Select("SELECT * FROM t_deliverytime")
    @ResultType(Deliverytime.class)
    List<Deliverytime> findAll();

}
