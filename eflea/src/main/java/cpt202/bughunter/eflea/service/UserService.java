package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.User;

public interface UserService {
    User toLogin(String username,String password);
}
