package com.atguigu.admin.config;

import com.atguigu.admin.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAdminConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/register","/register.html","/forgot-password.html","/forgot-password.html","/login2","/alterRegister/*",
                        "/css/**","/img/**","/js/**","/scss/**","vendor/**");
    }
}
