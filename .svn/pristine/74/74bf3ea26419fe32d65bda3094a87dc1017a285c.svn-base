package com.gmm.drp.manager;

import com.gmm.drp.dao.DeliverytimeDao;
import com.gmm.drp.service.DeliverytimeService;
import com.gmm.drp.vo.Deliverytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeliverytimeServiceImpl
 * @Description
 * @Author baohaipeng
 * @Date
 * @Version 1.0
 */
@Service
public class DeliverytimeServiceImpl implements DeliverytimeService {
    @Autowired
    private DeliverytimeDao deliverytimeDao;
    @Override
    public List<Deliverytime> showTime() {
        return deliverytimeDao.findAll();
    }

}
