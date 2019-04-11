package com.unisen.student.service;

import com.unisen.student.po.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IStudentService {

    void insertStudent(Student student);

    Map<String,Object> selectStudentPage(Integer curentPage, Integer lineCount) throws SQLException;
}
