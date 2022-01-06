package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
