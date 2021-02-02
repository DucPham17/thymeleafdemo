package com.ducpham.springboot.thymeleafdemo.repository;

import com.ducpham.springboot.thymeleafdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
