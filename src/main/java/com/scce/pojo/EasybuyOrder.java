package com.scce.pojo;

import java.util.Date;

public class EasybuyOrder {



      private Integer id;
      private  String orderid;
      private  Date  creationdate;
      private  String productdetails;
      private  String  price;
      private  Integer productnumber;
      private  String totalprice;
      private  String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getProductdetails() {
        return productdetails;
    }

    public void setProductdetails(String productdetails) {
        this.productdetails = productdetails;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(Integer productnumber) {
        this.productnumber = productnumber;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EasybuyOrderDao{" +
                "id=" + id +
                ", orderid='" + orderid + '\'' +
                ", creationdate=" + creationdate +
                ", productdetails='" + productdetails + '\'' +
                ", price='" + price + '\'' +
                ", productnumber=" + productnumber +
                ", totalprice='" + totalprice + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
