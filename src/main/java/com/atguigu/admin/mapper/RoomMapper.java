package com.atguigu.admin.mapper;

import com.atguigu.admin.po.Room;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper extends BaseMapper<Room> {
    @Delete("delete  from tb_room where room_id=#{room_id}")
    public int deleteRoom(int room_id);
    @Select("select * from tb_room")
    List<Room> list();
}
