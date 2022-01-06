package com.atguigu.admin.mapper;

import com.atguigu.admin.po.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    @Update("UPDATE tb_customer SET customer_name=#{customer_name},customer_password=#{customer_password},customer_room=#{customer_room} WHERE customer_id=#{customer_id}")
    public int updateCustomerById(Customer customer);
    @Insert("insert tb_customer(customer_name,customer_password,customer_room) values(#{customer_name},#{customer_password},#{customer_room})")
    public int insertCustomer(Customer customer);
}
