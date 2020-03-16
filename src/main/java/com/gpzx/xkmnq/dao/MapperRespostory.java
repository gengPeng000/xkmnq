package com.gpzx.xkmnq.dao;

import com.gpzx.xkmnq.domain.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapperRespostory extends JpaRepository<Mapper,Integer> {
    //根据亲密度level查询值
    Mapper findByLevel(Integer level);
}
