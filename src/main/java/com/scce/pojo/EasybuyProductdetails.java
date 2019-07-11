package com.scce.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EasybuyProductdetails {
    private  Integer id;
    private  String  realname;
    private  String phone;
    private  String address;
    private  String orderId;
    private  String price;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date creationdate;
    private  String productdetails;
    private  Integer productnumber;
    private  String freight;
    private  String totalprice;
    private  String status;

    private String statusStr;


    private EasybuyProduct easybuyProduct;

    public EasybuyProduct getEasybuyProduct() {
        return easybuyProduct;
    }

    public void setEasybuyProduct(EasybuyProduct easybuyProduct) {
        this.easybuyProduct = easybuyProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Integer getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(Integer productnumber) {
        this.productnumber = productnumber;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
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

    public String getStatusStr() {
            if ("1".equals(status)){
                statusStr="未支付";
             }else if ("0".equals(status)){
                statusStr="支付";
            }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "EasybuyProductdetails{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderId='" + orderId + '\'' +
                ", price='" + price + '\'' +
                ", creationdate=" + creationdate +
                ", productdetails='" + productdetails + '\'' +
                ", productnumber=" + productnumber +
                ", freight='" + freight + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", status='" + status + '\'' +
                ", statusStr='" + statusStr + '\'' +
                ", easybuyProduct=" + easybuyProduct +
                '}';
    }
}
