package com.atguigu.admin.service2;

import com.atguigu.admin.po.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CustomerService extends IService<Customer> {
    public int updateCustomerById(Customer customer);
    public int insertCustomer(Customer customer);
}
