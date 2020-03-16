package com.gpzx.xkmnq.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Jiacheng
 * @Author admin
 * @Date 2020/3/15 16:16
 * @Version 1.0
 * 羁绊加成
 */
@Entity
public class Jiacheng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jibanid;
    //主侠客
    private String zhuxiake;
    //羁绊侠客
    private String jibanxiake;
    //加成属性
    private String jiachengshuxing;
    //加成数值
    private String jiachengshuzhi;
    //亲密度
    private Integer qinmidu;

    @Override
    public String toString() {
        return "Jiacheng{" +
                "jibanid=" + jibanid +
                ", zhuxiake='" + zhuxiake + '\'' +
                ", jibanxiake='" + jibanxiake + '\'' +
                ", jiachengshuxing='" + jiachengshuxing + '\'' +
                ", jiachengshuzhi='" + jiachengshuzhi + '\'' +
                ", qinmidu=" + qinmidu +
                '}';
    }

    public Integer getJibanid() {
        return jibanid;
    }

    public void setJibanid(Integer jibanid) {
        this.jibanid = jibanid;
    }

    public String getZhuxiake() {
        return zhuxiake;
    }

    public void setZhuxiake(String zhuxiake) {
        this.zhuxiake = zhuxiake;
    }

    public String getJibanxiake() {
        return jibanxiake;
    }

    public void setJibanxiake(String jibanxiake) {
        this.jibanxiake = jibanxiake;
    }

    public String getJiachengshuxing() {
        return jiachengshuxing;
    }

    public void setJiachengshuxing(String jiachengshuxing) {
        this.jiachengshuxing = jiachengshuxing;
    }

    public String getJiachengshuzhi() {
        return jiachengshuzhi;
    }

    public void setJiachengshuzhi(String jiachengshuzhi) {
        this.jiachengshuzhi = jiachengshuzhi;
    }

    public Integer getQinmidu() {
        return qinmidu;
    }

    public void setQinmidu(Integer qinmidu) {
        this.qinmidu = qinmidu;
    }
}
