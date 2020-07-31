package com.domain;
/*
 * Created by Nolva on 2020/6/19.
 */

import java.io.Serializable;

/**
 * 职位表
 */
public class Position implements Serializable {

//    主键
    private Integer id;
//    职位名称
    private String positionName;
//    职位详情
    private String positionDesc;

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
