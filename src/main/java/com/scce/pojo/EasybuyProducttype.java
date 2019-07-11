package com.scce.pojo;

public class EasybuyProducttype {
    private Integer id;

    private Integer producttypeid;

    private String producttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype == null ? null : producttype.trim();
    }

    @Override
    public String toString() {
        return "EasybuyProducttypeDao{" +
                "id=" + id +
                ", producttypeid=" + producttypeid +
                ", producttype='" + producttype + '\'' +
                '}';
    }
}