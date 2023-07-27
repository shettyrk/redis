package com.nikita.springbootexample3.controller;

import com.nikita.springbootexample3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    @Autowired
    private ProductService productService;





//    @GetMapping("/getData/{id}")
//    public void getData(@PathVariable Integer id){
//        productService.getData(id);
//    }

}
