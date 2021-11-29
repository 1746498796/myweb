package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private int id;
    private String cont;
    private String email;
    private String phone;
    private String comments;
    private Date times;
}
