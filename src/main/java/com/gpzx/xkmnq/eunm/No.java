package com.gpzx.xkmnq.eunm;

public enum No {
    YI(1,0.3),
    ER(2,0.3),
    SAN(3,0.2),
    SI(4,0.2),
    WU(5,0.1),
    LIU(6,0.1)
    ;

    private int number;

    private double jiacheng;

    No(int number, double jiacheng) {
        this.number = number;
        this.jiacheng = jiacheng;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getJiacheng() {
        return jiacheng;
    }

    public void setJiacheng(double jiacheng) {
        this.jiacheng = jiacheng;
    }
}
