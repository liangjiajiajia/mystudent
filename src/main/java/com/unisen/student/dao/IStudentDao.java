package com.unisen.student.dao;

import com.unisen.student.po.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IStudentDao {

    void insertStudent(Student student);

   List<Student> selectStudentPage(Integer curentPage, Integer lineCount);

    public Integer getAllCount()throws SQLException;
}
