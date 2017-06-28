package com.ssm.demo.web.service;

import com.ssm.demo.web.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * user:ouym
 * date: 2015/7/31
 * time: 11:44
 */
@Transactional(readOnly = true)
public interface UserService {

    @Transactional(readOnly = false, rollbackFor = DataAccessException.class)
    public int insertUser(User user);


}
