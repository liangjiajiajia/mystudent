package com.unisen.student.service;

import com.unisen.student.po.Admin;
import com.unisen.student.po.Classes;

import java.util.List;

public interface IClassService {

    List<Classes> classList();

    void insertClass(Classes classes);
}
