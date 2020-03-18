package com.gpzx.xkmnq.vo;

import com.gpzx.xkmnq.domain.Jiacheng;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ShuxingPingfenVo
 * @Author admin
 * @Date 2020/3/14 15:55
 * @Version 1.0
 */
public class ShuxingPingfenVo {

    private ShuXingVo shuXingVo;


    private Map<String,Double> jiachengMap;

    public Map<String, Double> getJiachengMaps() {
        return jiachengMap;
    }

    public void setJiachengMaps(Map<String, Double> jiachengMap) {
        this.jiachengMap = jiachengMap;
    }

    private int pingfen;

    @Override
    public String toString() {
        return "ShuxingPingfenVo{" +
                "shuXingVo=" + shuXingVo +
                ", pingfen=" + pingfen +
                '}';
    }

    public ShuXingVo getShuXingVo() {
        return shuXingVo;
    }

    public void setShuXingVo(ShuXingVo shuXingVo) {
        this.shuXingVo = shuXingVo;
    }


    public int getPingfen() {
        return pingfen;
    }

    public void setPingfen(int pingfen) {
        this.pingfen = pingfen;
    }
}
