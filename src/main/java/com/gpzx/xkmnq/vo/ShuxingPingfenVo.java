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

    private String jiacheng;

    private List<Map<String,Double>> jiachengMaps;

    public List<Map<String, Double>> getJiachengMaps() {
        return jiachengMaps;
    }

    public void setJiachengMaps(List<Map<String, Double>> jiachengMaps) {
        this.jiachengMaps = jiachengMaps;
    }

    private int pingfen;

    @Override
    public String toString() {
        return "ShuxingPingfenVo{" +
                "shuXingVo=" + shuXingVo +
                ", jiacheng='" + jiacheng + '\'' +
                ", pingfen=" + pingfen +
                '}';
    }

    public ShuXingVo getShuXingVo() {
        return shuXingVo;
    }

    public void setShuXingVo(ShuXingVo shuXingVo) {
        this.shuXingVo = shuXingVo;
    }

    public String getJiacheng() {
        return jiacheng;
    }

    public void setJiacheng(String jiacheng) {
        this.jiacheng = jiacheng;
    }

    public int getPingfen() {
        return pingfen;
    }

    public void setPingfen(int pingfen) {
        this.pingfen = pingfen;
    }
}
