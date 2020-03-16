package com.gpzx.xkmnq.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ClassName Mapper
 * @Author admin
 * @Date 2020/3/15 19:10
 * @Version 1.0
 */
@Entity
public class Mapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mappingid;

    private int level;

    private String value;

    @Override
    public String toString() {
        return "Mapper{" +
                "mappingid=" + mappingid +
                ", level=" + level +
                ", value='" + value + '\'' +
                '}';
    }

    public int getMappingid() {
        return mappingid;
    }

    public void setMappingid(int mappingid) {
        this.mappingid = mappingid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
