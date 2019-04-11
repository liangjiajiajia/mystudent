package com.unisen.student.service.impl;

import com.unisen.student.dao.impl.AdminDaoImpl;
import com.unisen.student.po.Admin;
import com.unisen.student.service.IAdminService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    AdminDaoImpl adminDao;

    @Override
    public Admin login(Admin admin) {
       Admin admin1 =  adminDao.login(admin);
       return admin1;

    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }
}
