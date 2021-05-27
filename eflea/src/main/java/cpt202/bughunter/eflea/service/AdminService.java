package cpt202.bughunter.eflea.service;

import cpt202.bughunter.eflea.domain.Admin;

public interface AdminService {
    Admin getAdminByNameAndPwd(String adminName, String password);
    Admin getAdminByName(String adminName);
    void update(String mail);
}
