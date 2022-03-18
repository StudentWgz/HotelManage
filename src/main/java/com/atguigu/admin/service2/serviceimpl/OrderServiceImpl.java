package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.OrderMapper;
import com.atguigu.admin.po.Order;
import com.atguigu.admin.service2.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    @Cacheable(cacheNames = {"order_list"})
    public List<Order> getAllOrders() {
        return orderMapper.list();
    }
}
