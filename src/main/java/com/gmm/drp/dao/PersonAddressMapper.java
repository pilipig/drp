package com.gmm.drp.dao;

import com.gmm.drp.entity.PersonAddress;

public interface PersonAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonAddress record);

    int insertSelective(PersonAddress record);

    PersonAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonAddress record);

    int updateByPrimaryKey(PersonAddress record);
}