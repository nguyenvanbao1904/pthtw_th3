package com.nvb.controllers;

import com.nvb.pojo.Product;
import com.nvb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String creatView(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(value = "product") Product product) {
        this.productService.createOrUpdate(product);
        return "redirect:/";
    }

    @GetMapping("/products/{productId}")
    public String updateView(Model model, @PathVariable("productId") int productId) {
        Product product = this.productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product";
    }

}
