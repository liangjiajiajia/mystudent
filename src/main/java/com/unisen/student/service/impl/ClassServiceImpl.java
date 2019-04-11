package com.unisen.student.service.impl;

import com.unisen.student.dao.IClassDao;
import com.unisen.student.dao.impl.AdminDaoImpl;
import com.unisen.student.dao.impl.ClassDaoImpl;
import com.unisen.student.po.Admin;
import com.unisen.student.po.Classes;
import com.unisen.student.service.IAdminService;
import com.unisen.student.service.IClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    @Resource
    IClassDao classDao;


    @Override
    public List<Classes> classList() {
        return classDao.classList();

    }

    @Override
    public void insertClass(Classes classes) {
        classDao.insertClass(classes);
    }
}
