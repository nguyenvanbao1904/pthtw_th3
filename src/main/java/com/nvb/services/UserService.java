package com.nvb.services;

import com.nvb.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService extends UserDetailsService {
    User getUserByUsername(String username);
    User addUser(Map<String, String> params, MultipartFile avatar);
}
