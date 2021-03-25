package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.User;
import java.sql.Date;

public interface UserService {
    User toLogin(String username,String password);
    User getUserByName(String username);
    void insertUser(String username, String password, String email, String major, Date dateOfBirth, Boolean sex);
    void updateEmail(String email, Long userID);
    void updateMajor(String major, Long userID);
    void updateDateOfBirth(Date dateOfBirth, Long userID);
    void updateSex(Boolean sex, Long userID);

}
