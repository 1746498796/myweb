package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private int id;
    private String lxtext;
    private String address;
    private String email;
    private String phone;
    private String WeCat;
    private String beian;
}
