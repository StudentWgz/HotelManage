package com.atguigu.admin.controller;

import com.atguigu.admin.po.Room;
import com.atguigu.admin.service2.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class RoomController{
    @Autowired
    RoomService roomService;

    @GetMapping("room/delete/{id}")
    public String selectRoom(@PathVariable("id") int id){
        boolean b = roomService.removeById(id);
        log.info("删除{}条",b);
        return "redirect:/room_tables.html";
    }
}
