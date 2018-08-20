package com.hxf.bean;

import java.util.Date;

/**
 * Created by Huangxiaofei on 2018/8/19.
 */
public class Sale {
    private int id;
    private int price;
    private int quantity;
    private int totalPrice;
    private Date saleDate=new Date();
    private int userId;
    private int productId;

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

    public Sale(int id, int price, int quantity, int totalPrice, Date saleDate, int userId, int productId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
        this.userId = userId;
        this.productId = productId;
    }

    public Sale() {
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", saleDate='" + saleDate + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
