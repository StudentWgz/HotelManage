package com.atguigu.admin.controller;


import com.atguigu.admin.po.Customer;
import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.CustomerService;
import com.atguigu.admin.service2.OrderService;
import com.atguigu.admin.service2.RoomService;
import com.atguigu.admin.service2.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@Controller
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    RoomService roomService;
    @Autowired
    OrderService orderService;
    /*
    * 进入首页
    * */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }
    /*
    *  首页的相关功能，验证密码和跳转主界面
    * */
    @PostMapping(value = "/login")
    public String tables(String user_name,String user_password,HttpSession session,
                         Model model) {
        User user=userService.getUserByName(user_name);
        System.out.println("用户名为："+user_name+"密码为："+user_password+"查询到的用户为："+user);
        if(user == null){
            model.addAttribute("msg","账号或者密码为空");
            return "login";
        }
        if (user_name.equals(user.getUser_name()) && user_password.equals(user.getUser_password())) {
            session.setAttribute("LoginUser", user);
            return "redirect:/index.html";
        }
        else {
            model.addAttribute("msg", "您的账号或者密码错误");
            return "login";
        }
    }

    /*
    * 查询客户数目，以表格形式传递到后端网页
    * */
    @GetMapping("getTables.html")
    public String getTables(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("LoginUser");
        if (loginUser != null) {
            List<Customer> customers =customerService.getAllCustomer();
            model.addAttribute("customers",customers);
            log.info("内容数为{}", customers);
            return "tables";
        } else {
            model.addAttribute("msg", "未登录，请重试");
            return "login";
        }
    }
    /*
    * index界面的功能，可视化数据
    * */


    @GetMapping("/index.html")
    public String getIndex(Model model){
        int user_count = userService.count();
        model.addAttribute("user_count", user_count);
        int customer_count = customerService.count();
        model.addAttribute("customer_count", customer_count);
        int room_count = roomService.count();
        model.addAttribute("room_count", room_count);
        int order_count = orderService.count();
        model.addAttribute("order_count", order_count);
        return "index";
    }
    //退出登录
    @GetMapping("/logout")
    public String Logout(HttpSession httpSession){
        httpSession.invalidate();
        Object session = httpSession.getAttribute("session");
        Object session1=httpSession.getAttribute("session1");
        log.info("session{}session1{}",session,session1);
        return "/";
    }


}
