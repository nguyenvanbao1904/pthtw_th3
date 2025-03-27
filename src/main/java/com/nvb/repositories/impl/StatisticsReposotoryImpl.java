///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nvb.repositories.impl;
//
//import com.nvb.pojo.OrderDetail;
//import com.nvb.pojo.Product;
//import com.nvb.pojo.SaleOrder;
//import com.nvb.pthtw_th2.HibernateUtils;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Join;
//import jakarta.persistence.criteria.JoinType;
//import jakarta.persistence.criteria.Root;
//
//import java.util.Date;
//import java.util.List;
//import org.hibernate.Session;
//
///**
// *
// * @author admin
// */
//public class StatisticsReposotoryImpl {
//    public List<Object[]> statisticsRevenueByProducts(){
//         try(Session s = HibernateUtils.getSessionFactory().openSession()){
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
//            Root<OrderDetail> root = cq.from(OrderDetail.class);
//            Join<OrderDetail, Product> join = root.join("product", JoinType.RIGHT);
//            cq.multiselect(join.get("id"), join.get("name"), b.sum(b.prod(root.get("quantity"), root.get("unitPrice"))));
//            cq.groupBy(join.get("id"));
//            
//            Query q = s.createQuery(cq);
//            return q.getResultList();
//         }
//    }
//
//     public List<Object[]> statisticsRevenueByTime(String time, int year){
//         try(Session s = HibernateUtils.getSessionFactory().openSession()){
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Object[]> cq = b.createQuery(Object[].class);
//            Root<OrderDetail> root = cq.from(OrderDetail.class);
//            Join<OrderDetail, SaleOrder> join = root.join("order", JoinType.INNER);
//             cq.multiselect(
//                     b.function(time, Integer.class, join.get("createdDate")),
//                     b.sum(b.prod(root.get("quantity"), root.get("unitPrice")))
//             );
//             cq.where(b.equal(b.function("YEAR", Integer.class, join.get("createdDate")), year));
//
//             cq.groupBy(b.function(time, Integer.class, join.get("createdDate")));
//            
//            Query q = s.createQuery(cq);
//            return q.getResultList();
//         }
//    }
//}
