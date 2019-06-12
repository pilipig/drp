package com.gmm.drp.dao;

import com.gmm.drp.entity.UserLog;
import org.apache.ibatis.annotations.Insert;

public interface UserLogDao {

    @Insert("insert into t_userlog (userId, username, createdate, pcip, operation)values (#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, #{pcip,jdbcType=VARCHAR}, #{operation,jdbcType=VARCHAR})")
    int insert(UserLog userLog);

}