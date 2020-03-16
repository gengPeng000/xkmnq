package com.gpzx.xkmnq.utils;

import com.gpzx.xkmnq.dao.MapperRespostory;
import com.gpzx.xkmnq.domain.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName QinmiduValue
 * @Author admin
 * @Date 2020/3/15 18:54
 * @Version 1.0
 */
public class QinmiduValue {

@Autowired
private MapperRespostory respostory;

    public  String getValue(int level) {
        String value="";
       if(level<4){
            value=respostory.findByLevel(0).getValue();
        }
        if(level>3&&level<8){
            value=respostory.findByLevel(4).getValue();
        }
        if(level>7&&level<12){
            value=respostory.findByLevel(8).getValue();
        }
        if(level>11&&level<16){
            value=respostory.findByLevel(12).getValue();
        }
        if(level>15&&level<20){
            value=respostory.findByLevel(16).getValue();
        }
        if(level>19&&level<24){
            value=respostory.findByLevel(20).getValue();
        }
        if(level>23&&level<28){
            value=respostory.findByLevel(24).getValue();
        }
        if(level>27&&level<32){
            value=respostory.findByLevel(28).getValue();
        }
        if(level>31&&level<36){
            value=respostory.findByLevel(32).getValue();
        }
        if(level>35&&level<40){
            value=respostory.findByLevel(36).getValue();
        }
        return value;
       }
}