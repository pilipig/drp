package com.gmm.drp.vo;

import com.gmm.drp.entity.Order;
import com.gmm.drp.entity.OrderHistory;
import com.gmm.drp.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by macro on 2018/10/11.
 */
public class OrderDetailVo extends Order {
    @Getter
    @Setter
    private List<OrderItem> orderItemList;
    @Getter
    @Setter
    private List<OrderHistory> historyList;
}
