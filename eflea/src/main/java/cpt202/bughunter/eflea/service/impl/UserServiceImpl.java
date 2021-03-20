package cpt202.bughunter.eflea.service.impl;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.mapper.UserMapper;
import cpt202.bughunter.eflea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User toLogin(String username,String password) {
        return userMapper.getUserByNameAndPwd(username,password);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void insertUser(String username, String password, Date dateOfBirth, Boolean sex) {
        userMapper.insertUser(username, password, dateOfBirth, sex);
    }
}
