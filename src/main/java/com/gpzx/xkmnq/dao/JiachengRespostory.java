package com.gpzx.xkmnq.dao;

import com.gpzx.xkmnq.domain.Jiacheng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface JiachengRespostory extends JpaRepository<Jiacheng,Integer> {

    //根据主侠客，羁绊侠客，亲密度等级查询加成数值
    Jiacheng findByZhuxiakeAndJibanxiakeAndQinmidu(String zhuxiake,String jibanxiake,Integer qinmidu);


    //根据主侠客查询羁绊侠客

    List<Jiacheng> findByZhuxiake(String zhuxiake);

    List<Jiacheng> findByZhuxiakeAndQinmidu(String zhuxiake,Integer qinmidu);
}
