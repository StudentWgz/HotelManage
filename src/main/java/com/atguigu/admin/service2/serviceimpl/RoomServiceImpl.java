package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.RoomMapper;
import com.atguigu.admin.po.Room;
import com.atguigu.admin.service2.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Override
    public int deleteRoom(int room_id) {
        return roomMapper.deleteRoom(room_id);
    }
}
