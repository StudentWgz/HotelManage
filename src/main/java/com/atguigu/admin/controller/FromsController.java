package com.atguigu.admin.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Slf4j
public class FromsController {
    @GetMapping("/utilities-other")
    public String getOther(){
        return "froms/utilities-other";
    }
    @SneakyThrows
    @PostMapping("/upload")
    public String upload(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestPart("file1") MultipartFile file1,
                         @RequestPart("file2") MultipartFile[] file2){
        log.info("上传的信息，username={}，password={}，file1={}，file2={}",username,password, file1.getSize(),file2.length);
        if (!file1.isEmpty()){
            String originalFilename = file1.getOriginalFilename();
            file1.transferTo(new File("F:\\2000\\"+originalFilename));
        }
        if (file2.length>0){
            for (MultipartFile file:file2
                 ) {
                if (!file.isEmpty()) {
                    String originalFilename = file.getOriginalFilename();
                    file.transferTo(new File("F:\\2000\\" + originalFilename));
                }
            }
        }
        return "tables";
    }
}
