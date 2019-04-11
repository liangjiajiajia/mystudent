package com.unisen.student.dao.impl;

import com.unisen.student.dao.IAdminDao;
import com.unisen.student.dao.IClassDao;
import com.unisen.student.po.Admin;
import com.unisen.student.po.Classes;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDaoImpl extends SqlSessionDaoSupport implements IClassDao{

    @Autowired
    public ClassDaoImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public void insertClass(Classes classes) {
        getSqlSession().insert("classesNS.insertClass",classes);

    }

    @Override
    public List<Classes> classList() {
        return getSqlSession().selectList("classesNS.classList");

    }
}
