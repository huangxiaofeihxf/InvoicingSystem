package com.hxf.bean;

import java.util.Date;

/**
 * Created by Huangxiaofei on 2018/8/20.
 */
public class SaleDetail {
    private int id;
    private int price;
    private int quantity;
    private int totalPrice;
    private Date saleDate=new Date();
    private String realName;
    private String productName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public SaleDetail() {
    }

    public SaleDetail(int id, int price, int quantity, int totalPrice, Date saleDate, String realName, String productName) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
        this.realName = realName;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "SaleDetail{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", saleDate=" + saleDate +
                ", realName='" + realName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
