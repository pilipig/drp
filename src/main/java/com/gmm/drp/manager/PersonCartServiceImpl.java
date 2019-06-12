package com.gmm.drp.manager;
import com.gmm.drp.dao.PersonCartDao;
import com.gmm.drp.entity.Person;
import com.gmm.drp.entity.PersonCart;
import com.gmm.drp.service.PersonCartService;
import com.gmm.drp.vo.PersonCartExample;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class PersonCartServiceImpl implements PersonCartService {

    @Autowired
    private PersonCartDao personCartDao;

    @Override
    public int add(PersonCart personCart) {

        int count;
       //获取personid
        Person person = (Person) SecurityUtils.getSubject().getSession().getAttribute("user");
        personCart.setPersonid(person.getId());
        personCart.setPersonname(person.getPersonname());
        PersonCart pc = getCart(personCart);
        if (pc == null){
            personCart.setCreatetime(new Date());
            count = personCartDao.insert(personCart);
        }else {
           pc.setGoodsnum(pc.getGoodsnum()+ personCart.getGoodsnum());
           count = personCartDao.updateById(personCart);
        }

        return 0;
    }

    private PersonCart getCart(PersonCart personCart){
        PersonCartExample example = new PersonCartExample();
       PersonCartExample.Criteria criteria = example.createCriteria().andPersonIdEqualTo(personCart.getPersonid())
               .andPersonIdEqualTo(personCart.getGoodsid()).andGoodsIdEqualTo(0);

       if (!StringUtils.isEmpty(personCart.getGoodsgrad())){
           criteria.andGoodsGradEqualTo(personCart.getGoodsgrad());
       }
        List<PersonCart> list = personCartDao.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }


    @Override
    public List<PersonCart> listCart(int personId) {
        return null;
    }

    @Override
    public int updateNum(int id, int personId, int goodsnum) {
        return 0;
    }

    @Override
    public int deleteCart(int id, List<Long> ids) {
        return 0;
    }

    @Override
    public int cleat(int personId) {
        return 0;
    }






}
