package com.gpzx.xkmnq.dao;

import com.gpzx.xkmnq.domain.Xiake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XiakeRepostory extends JpaRepository<Xiake,Integer> {
    Xiake findByNameAndLevel(String name,int level);
    Xiake findByNameAndLevelAndQinmidu(String name,int level,int qinmidu);
}
