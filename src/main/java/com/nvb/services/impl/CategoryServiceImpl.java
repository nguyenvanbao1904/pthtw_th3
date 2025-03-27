/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvb.services.impl;

import com.nvb.pojo.Category;
import com.nvb.repositories.CategoryRepository;
import com.nvb.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }
    
}
