package com.unisen.student.dao.impl;

import com.unisen.student.dao.IAdminDao;
import com.unisen.student.po.Admin;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl extends SqlSessionDaoSupport implements IAdminDao{

    @Autowired
    public AdminDaoImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public Admin login(Admin admin) {
        return super.getSqlSession().selectOne("AdminNS.findLogin", admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        getSqlSession().update("AdminNS.updateAdmin", admin);
    }
}
