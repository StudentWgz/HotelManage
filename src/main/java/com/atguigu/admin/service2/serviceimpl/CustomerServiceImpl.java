package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.CustomerMapper;
import com.atguigu.admin.po.Customer;
import com.atguigu.admin.service2.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public int updateCustomerById(Customer customer) {
        return customerMapper.updateCustomerById(customer);
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }
}
