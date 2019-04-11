package com.unisen.student.service;

import com.unisen.student.po.Admin;

public interface IAdminService {

    Admin login(Admin admin);

    void updateAdmin(Admin admin);
}
