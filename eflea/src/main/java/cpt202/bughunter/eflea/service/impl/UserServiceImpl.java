package cpt202.bughunter.eflea.service.impl;

import cpt202.bughunter.eflea.domain.User;
import cpt202.bughunter.eflea.mapper.UserMapper;
import cpt202.bughunter.eflea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

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
            return "Username and email do not match";
        }
        userMapper.resetPassword(username, email, newPassword);
        return "success";
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public void insertUser(String username, String password,String major, String email, Date dateOfBirth, Boolean sex) {
        userMapper.insertUser(username, password,major, email, dateOfBirth, sex);
    }

    @Override
    public String editPersonalInfo(String username, String email,String major, Date dateOfBirth, Boolean sex) {
        User user = userMapper.getUserByEmail(email);
        if (user != null && !user.getUsername().equals(username)) {
            return "try another email";
        }
        userMapper.updateEmail(email, username);
        userMapper.updateDateOfBirth(dateOfBirth, username);
        userMapper.updateSex(sex, username);
        userMapper.updateMajor(major,username);
        return "success";
    }

    @Override
    public int getTotalUserNum() {
        return userMapper.getTotalUserNum();
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public String deleteUser(String username) {
        userMapper.deleteUser(username);
        return "success";
    }

}
