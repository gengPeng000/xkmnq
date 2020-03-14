package com.gpzx.xkmnq.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Xiake
 * @Author admin
 * @Date 2020/3/14 14:09
 * @Version 1.0
 */
@Entity
public class Xiake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int level;

    private int qixue;

    private int gongji;

    private int baoji;

    private int gedang;

    private int kangbao;

    private int fangyu;

    private int mingzhong;

    private int shanbi;

    private int pofang;

    private String jiachengxiake;

    @Override
    public String toString() {
        return "Xiake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", qixue=" + qixue +
                ", gongji=" + gongji +
                ", baoji=" + baoji +
                ", gedang=" + gedang +
                ", kangbao=" + kangbao +
                ", fangyu=" + fangyu +
                ", mingzhong=" + mingzhong +
                ", shanbi=" + shanbi +
                ", pofang=" + pofang +
                ", jiachengxiake='" + jiachengxiake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getJiachengxiake() {
        return jiachengxiake;
    }

    public void setJiachengxiake(String jiachengxiake) {
        this.jiachengxiake = jiachengxiake;
    }
}
