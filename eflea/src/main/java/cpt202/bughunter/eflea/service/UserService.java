package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.User;

import java.sql.Date;

public interface UserService {
    User toLogin(String username, String password);

    String resetPassword(String username, String email, String newPassword) throws Exception;

    User getUserByName(String username);
    void insertUser(String username, String password, String email, Date dateOfBirth, Boolean sex);

    String editPersonalInfo(String username, String email, Date dateOfBirth, Boolean sex);

}
