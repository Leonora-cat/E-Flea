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
    public void insertUser(String username, String password, String email, String major, Date dateOfBirth, Boolean sex) {
        userMapper.insertUser(username, password, email, major, dateOfBirth, sex);
    }

    @Override
    public void updateEmail(String email, Long userID) {
        userMapper.updateEmail(email, userID);
    }

    @Override
    public void updateMajor(String major, Long userID) {
        userMapper.updateMajor(major, userID);
    }

    @Override
    public void updateDateOfBirth(Date dateOfBirth, Long userID) {
        userMapper.updateDateOfBirth(dateOfBirth, userID);
    }

    @Override
    public void updateSex(Boolean sex, Long userID) {
        userMapper.updateSex(sex, userID);
    }
}
