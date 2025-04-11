package com.nvb.controllers;

import com.nvb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;

    @DeleteMapping("/products/{product_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void destroy(@PathVariable(value = "product_id") int product_id) {
        this.productService.deleteProduct(product_id);
    }
}
