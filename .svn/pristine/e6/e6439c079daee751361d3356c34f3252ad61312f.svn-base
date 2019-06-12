package com.gmm.drp.appcontroller;

import com.gmm.drp.entity.Person;
import com.gmm.drp.service.PersonService;
import com.gmm.drp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppPersonController {
    @Autowired
    private PersonService personService;
    /**
     *  @Author:fuyinggang
     *  @Date:
     *  @Depict:注册接口
     */
    @RequestMapping("personRegister.do")
    public String personRegister(@RequestBody(required = false) Person person) {
        String verificationCode = personService.personRegister(person);
        return verificationCode;
    }

    /**
     * @Author:fuyinggang
     * @Date:
     * @Depict:登录接口
     */
    @RequestMapping("personLogin.do")
    public String personLogin(@RequestBody(required = false) Person person) {
        String msg = personService.personLogin(person);
        return msg;
    }
}

