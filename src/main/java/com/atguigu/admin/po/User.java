package com.atguigu.admin.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value="tb_user")
public class User implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_email;

}
