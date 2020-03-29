package com.gpzx.xkmnq.po;

import java.util.List;

/**
 * @ClassName XiakeDto
 * @Author admin
 * @Date 2020/3/23 22:27
 * @Version 1.0
 */
public class XiakeDto {
    //侠客名字
    private String name;
    //亲密度
    private int qinmidu;
    //羁绊侠客
    private List<String> jibanList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQinmidu() {
        return qinmidu;
    }

    public void setQinmidu(int qinmidu) {
        this.qinmidu = qinmidu;
    }

    public List<String> getJibanList() {
        return jibanList;
    }

    public void setJibanList(List<String> jibanList) {
        this.jibanList = jibanList;
    }
}
