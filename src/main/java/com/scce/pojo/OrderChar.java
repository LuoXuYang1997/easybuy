package com.scce.pojo;

public class OrderChar {
    //商品类型
    private String productType;
    //商品总数
    private int sum;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "OrderChar{" +
                "productType='" + productType + '\'' +
                ", sum=" + sum +
                '}';
    }
}
