package com.nvb.repositories;

import com.nvb.pojo.User;

public interface UserRepository {
    public User getUserByUsername(String username);
    public User addUser(User user);
}
