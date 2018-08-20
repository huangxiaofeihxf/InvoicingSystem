package com.hxf.service;

import com.hxf.bean.Product;
import com.hxf.bean.Sale;
import com.hxf.bean.Users;
import com.hxf.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huangxiaofei on 2018/8/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userDao;
    @Override
    public Users login(Users user) {
        return userDao.login(user);
    }
    //查询option下拉列表中所有商品的商品名称
    public List<Product> option(){
        List<Product> list=new ArrayList<Product>();
        list = userDao.option();
        return list;
    };

    public Product getProductById(int id){
         return userDao.getProductById(id);
    }

    public int addSale(Sale sale){
      return userDao.addSale(sale);
    }

    public void updateProductNum(int quantity,int id){
        userDao.updateProductNum(quantity,id);
    }

    public int findAllSaleCount(){
        System.out.println("haha");
        System.out.println(userDao.findAllSaleCount());
        return  userDao.findAllSaleCount();
    }
    public List<Sale> findAllSaleDetailByPage(int pageNum,int pageSize){
        List<Sale> list=userDao.findAllSaleDetailByPage(pageNum,pageSize);
        return list;
    }
}

