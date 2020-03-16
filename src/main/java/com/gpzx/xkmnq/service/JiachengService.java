package com.gpzx.xkmnq.service;

import com.gpzx.xkmnq.domain.Jiacheng;

import java.util.List;

public interface JiachengService {
    Jiacheng findJiachengshuzhi(String zhuxiake, String jibanxiake, Integer qinmidu);
    List<Jiacheng> findJiban(String name);

}
