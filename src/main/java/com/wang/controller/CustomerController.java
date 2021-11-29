package com.wang.controller;

import com.wang.pojo.Customer;
import com.wang.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("/user/customerlist")
    public String customerListHtml(Model model){
        List<Customer> customers = customerService.queryAll();
        model.addAttribute("customers",customers);
        return "/comm/customerList";
    }


//    @RequestMapping("/user/customerList")
//    public String customerList(Model model){
//        List<Customer> customers = customerService.queryAll();
//        model.addAttribute("customers",customers);
//        return "/comm/customerList";
//    }

    @PostMapping("/insertCustomer")
    @ResponseBody
    public String insertCustomer(Customer customer){
        String msg;
        if (customer.getCont().isEmpty()||customer.getPhone().isEmpty())
        {
            System.out.println("不正确");
            msg= "提交失败";
        }else {
            System.out.println("正确");
            msg= "提交成功";
            System.out.println(customer);
            int i = customerService.insertCustomer(customer);
        }
        System.out.println(msg);
//        String str = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            str = mapper.writeValueAsString(msg);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(str);
        return msg;
    }



    @GetMapping("/user/inser")
    @ResponseBody
    public String inser(String username){
        String msg=null;
        System.out.println(username);
        //int i = customerService.insertCustomer(customer);
//        if(i != 0){
//            msg ="提交成功";
//        }else {
//            msg ="提交失败";
//        }
        return msg;
    }








    @GetMapping("/user/deleteCustomer")
    public  String deleteCustomer(int id){
        customerService.deleteCustomer(id);
        return "redirect:/user/customerlist";
    }
}