package com.nvb.repositories.impl;

import com.nvb.pojo.User;
import com.nvb.repositories.UserRepository;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public User getUserByUsername(String username) {
        Session s = factory.getObject().getCurrentSession();
            Query q = s.createNamedQuery("User.findByUsername", User.class);
            q.setParameter("username", username);
            return (User)q.getSingleResult();

    }

    @Override
    public User addUser(User user) {
        Session s = factory.getObject().getCurrentSession();
        s.persist(user);
        return user;
    }
}
