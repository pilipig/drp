package com.gmm.drp.service;

import com.gmm.drp.entity.Person;
import com.gmm.drp.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonService {

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户一览
     */
    /*PageVo<Person>  personList();*/
    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:分页
     */
    PageVo<Person> selectByPage(int page, int limit);
    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户详情
     */
    List<Person> personDetails(int id);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户喜欢
     */
    List<Person> personLove(int pid);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户浏览记录
     */
    List<Person> personRcord(int pid);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户登录日志
     */
    List<Person> personLoginLog(int pid);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户搜索
     */
    PageVo<Person> personsearch(String opValue,String keyword,String splitDateStart,String splitDateEnd,int page, int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户喜欢的商品搜索
     */
    PageVo<Person>  loveSearch(String loveKeyword, String splitDateLoveTimeStart, String splitDateLoveTimeEnd,int pid,int page,int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索
     */
    PageVo<Person>  recordSearch(String recordKeyword, String startRecordTime, String endRecordTime,int pid,int page, int limit);

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户登录日志搜索
     */
    PageVo<Person>  logSearch(String logKeyword,String startLogTime,String endLogTime,int pid,int page,int limit);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:注册接口
     */
    String personRegister(Person person);

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:登录接口
     */
    String personLogin(Person person);
}
