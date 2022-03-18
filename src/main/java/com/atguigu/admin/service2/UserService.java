package com.atguigu.admin.service2;

import com.atguigu.admin.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User>{

    User getUserByName(String user_name);
    int inSertUser(User user);
    User getForgotPassword(String email);
    int updataUserById(User user);
    //查询用户列表
   List<User> getAllUsers();
}
