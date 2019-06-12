package com.gmm.drp.controller;

import com.gmm.drp.entity.Person;
import com.gmm.drp.service.PersonService;
import com.gmm.drp.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户一览
     * @return
     */
   /* @GetMapping("/personList.do")
    public PageVo<Person>  personList(){
        return personService.personList();
    }*/

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @page：当前页
     *  @limit：每页显示几条数据
     *  @Depict:分页
     */
    @RequestMapping("paging.do")
    public PageVo<Person> list(int page,int limit){
        return personService.selectByPage(page,limit);
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户详情
     */
    @RequestMapping("personDetails.do")
    public List<Person> personDetails(Integer id){

        return personService.personDetails(id);
    }
    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户喜欢
     */
    @RequestMapping("personLove.do")
    public List<Person> personLove(int pid) {
        List<Person> personLove = personService.personLove(pid);
        return personLove;
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户浏览记录
     */
    @RequestMapping("personRcord.do")
    public List<Person> personRcord(int pid) {
        return personService.personRcord(pid);
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户登录日志
     */
    @RequestMapping("personLoginLog.do")
    public List<Person> personLoginLog(int pid) {
        return personService.personLoginLog(pid);
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户搜索
     */
    @RequestMapping("personsearch.do")
    public PageVo<Person> personsearch(String opValue,String id,String splitDateStart,String splitDateEnd,int page, int limit) {
        return personService.personsearch(opValue,id,splitDateStart,splitDateEnd,page,limit);
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:用户喜欢的商品搜索
     */
    @RequestMapping("loveSearch.do")
    public PageVo<Person> loveSearch(String loveKeyword,String splitDateLoveTimeStart,String splitDateLoveTimeEnd,int pid,int page, int limit) {
        return personService.loveSearch(loveKeyword,splitDateLoveTimeStart,splitDateLoveTimeEnd,pid,page,limit);
    }
    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索
     */
    @RequestMapping("recordSearch.do")
    public PageVo<Person> recordSearch(String recordKeyword, String startRecordTime, String endRecordTime, int pid, int page, int limit) {
        return personService.recordSearch(recordKeyword,startRecordTime,endRecordTime,pid,page,limit);
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户登录日志搜索
     */
    @RequestMapping("logSearch.do")
    public PageVo<Person> logSearch(String logKeyword, String startLogTime, String endLogTime, int pid, int page, int limit) {
        return personService.logSearch(logKeyword,startLogTime,endLogTime,pid,page,limit);
    }

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:注册接口
     */
    /*@RequestMapping("personRegister.do")
    public String personRegister(@RequestBody(required = false) Person person) {
        String verificationCode = personService.personRegister(person);
        return verificationCode;
    }*/
}

