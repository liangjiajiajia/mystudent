package com.unisen.student.dao;

import com.unisen.student.po.Admin;
import com.unisen.student.po.Classes;

import java.util.List;

public interface IClassDao {

    List<Classes> classList();

    void insertClass(Classes classes);
}
