package com.my.app.dao;

import com.my.app.domain.Student;

public interface StudentDao {
    int save(String name);
    
    Student findById(int id);

    Student findByName(String name);
}
