package com.wang.controller;

import com.wang.pojo.Contact;
import com.wang.serviceImpl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @Autowired
    ContactServiceImpl contactService;

    @GetMapping("/user/contactlistHtml")
    public String contactlistHtml(Model model){
        Contact contact = contactService.queryAll();
        model.addAttribute("contact",contact);
        return "/comm/contactlist";
    }
    @GetMapping("/user/updateContactHtml")
    public String updateContactHtml(Model model){
        Contact contact = contactService.queryAll();
        model.addAttribute("contact",contact);
        return "/comm/updateContact";
    }

    @PostMapping("/user/updateContact")
    public String updateContact(Contact contact,Model model){
        contactService.updateContact(contact);
        return "redirect:/user/contactlistHtml";
    }

}
