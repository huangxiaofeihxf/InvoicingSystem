package com.hxf.controller;

import com.github.pagehelper.PageInfo;
import com.hxf.bean.Product;
import com.hxf.bean.Sale;
import com.hxf.bean.Users;
import com.hxf.service.UserService;
import com.hxf.util.ResponseUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huangxiaofei on 2018/8/19.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private UserService userService;
    //查询option下拉列表中所有商品的商品名称
    @RequestMapping("/option")
    public String option(HttpServletRequest request){
        List<Product> list=new ArrayList<Product>();
        list= userService.option();
        request.setAttribute("list",list);
        //ResponseUtil.responseJson(list,response);
        return "/main.jsp";
    }
    @RequestMapping("/addSale")
    @ResponseBody
    public int addSale(Sale sale,HttpSession session){
        Users loginUser =(Users) session.getAttribute("loginUser");
        sale.setUserId(loginUser.getId());
        System.out.println(sale.getId());
        sale.setTotalPrice(sale.getPrice()*sale.getQuantity());
        System.out.println(sale);
        int reslut=userService.addSale(sale);
        int productId = sale.getProductId();
        int quantity = sale.getQuantity();
        userService.updateProductNum(quantity,productId);
        System.out.println(reslut);
        return reslut;
    }
    @RequestMapping("/findAllSaleDetail")
    @ResponseBody
    public PageInfo findAllSaleDetailByPage(Integer pageNum){
        System.out.println(pageNum);
        pageNum=pageNum==null?1:pageNum;
        System.out.println(pageNum);
        PageInfo pageInfo = new PageInfo();
        System.out.println(pageNum);
        pageInfo.setPageNum(pageNum);
        int count = userService.findAllSaleCount();
        pageInfo.setTotal((long)count);
        System.out.println(pageInfo.getTotal());
        pageInfo.setPageSize(3);
        List<Sale> list = userService.findAllSaleDetailByPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        System.out.println(list);
        pageInfo.setList(list);
        return pageInfo;
    }
}
