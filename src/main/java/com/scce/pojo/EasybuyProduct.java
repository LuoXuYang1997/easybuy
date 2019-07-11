package com.scce.pojo;

import java.util.Date;

public class EasybuyProduct {
    private Integer id;

    private Integer productid;

    private Integer producttypeid;

    private String productname;

    private String productdetails;

    private String price;

    private Integer stocknumber;

    private Date warehousingdate;

    private String filename;

    private String handlers;
    private int freight;

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

    @Override
    public String toString() {
        return "EasybuyProduct{" +
                "id=" + id +
                ", productid=" + productid +
                ", producttypeid=" + producttypeid +
                ", productname='" + productname + '\'' +
                ", productdetails='" + productdetails + '\'' +
                ", price='" + price + '\'' +
                ", stocknumber=" + stocknumber +
                ", warehousingdate=" + warehousingdate +
                ", filename='" + filename + '\'' +
                ", handlers='" + handlers + '\'' +
                ", freight=" + freight +
                '}';
    }


    public EasybuyProduct(Integer id, Integer productid, Integer producttypeid, String productname, String productdetails, String price, Integer stocknumber, Date warehousingdate, String filename, String handlers) {
        this.id = id;
        this.productid = productid;
        this.producttypeid = producttypeid;
        this.productname = productname;
        this.productdetails = productdetails;
        this.price = price;
        this.stocknumber = stocknumber;
        this.warehousingdate = warehousingdate;
        this.filename = filename;
        this.handlers = handlers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductdetails() {
        return productdetails;
    }

    public void setProductdetails(String productdetails) {
        this.productdetails = productdetails == null ? null : productdetails.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getStocknumber() {
        return stocknumber;
    }

    public void setStocknumber(Integer stocknumber) {
        this.stocknumber = stocknumber;
    }

    public Date getWarehousingdate() {
        return warehousingdate;
    }

    public void setWarehousingdate(Date warehousingdate) {
        this.warehousingdate = warehousingdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getHandlers() {
        return handlers;
    }

    public void setHandlers(String handlers) {
        this.handlers = handlers == null ? null : handlers.trim();
    }

}