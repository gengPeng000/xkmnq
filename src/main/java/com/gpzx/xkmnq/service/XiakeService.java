package com.gpzx.xkmnq.service;

import com.gpzx.xkmnq.domain.Xiake;

public interface XiakeService {
    Xiake  findByNameAndLevel(String name,Integer level);
}
