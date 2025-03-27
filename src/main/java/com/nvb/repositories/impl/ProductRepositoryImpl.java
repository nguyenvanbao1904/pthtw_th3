/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvb.repositories.impl;

import com.nvb.pojo.Product;
import com.nvb.repositories.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    private static final int PAGE_SIZE = 4;

    @Override
    public List<Product> getAll(Map<String, String> myMap){
        try(Session s = factory.getObject().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> cq = b.createQuery(Product.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(root);
            
            if(myMap != null){
                List<Predicate> predecates = new ArrayList<>();
                String nameKw = myMap.get("name");
                String fromPrice = myMap.get("fromPrice");
                String toPrice = myMap.get("toPrice");
                String categoryId = myMap.get("categoryId");
                if (nameKw != null && nameKw != " "){ //tiep tuc o day
                    predecates.add(b.like(root.get("name"), String.format("%%%s%%", nameKw)));
                }
                if(fromPrice != null){
                    predecates.add(b.greaterThanOrEqualTo(root.get("price"), Double.valueOf(fromPrice)));
                }
                if(toPrice != null){
                    predecates.add(b.lessThanOrEqualTo(root.get("price"), Double.valueOf(toPrice)));
                }
                if(categoryId != null){
                    predecates.add(b.equal(root.get("category").as(Integer.class), Integer.valueOf(categoryId)));
                }
                
                cq.where(predecates.toArray(Predicate[]::new));
            }
            
            Query q = s.createQuery(cq);
            if(myMap != null){
                q.setMaxResults(PAGE_SIZE);
                int page = Integer.parseInt(myMap.getOrDefault("page", "1"));
                int first = (page - 1) * PAGE_SIZE;
                q.setFirstResult(first);
            }
            return q.getResultList();
        }
    }

    @Override
    public Product getProductById(int id) {
        try(Session s = factory.getObject().openSession()){
            return s.get(Product.class, id);
        }
    }

    @Override
    public Product createOrUpdate(Product product) {
        try(Session s = factory.getObject().openSession()){
            if(product.getId() == null){
                s.persist(product);
            }else{
                s.merge(product);
            }
            s.refresh(product);
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        try(Session s = factory.getObject().openSession()){
            Product product = s.get(Product.class, id);
            s.remove(product);
        }
    }
}
