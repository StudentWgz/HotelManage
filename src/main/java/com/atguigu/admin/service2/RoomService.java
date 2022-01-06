package com.atguigu.admin.service2;

import com.atguigu.admin.po.Room;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RoomService extends IService<Room> {
    public int deleteRoom(int room_id);
}
