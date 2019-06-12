package com.gmm.drp.vo;

import com.gmm.drp.entity.PersonAddress;

import java.math.BigDecimal;
import java.util.List;

/**
 * 确认单信息封装
 * Created by macro on 2018/8/30.
 */
public class ConfirmOrderResultVo {

    //用户收货地址列表
    private List<PersonAddress> personAddresses;

    //计算的金额
    private CalcAmount calcAmount;



    public List<PersonAddress> getPersonAddresses() {
        return personAddresses;
    }

    public void setPersonAddresses(List<PersonAddress> personAddresses) {
        this.personAddresses = personAddresses;
    }


    public CalcAmount getCalcAmount() {
        return calcAmount;
    }

    public void setCalcAmount(CalcAmount calcAmount) {
        this.calcAmount = calcAmount;
    }


    public static class CalcAmount{
        //订单商品总金额
        private BigDecimal totalAmount;

        //应付金额
        private BigDecimal payAmount;

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }


        public BigDecimal getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(BigDecimal payAmount) {
            this.payAmount = payAmount;
        }
    }
}
