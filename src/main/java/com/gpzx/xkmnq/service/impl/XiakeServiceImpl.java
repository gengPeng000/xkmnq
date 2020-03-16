package com.gpzx.xkmnq.service.impl;

import com.gpzx.xkmnq.dao.XiakeRepostory;
import com.gpzx.xkmnq.domain.Xiake;
import com.gpzx.xkmnq.service.XiakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName XiakeServiceImpl
 * @Author admin
 * @Date 2020/3/14 17:05
 * @Version 1.0
 */
@Service
public class XiakeServiceImpl implements XiakeService {
    @Autowired
    private XiakeRepostory repostory;
    @Override
    public Xiake findByNameAndLevel(String name, Integer level) {

        return repostory.findByNameAndLevel(name,level);
    }

    @Override
    public Xiake findByNameAndLevelAndQinmidu(String name, Integer level, int qinmidu) {
        return repostory.findByNameAndLevelAndQinmidu(name,level,qinmidu);
    }


}
