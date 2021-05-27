package cpt202.bughunter.eflea.service.impl;

import cpt202.bughunter.eflea.domain.Admin;
import cpt202.bughunter.eflea.mapper.AdminMapper;
import cpt202.bughunter.eflea.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin getAdminByNameAndPwd(String adminName, String password) {
        return adminMapper.getAdminByNameAndPwd(adminName, password);
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return adminMapper.getAdminByName(adminName);
    }

    @Override
    public void update(String mail) {
        adminMapper.update(mail);
    }
}
