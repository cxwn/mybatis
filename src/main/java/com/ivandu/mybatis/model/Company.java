package com.ivandu.mybatis.model;

public class Company {
    private Integer id;
    private String name;
    private CEO ceo;

    public Company(){}

    public Company(Integer id, String name, CEO ceo) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }
}
