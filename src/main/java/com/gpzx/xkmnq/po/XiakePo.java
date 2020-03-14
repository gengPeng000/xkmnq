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

    @Override
    public String toString() {
        return "XiakePo{" +
                "number=" + number +
                ", level=" + level +
                ", name='" + name + '\'' +
                '}';
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
