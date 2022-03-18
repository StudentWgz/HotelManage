package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByName(String user_name){
        return userMapper.getUserByName(user_name);
    }

    @Override
    public int inSertUser(User user) {
        return userMapper.inSertUser(user);
    }

    @Override
    public User getForgotPassword(String email) {
        return userMapper.getForgotPassword(email);
    }

    @Override
    public int updataUserById(User user) {
        return userMapper.updataUserById(user);
    }

    @Override
    @Cacheable(cacheNames = {"user_list"})
    public List<User> getAllUsers() {
        List<User> users = userMapper.list();
        return  users;
    }


}
