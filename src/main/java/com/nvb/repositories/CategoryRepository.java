/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nvb.repositories;

import com.nvb.pojo.Category;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CategoryRepository {
    List<Category> getAll();
}
