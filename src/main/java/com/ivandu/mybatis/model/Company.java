package com.ivandu.mybatis.model;

public class Company {
    private Integer id;
    private String name;
    private CEO ceo;
    public Company() {

    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
}
