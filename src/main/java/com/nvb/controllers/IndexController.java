/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvb.controllers;

import com.nvb.services.CategoryService;
import com.nvb.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class IndexController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam Map<String, String> prams){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("products", productService.getAll(prams));
        return "index";
    }
}
