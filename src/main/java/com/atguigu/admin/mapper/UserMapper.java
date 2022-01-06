package com.atguigu.admin.mapper;

import com.atguigu.admin.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from tb_user where user_name=#{user_name}")
    public User getUserByName(String user_name);
    @Insert("INSERT INTO tb_user (user_name, user_password, user_email) VALUES (#{user_name}, #{user_password},#{user_email})")
    public int inSertUser(User user);
    @Select("select * from tb_user where user_email=#{email}")
    public User getForgotPassword(String email);
    @Update("UPDATE tb_user SET user_name=#{user_name},user_password=#{user_password},user_email=#{user_email} WHERE user_id=#{user_id}")
    public int updataUserById(User user);
}
