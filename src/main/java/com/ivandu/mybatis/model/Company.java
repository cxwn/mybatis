package com.ivandu.mybatis.model;

import java.util.List;

public class Company {
    private Integer id;
    private String name;
    private List<Staff> staffs;

    public Company(){}

    public Company(Integer id, String name, List<Staff> staffs) {
        this.id = id;
        this.name = name;
        this.staffs = staffs;
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

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + id +
                ", name='" + name + '\'' +
                ", staffs=" + staffs +
                '}';
    }
}
