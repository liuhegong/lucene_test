package com.ssm.demo.web.service.impl;

import com.ssm.demo.web.dao.UserDAO;
import com.ssm.demo.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.demo.web.service.UserService;

/**
 * user:ouym
 * date: 2015/7/31
 * time: 11:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDAO userDAO;

    @Override
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }



}
