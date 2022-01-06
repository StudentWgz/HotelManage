package com.atguigu.admin.controller;


import com.atguigu.admin.po.Customer;
import com.atguigu.admin.service2.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    //增加客户信息
    @GetMapping("/addCustomer")
    public String getAdd(){
        return "addCustomer";
    }
    @PostMapping("addCustomer.html")
    public String addCustomer(String customer_name,String customer_password,String customer_room){
        Customer customer=new Customer();
        customer.setCustomer_name(customer_name);
        customer.setCustomer_password(customer_password);
        customer.setCustomer_room(customer_room);
        int i = customerService.insertCustomer(customer);
        log.info("获取的客户信息为{}",customer);
        log.info("添加了{}行",i);
        return "redirect:getTables.html";
    }

    //修改客户信息

    @GetMapping("/customer/update/{id}")
    public String updateCustomer(@PathVariable("id") Integer id,HttpSession session3){
        session3.setAttribute("id",id);
        log.info("id={}",id);
        return "alterCustomer.html";
    }

    @PostMapping("/alterCustomer.html")
    public String alterCustomer(HttpSession session3,String CustomerName,String password,String RoomType){
        Integer id = (Integer) session3.getAttribute("id");
        Customer customer=new Customer();
        customer.setCustomer_name(CustomerName);
        customer.setCustomer_password(password);
        customer.setCustomer_room(RoomType);
        customer.setCustomer_id(id);
        int i = customerService.updateCustomerById(customer);
        log.info("修改的数据为：{}"+i);
        return "redirect:getTables.html";
    }
}
