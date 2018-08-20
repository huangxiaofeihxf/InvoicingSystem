package com.hxf.service;

import com.hxf.bean.Product;
import com.hxf.bean.Sale;
import com.hxf.bean.Users;

import java.util.List;

/**
 * Created by Huangxiaofei on 2018/8/17.
 */
public interface UserService {
    Users login(Users user);
    //查询option下拉列表中所有商品的商品名称
    public List<Product> option();

    public Product getProductById(int id);

    public int addSale(Sale sale);

    void updateProductNum(int quantity,int id);

    int findAllSaleCount();

    List<Sale> findAllSaleDetailByPage(int pageNum,int pageSize);
}
