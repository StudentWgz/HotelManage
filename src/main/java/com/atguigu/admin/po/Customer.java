package com.atguigu.admin.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.lang.reflect.Type;

@TableName("tb_customer")
@Data
public class Customer {
    @TableId(type= IdType.AUTO)
    private Integer customer_id;
    private String customer_name;
    private String customer_password;
    private String customer_room;
}
