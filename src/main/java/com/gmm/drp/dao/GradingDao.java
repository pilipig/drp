package com.gmm.drp.dao;

import com.gmm.drp.entity.Grading;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradingDao {
    @Select("SELECT * FROM t_qualitygrading")
    @ResultType(Grading.class)
    List<Grading> findAll();
}
