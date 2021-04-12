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
    public User toLogin(String username, String password) {
        return userMapper.getUserByNameAndPwd(username, password);
    }

    @Override
    public String resetPassword(String username, String email, String newPassword) {
        User user = userMapper.getUserByNameAndEmail(username, email);
        if (user == null) {
            return "error";
        }
        userMapper.resetPassword(username, email, newPassword);
        return "success";
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void insertUser(String username, String password, String email, Date dateOfBirth, Boolean sex) {
        userMapper.insertUser(username, password, email, dateOfBirth, sex);
    }

    @Override
    public String editPersonalInfo(String username, String email, Date dateOfBirth, Boolean sex) {
        User user = userMapper.getUserByEmail(email);
        if (user != null && !user.getUsername().equals(username)) {
            return "try another email";
        }
        userMapper.updateEmail(email, username);
        userMapper.updateDateOfBirth(dateOfBirth, username);
        userMapper.updateSex(sex, username);
        return "success";
    }

}
