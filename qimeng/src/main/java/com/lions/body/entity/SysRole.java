package com.lions.body.entity;

import java.io.Serializable;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 12:09
 */
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

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
}

