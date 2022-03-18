package com.atguigu.admin.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@TableName("tb_room")
@Data
public class Room implements Serializable {
    @TableId
    private int room_id;
    private String room_name;
    private String room_type;
    private Double room_money;
}
