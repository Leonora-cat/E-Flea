package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.User;
import java.sql.Date;

public interface UserService {
    User toLogin(String username,String password);
    User getUserByName(String username);
    void insertUser(String username, String password, Date dateOfBirth, Boolean sex);
}
