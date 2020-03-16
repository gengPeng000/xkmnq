package com.gpzx.xkmnq.service.impl;

import com.gpzx.xkmnq.dao.JiachengRespostory;
import com.gpzx.xkmnq.domain.Jiacheng;
import com.gpzx.xkmnq.domain.Xiake;
import com.gpzx.xkmnq.service.JiachengService;
import com.gpzx.xkmnq.service.XiakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @ClassName JiachengServiceImpl
 * @Author admin
 * @Date 2020/3/15 17:24
 * @Version 1.0
 */
@Service
public class JiachengServiceImpl implements JiachengService {

@Autowired
private JiachengRespostory respostory;

    @Override
    public Jiacheng findJiachengshuzhi(String zhuxiake, String jibanxiake, Integer qinmidu) {
        return respostory.findByZhuxiakeAndJibanxiakeAndQinmidu(zhuxiake,jibanxiake,qinmidu);
    }

    @Override
    public List<Jiacheng> findJiban(String name) {
        return respostory.findByZhuxiake(name);
    }

}
