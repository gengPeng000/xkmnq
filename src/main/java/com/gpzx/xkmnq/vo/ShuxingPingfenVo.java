package com.gpzx.xkmnq.vo;

/**
 * @ClassName ShuxingPingfenVo
 * @Author admin
 * @Date 2020/3/14 15:55
 * @Version 1.0
 */
public class ShuxingPingfenVo {

    private ShuXingVo shuXingVo;

    private String jiacheng;

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
