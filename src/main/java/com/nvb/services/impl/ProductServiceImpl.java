/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvb.services.impl;

import com.nvb.pojo.Product;
import com.nvb.repositories.ProductRepository;
import com.nvb.services.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAll(Map<String, String> myMap) {
        return this.productRepository.getAll(myMap);
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public Product createOrUpdate(Product product) {
        return this.productRepository.createOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteProduct(id);
    }
    
}
