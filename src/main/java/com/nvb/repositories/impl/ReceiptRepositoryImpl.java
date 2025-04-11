package com.nvb.repositories.impl;

import com.nvb.pojo.Cart;
import com.nvb.pojo.OrderDetail;
import com.nvb.pojo.SaleOrder;
import com.nvb.pojo.User;
import com.nvb.repositories.ProductRepository;
import com.nvb.repositories.ReceiptRepository;
import com.nvb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            Session s = sessionFactory.getObject().getCurrentSession();
            SaleOrder saleOrder = new SaleOrder();
            saleOrder.setCreatedDate(new Date());
            saleOrder.setUser(this.userRepository.getUserByUsername("dhthanh"));
            s.persist(saleOrder);

            for (var c : carts) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setQuantity(c.getQuantity());
                orderDetail.setUnitPrice(c.getPrice());
                orderDetail.setOrder(saleOrder);
                orderDetail.setProduct(this.productRepository.getProductById(c.getId()));
                s.persist(orderDetail);
            }
        }
    }
}
