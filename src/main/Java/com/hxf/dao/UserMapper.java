package com.hxf.dao;

import com.hxf.bean.Product;
import com.hxf.bean.Sale;
import com.hxf.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Huangxiaofei on 2018/8/17.
 */
@Repository
public interface UserMapper{
    Users login(Users user);
    List<Product> option();
    public Product getProductById(int id);

    public int addSale(Sale sale);

    void updateProductNum(int quantity, int id);

    int findAllSaleCount();

    List<Sale> findAllSaleDetailByPage(int pageNum,int pageSize);

}
