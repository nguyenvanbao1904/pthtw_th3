//package com.nvb.repositories.impl;
//
//import com.nvb.pojo.Cart;
//import com.nvb.pojo.OrderDetail;
//import com.nvb.pojo.SaleOrder;
//import com.nvb.pthtw_th2.HibernateUtils;
//import org.hibernate.Session;
//
//import java.util.Date;
//import java.util.Map;
//
//public class ReceiptRepositoryImpl {
//    public void addReceipt(Map<String, Cart> carts) {
//        if (carts!=null) {
//            try(Session s = HibernateUtils.getSessionFactory().openSession()){
//                SaleOrder saleOrder = new SaleOrder();
//                saleOrder.setCreatedDate(new Date());
//                saleOrder.setUser(new UserRepositoryImpl().getUserByUsername("dhthanh"));
//                s.persist(saleOrder);
//
//                for (var c : carts.values()) {
//                    OrderDetail orderDetail = new OrderDetail();
//                    orderDetail.setQuantity(c.getQuantity());
//                    orderDetail.setUnitPrice(c.getPrice());
//                    orderDetail.setOrder(saleOrder);
//                    orderDetail.setProduct(new ProductRepositoryImpl().getProductById(c.getId()));
//                    s.persist(orderDetail);
//                }
//            }
//        }
//    }
//}
