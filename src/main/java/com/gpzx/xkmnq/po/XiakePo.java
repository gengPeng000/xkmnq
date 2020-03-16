package com.gpzx.xkmnq.po;

/**
 * @ClassName XiakePo
 * @Author admin
 * @Date 2020/3/14 16:05
 * @Version 1.0
 * 前台传进来的侠客对象数组
 */
public class XiakePo {
    //几号位
    private int  number;
    //等级
    private int level;
    //侠客名字
    private String name;
    //亲密度
    private int qinmidu;

//    public XiakePo() {
//    }

    public XiakePo(int number, int level, String name, int qinmidu) {
        this.number = number;
        this.level = level;
        this.name = name;
        this.qinmidu = qinmidu;
    }

    @Override
    public String toString() {
        return "XiakePo{" +
                "number=" + number +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", qinmidu=" + qinmidu +
                '}';
    }

    public int getQinmidu() {
        return qinmidu;
    }

    public void setQinmidu(int qinmidu) {
        this.qinmidu = qinmidu;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
