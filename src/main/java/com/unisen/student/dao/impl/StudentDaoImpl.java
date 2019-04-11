package com.unisen.student.dao.impl;

import com.unisen.student.dao.IClassDao;
import com.unisen.student.dao.IStudentDao;
import com.unisen.student.po.Classes;
import com.unisen.student.po.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao{

    @Autowired
    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }


    @Override
    public void insertStudent(Student student) {

        getSqlSession().insert("StudentNS.insertStudent",student);

    }

    @Override
    public Integer getAllCount() throws SQLException {
        return null;
    }

    @Override
    public List<Student> selectStudentPage(Integer curentPage, Integer lineCount) {

        Map<String, Object> map = new HashMap<>();
        map.put("start", (curentPage - 1) * lineCount);
        map.put("lineSize", lineCount);
        return getSqlSession().selectList("StudentNS.selectStudentPage", map);

    }
}
