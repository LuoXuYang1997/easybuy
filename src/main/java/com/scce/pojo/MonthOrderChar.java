package com.scce.pojo;

public class MonthOrderChar {
    private String month;
    private int sum;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "MonthOrderChar{" +
                "month='" + month + '\'' +
                ", sum=" + sum +
                '}';
    }
}
