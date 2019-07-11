package com.scce.pojo;

public class Easybuycar {
    private int id;
    private int userId;
    private int productId;
    private int productNumber;
    private EasybuyProduct easybuyProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public EasybuyProduct getEasybuyProduct() {
        return easybuyProduct;
    }

    public void setEasybuyProduct(EasybuyProduct easybuyProduct) {
        this.easybuyProduct = easybuyProduct;
    }

    @Override
    public String toString() {
        return "Easybuycar{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", productNumber=" + productNumber +
                ", easybuyProduct=" + easybuyProduct +
                '}';
    }
}
