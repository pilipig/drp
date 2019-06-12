package com.gmm.drp.manager;

import com.gmm.drp.dao.GradingDao;
import com.gmm.drp.entity.Grading;
import com.gmm.drp.service.GradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GradingServiceImpl
 * @Description 品质分级
 * @Author baohaipeng
 * @Date 2019-04-15
 * @Version 1.0
 */
@Service
public class GradingServiceImpl implements GradingService {
    @Autowired
    private GradingDao gradingDao;
    @Override
    public List<Grading> showGrading() {
        return gradingDao.findAll();
    }
}
