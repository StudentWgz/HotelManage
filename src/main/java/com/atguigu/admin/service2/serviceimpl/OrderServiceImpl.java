package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.OrderMapper;
import com.atguigu.admin.po.Order;
import com.atguigu.admin.service2.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
