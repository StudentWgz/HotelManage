package com.atguigu.admin.service2;

import com.atguigu.admin.po.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> getAllOrders();
}
