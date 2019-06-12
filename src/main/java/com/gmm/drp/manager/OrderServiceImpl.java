package com.gmm.drp.manager;

import com.gmm.drp.dao.OrderDao;
import com.gmm.drp.entity.Order;
import com.gmm.drp.entity.OrderItem;
import com.gmm.drp.entity.Person;
import com.gmm.drp.entity.PersonCart;
import com.gmm.drp.service.OrderService;
import com.gmm.drp.service.PersonService;
import com.gmm.drp.utils.RRException;
import com.gmm.drp.utils.ResultUtil;
import com.gmm.drp.vo.ConfirmOrderResultVo;
import com.gmm.drp.vo.OrderDetailVo;
import com.gmm.drp.vo.PageVo;
import com.gmm.drp.vo.R;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PersonService personService;
    //@Value()
    private String REDIS_KEY_PREFIX_ORDER_ID;
    @Override
    public R deleteOrder(int id) {
        if (orderDao.deleteByID(id)>0){
            return ResultUtil.setOK("删除成功");
        }else {
            return ResultUtil.setERROR("删除失败");
        }
    }

    //分页
    @Override
    public PageVo<Order> queryByPage(int page, int limit) {
        PageVo<Order> pageVo = new PageVo<>();
        pageVo.setData(orderDao.selectByPage((page-1)*limit,limit));
        pageVo.setCode(0);
        pageVo.setCount(orderDao.selectCount().intValue());
        return pageVo;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public OrderDetailVo getDetail(int id) {
        return orderDao.getDetail(id);
    }

    @Override
    public Order queryObject(Integer id) {
        return orderDao.queryByOrderId(id);
    }


    //收货
    @Override
    public int confirm(Integer id) {
        Order order = queryObject(id);
        Integer orderstatus = order.getOrderstatus();//发货状态
        if (0 == orderstatus){
            throw new RRException("此订单未付款，不能确认收货！");
        }
        if (1 == orderstatus){
            throw new RRException("此订单未发货，不能确认收货！");
        }
       order.setOrderstatus(3);
        return orderDao.updateStatus(order);
    }



    //发货
    @Override
    public int sendGoods(Order order) {
        Integer orderstatus = order.getOrderstatus();
        /*try {
            if (0 == orderstatus){
                throw new Exception("此订单未付款！");
            }
        }catch (Exception e){
            e.printStackTrace();

        }*/
       /* if (1 != orderstatus){
            try {
                throw new Exception("此订单未付款！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        order.setOrderstatus(2);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~"+order.getOrderstatus());
        return orderDao.updateStatus(order);
    }


    //计算总价
    private BigDecimal totalPrice(List<OrderItem> orderItemList){
      BigDecimal total = new BigDecimal("0");
      for (OrderItem item:orderItemList){
          total = total.add(item.getGoodsprice().multiply(new BigDecimal(item.getGoodsnum())));
      }
        return total;
    }

    public ConfirmOrderResultVo generateConfirmOrder(){
        List<OrderItem> orderItems = new ArrayList<>();

        Person person = new Person();

        Order order = new Order();
        order.setOrderprice(totalPrice(orderItems));
        return null;
    }





    //生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
    private String generateOrderSn(Order order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = orderDao.increment(key, 1);
        sb.append(date);
        sb.append(String.format("%02d",order.getPaytype()));
        String incrementStr = increment.toString();
        if(incrementStr.length()<=6){
            sb.append(String.format("%06d",increment));
        }else{
            sb.append(incrementStr);
        }
        return sb.toString();
    }
}
