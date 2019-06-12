package com.gmm.drp.manager;

import com.gmm.drp.dao.PersonDao;
import com.gmm.drp.entity.Person;
import com.gmm.drp.service.PersonService;
import com.gmm.drp.utils.PassUtil;
import com.gmm.drp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:商户一览
     */
   /* @Override
    public PageVo<Person>  personList() {
        PageVo<Person> pageVo = new PageVo<Person>();
        pageVo.setData(personDao.personList());
        pageVo.setMsg("");
        pageVo.setCode(0);
        pageVo.setCount(personDao.selectCount().intValue());
        return pageVo;
    }*/

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:分页
     */
    @Override
    public PageVo<Person> selectByPage(int page, int limit) {
        PageVo<Person> pageVo = new PageVo<Person>();
        pageVo.setData(personDao.selectByPage((page - 1) * limit, limit));
        pageVo.setCode(0);
        pageVo.setCount(personDao.selectCount().intValue());
        return pageVo;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户详情
     */
    @Override
    public List<Person> personDetails(int id) {
        return personDao.personDetails(id);
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户喜欢
     */
    @Override
    public List<Person> personLove(int pid) {
        return personDao.personLove(pid);
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户浏览记录
     */
    @Override
    public List<Person> personRcord(int pid) {
        return personDao.personRcord(pid);
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户登录日志
     */
    @Override
    public List<Person> personLoginLog(int pid) {
        return personDao.personLoginLog(pid);
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:商户搜索
     */
    @Override
    public PageVo<Person> personsearch(String opValue, String keyword, String splitDateStart, String splitDateEnd, int page, int limit) {
        PageVo<Person> pageVo = new PageVo<Person>();
        if (keyword == "" & splitDateStart == "" & splitDateEnd == "") {
            pageVo = selectByPage(page, limit);
        } else {
            pageVo.setData(personDao.personsearch(opValue, keyword, splitDateStart, splitDateEnd, (page - 1) * limit, limit));
            pageVo.setCode(0);
            pageVo.setCount(personDao.personsearchtCount(opValue, keyword, splitDateStart, splitDateEnd).intValue());
        }
        return pageVo;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户喜欢的商品搜索
     */
    @Override
    public PageVo<Person> loveSearch(String loveKeyword, String splitDateLoveTimeStart, String splitDateLoveTimeEnd, int pid, int page, int limit) {
        PageVo<Person> pageVo = new PageVo<Person>();
        pageVo.setData(personDao.loveSearch(loveKeyword, splitDateLoveTimeStart, splitDateLoveTimeEnd, pid, (page - 1) * limit, limit));
        pageVo.setCode(0);
        pageVo.setCount(personDao.loveSearchCount(loveKeyword, splitDateLoveTimeStart, splitDateLoveTimeEnd, pid).intValue());
        return pageVo;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户浏览的商品搜索
     */
    @Override
    public PageVo<Person> recordSearch(String recordKeyword, String startRecordTime, String endRecordTime, int pid, int page, int limit) {
        PageVo<Person> pageVo = new PageVo<Person>();
        pageVo.setData(personDao.recordSearch(recordKeyword, startRecordTime, endRecordTime, pid, (page - 1) * limit, limit));
        pageVo.setCode(0);
        pageVo.setCount(personDao.recordSearchCount(recordKeyword, startRecordTime, endRecordTime, pid).intValue());
        return pageVo;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:用户登录日志搜索
     */
    @Override
    public PageVo<Person> logSearch(String logKeyword, String startLogTime, String endLogTime, int pid, int page, int limit) {
        PageVo<Person> pageVo = new PageVo<Person>();
        pageVo.setData(personDao.logSearch(logKeyword, startLogTime, endLogTime, pid, (page - 1) * limit, limit));
        pageVo.setCode(0);
        pageVo.setCount(personDao.logSearchCount(logKeyword, startLogTime, endLogTime, pid).intValue());
        return pageVo;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:注册接口
     */
    @Override
    public String personRegister(Person person) {
        person.setPassword(PassUtil.md5(person.getPassword()));
        personDao.personRegister(person);
        int verificationCodeInt = (int) ((Math.random() * 9 + 1) * 100000);
        String verificationCode = String.valueOf(verificationCodeInt);
        return verificationCode;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:登录接口
     */
    @Override
    public String personLogin(Person person) {
        int i = personDao.personLogin(person);
        String msg;
        if (i > 0) {
            msg="OK";
        }else{
            msg="错误信息......";
        }
        return msg;
    }
}
