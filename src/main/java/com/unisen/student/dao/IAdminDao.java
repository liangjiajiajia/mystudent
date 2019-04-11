package com.unisen.student.dao;

import com.unisen.student.po.Admin;

public interface IAdminDao {

    Admin login(Admin admin);

    void updateAdmin(Admin admin);
}
