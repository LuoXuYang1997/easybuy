package com.scce.pojo;

public class EasybuyRole {
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
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "EasybuyRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}