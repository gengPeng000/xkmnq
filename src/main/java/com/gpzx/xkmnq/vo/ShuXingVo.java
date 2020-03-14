package com.gpzx.xkmnq.vo;

/**
 * @ClassName ShuXingVo
 * @Author admin
 * @Date 2020/3/14 15:51
 * @Version 1.0
 * 返回给前台的属性VO
 */
public class ShuXingVo {

    private int qixue;

    private int gongji;

    private int baoji;

    private int gedang;

    private int kangbao;

    private int fangyu;

    private int mingzhong;

    private int shanbi;

    private int pofang;

    @Override
    public String toString() {
        return "ShuXingVo{" +
                "qixue=" + qixue +
                ", gongji=" + gongji +
                ", baoji=" + baoji +
                ", gedang=" + gedang +
                ", kangbao=" + kangbao +
                ", fangyu=" + fangyu +
                ", mingzhong=" + mingzhong +
                ", shanbi=" + shanbi +
                ", pofang=" + pofang +
                '}';
    }

    public int getQixue() {
        return qixue;
    }

    public void setQixue(int qixue) {
        this.qixue = qixue;
    }

    public int getGongji() {
        return gongji;
    }

    public void setGongji(int gongji) {
        this.gongji = gongji;
    }

    public int getBaoji() {
        return baoji;
    }

    public void setBaoji(int baoji) {
        this.baoji = baoji;
    }

    public int getGedang() {
        return gedang;
    }

    public void setGedang(int gedang) {
        this.gedang = gedang;
    }

    public int getKangbao() {
        return kangbao;
    }

    public void setKangbao(int kangbao) {
        this.kangbao = kangbao;
    }

    public int getFangyu() {
        return fangyu;
    }

    public void setFangyu(int fangyu) {
        this.fangyu = fangyu;
    }

    public int getMingzhong() {
        return mingzhong;
    }

    public void setMingzhong(int mingzhong) {
        this.mingzhong = mingzhong;
    }

    public int getShanbi() {
        return shanbi;
    }

    public void setShanbi(int shanbi) {
        this.shanbi = shanbi;
    }

    public int getPofang() {
        return pofang;
    }

    public void setPofang(int pofang) {
        this.pofang = pofang;
    }
}
