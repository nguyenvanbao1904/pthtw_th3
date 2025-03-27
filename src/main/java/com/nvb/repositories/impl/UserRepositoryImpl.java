//package com.nvb.repositories.impl;
//
//import com.nvb.pojo.User;
//import com.nvb.pthtw_th2.HibernateUtils;
//import jakarta.persistence.Query;
//import org.hibernate.Session;
//
//public class UserRepositoryImpl {
//    public User getUserByUsername(String username) {
//        try(Session s = HibernateUtils.getSessionFactory().openSession()){
//            Query q = s.createNamedQuery("User.findByUsername", User.class);
//            q.setParameter("username", username);
//            return (User)q.getSingleResult();
//        }
//    }
//}
