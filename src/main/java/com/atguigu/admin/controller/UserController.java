package com.atguigu.admin.controller;


import com.atguigu.admin.po.User;
import com.atguigu.admin.service2.UserService;
import com.mysql.cj.Session;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Data
@Slf4j
@Controller
public class UserController {
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    //增加用户
    @Autowired
    UserService userService;

    @PostMapping("/register.html")
    public String addUser(String InputPassword, String InputEmail,
                          String RepeatPassword, String FirstName,
                          String LastName, Model model) {
        log.info("{},{},{},{},{}", InputPassword, InputEmail, RepeatPassword, FirstName, LastName);
        if (InputPassword == null || InputPassword.equals("") || InputEmail == null || InputEmail.equals("")
                || RepeatPassword == null || RepeatPassword.equals("") || FirstName == null || FirstName.equals("")
                || LastName == null || LastName.equals("")) {
            log.info("重新注册");
            return "register";
        }
        if (InputPassword.equals(RepeatPassword) && InputPassword != null && !InputPassword.equals("") && InputEmail != null && !InputEmail.equals("")
                && RepeatPassword != null && !RepeatPassword.equals("") && FirstName != null && !FirstName.equals("")
                && LastName != null && !LastName.equals("")) {
            String user_name = FirstName + LastName;
            User user_name1 = userService.getUserByName(user_name);
            if (user_name.equals(user_name1.getUser_name())) {
                model.addAttribute("msg", "该账户已存在");
                return "register";
            }
            User user = new User();
            user.setUser_name(user_name);
            user.setUser_password(InputPassword);
            user.setUser_email(InputEmail);
            int save = userService.inSertUser(user);
            log.info("是否成功{}", save);
            return "login";
        } else {
            model.addAttribute("msg", "或两次密码不一致");
            return "register";
        }
    }

    //找回密码
    @GetMapping("/forgot-password.html")
    public String getPassword() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password.html")
    public String getForgotPassword(String email, HttpSession session) {
        User user = userService.getForgotPassword(email);
        if (email == null || email.equals("")) {
            return "forgot-password";
        }
        if (user == null) {
            return "forgot-password";
        } else {
            session.setAttribute("user", user);
            log.info("user{}", user);
            return "forgot-password2.html";
        }
    }

    @PostMapping("/login2")
    public String getForgotPassword2() {
        return "login";
    }

    //删除用户
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        boolean b = userService.removeById(id);
        log.info("删除成功{}", b);
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "user_tables";
    }

    //修改用户
    @GetMapping("/alterRegister/{id}")
    public String getAlterRegister(@PathVariable("id") Integer id, HttpSession session2) {
        session2.setAttribute("id", id);
        log.info("id={}", id);
        return "alterRegister";
    }

    @PostMapping("/alterRegister.html")
    public String alterRegister(HttpSession session2, String FirstName, String LastName, String InputEmail, String InputPassword, String RepeatPassword) {
        int id = (int) session2.getAttribute("id");
        log.info("id={},{},{},{},{}.{}", id, FirstName, LastName, InputEmail, InputPassword, RepeatPassword);
        User user = new User();
        user.setUser_id(id);
        user.setUser_name(FirstName + LastName);
        user.setUser_password(InputPassword);
        user.setUser_email(InputEmail);
        System.out.println(user);
        userService.updataUserById(user);
        return "redirect:/user_tables.html";
    }

    @GetMapping("/alterRegister2")
    public String alterRegister() {
        return "alterRegister";
    }

}
