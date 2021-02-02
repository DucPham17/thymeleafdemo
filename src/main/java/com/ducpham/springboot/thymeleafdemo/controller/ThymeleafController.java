package com.ducpham.springboot.thymeleafdemo.controller;

import com.ducpham.springboot.thymeleafdemo.entity.Customer;
import com.ducpham.springboot.thymeleafdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class ThymeleafController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/")
    public String getHtml(Model model){
        List<Customer> list =  customerRepository.findAll();
        System.out.println(customerRepository.findAll().toString());
        model.addAttribute("customers", list);
        return "customer-list";
    }

    @GetMapping("/showFormForAdd")
    public String getAddForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "add-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/test/";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam int customerId, Model model){
        Customer customer = customerRepository.getOne(customerId);
        model.addAttribute("customer",customer);
        return "add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int customerId){
        customerRepository.deleteById(customerId);
        return "redirect:/test/";
    }
}
