package com.atguigu.admin.service2.serviceimpl;

import com.atguigu.admin.mapper.RoomMapper;
import com.atguigu.admin.po.Room;
import com.atguigu.admin.service2.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Override
    public int deleteRoom(int room_id) {
        return roomMapper.deleteRoom(room_id);
    }

    @Override
    @Cacheable(cacheNames = {"room_list"})
    public List<Room> getAllRooms() {
        return roomMapper.list();
    }
}
