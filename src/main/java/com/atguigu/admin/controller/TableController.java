package com.atguigu.admin.controller;

import com.atguigu.admin.po.Customer;
import com.atguigu.admin.po.Order;
import com.atguigu.admin.po.Room;
import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.CustomerService;
import com.atguigu.admin.service2.OrderService;
import com.atguigu.admin.service2.RoomService;
import com.atguigu.admin.service2.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
public class TableController {
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    RoomService roomService;
    @Autowired
    OrderService orderService;

    @GetMapping("/cards")
    public String getCart(){
        return "Components/cards";
    }

    @GetMapping("/buttons")
    public String getButtons(){
        return "Components/buttons";
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        customerService.removeById(id);
        System.out.println("删除成功");
        List<Customer> customers =customerService.list();
        model.addAttribute("customers",customers);
        return "tables";
    }

    @GetMapping("/user_tables.html")
    public String user_table(Model model) {
        List<User> user_list = userService.list();
        model.addAttribute("users",user_list);
        return "user_tables";
    }

    @GetMapping("/room_tables.html")
    public String room_table(Model model) {
        List<Room> rooms = roomService.list();
        model.addAttribute("rooms",rooms);
        return "room_tables";
    }

    @GetMapping("/order_tables.html")
    public String order_room(Model model) {
        List<Order> orders = orderService.list();
        model.addAttribute("orders",orders);
        return "order_tables";
    }
}
