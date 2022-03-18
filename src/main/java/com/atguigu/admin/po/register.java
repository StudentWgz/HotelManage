package com.atguigu.admin.po;

import lombok.Data;

import java.io.Serializable;


@Data
public class register implements Serializable {
    private String InputPassword;
    private String InputEmail;
    private String RepeatPassword;
    private String FirstName;
    private String LastName;

}
