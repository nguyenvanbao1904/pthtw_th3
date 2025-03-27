/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nvb.services;

import com.nvb.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface ProductService {

    List<Product> getAll(Map<String, String> myMap);
    Product getProductById(int id);
    Product createOrUpdate(Product product);
    void deleteProduct(int id);
}
