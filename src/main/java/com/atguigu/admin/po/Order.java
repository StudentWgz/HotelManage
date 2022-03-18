package com.atguigu.admin.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_order")
public class Order implements Serializable {
    private int order_id;
    private String order_user;
    private String order_type;
    private String order_begin;
    private String order_end;
    private String order_money;
    private String order_time;
}
