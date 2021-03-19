package cpt202.bughunter.eflea.service.impl;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.mapper.UserMapper;
import cpt202.bughunter.eflea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User toLogin(String username,String password) {
        return userMapper.getUserByNameAndPwd(username,password);
    }
}
