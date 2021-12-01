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

//    @RequestMapping("/user/customerlist")
//    public String customerListHtml(Model model){
//        //List<Customer> customers = customerService.queryAll();
//        List<Customer> customers = customerService.queryPage(0, 10);
//        model.addAttribute("customers",customers);
//        return "/comm/customerList";
//    }


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










    @GetMapping("/user/deleteCustomer")
    public  String deleteCustomer(int id){
        customerService.deleteCustomer(id);
        return "redirect:/user/page";
    }
    @RequestMapping("/for")
    @ResponseBody
    public String for100(){
        Customer customer = new Customer();
        for (int i = 0; i < 7; i++) {
            String name = "li"+i;
            customer.setCont(name);
            customer.setEmail(name);
            customer.setPhone(name);
            customer.setComments(name);
            customerService.insertCustomer(customer);
        }
        return "ok";
    }



    @RequestMapping("/user/page")
    public String page(String page,Model model){
        int pageStart;//开始页
        int pageSubscript;//起始下标
        int pageNum=10;//每页个数
        int pageSize;
        int size;



        if (page == null){
            pageStart = 1;
        }else {
            pageStart=Integer.valueOf(page);

        }

        pageSubscript =(pageStart-1)*10;
        size = customerService.queryAll().size();//数据总数
        System.out.println(size);


        pageNum=10;//每页个数
        pageSize=(size%10!=0?(size/10)+1:size/10);//最多页
        System.out.println(pageSize);


        List<Customer> customers = customerService.queryPage(pageSubscript, pageNum);
        model.addAttribute("customers",customers);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageStart",pageStart);
        return "comm/customerList";
    }

    @RequestMapping("/user/pageDelete")
    @ResponseBody
    public String pageDelete(String[] ids){
        for (String id:ids){
            System.out.println(id);
        }
        return "删除成功";
    }
}