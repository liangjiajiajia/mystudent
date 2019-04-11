package com.unisen.student.service.impl;

import com.unisen.student.dao.IClassDao;
import com.unisen.student.dao.IStudentDao;
import com.unisen.student.po.Classes;
import com.unisen.student.po.Student;
import com.unisen.student.service.IClassService;
import com.unisen.student.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    IStudentDao studentDao;

    @Override
    public  Map<String, Object> selectStudentPage(Integer curentPage, Integer lineCount) throws SQLException {
//        return   studentDao.selectStudentPage(curentPage, lineCount);
        Map<String,Object> map  = new HashMap<>();
        map.put("allStudent",this.studentDao.selectStudentPage(curentPage,lineCount));
        map.put("studentCount",this.studentDao.getAllCount());
        return map;

    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);

    }
}
