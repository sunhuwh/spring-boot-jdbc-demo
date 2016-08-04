package com.my.app.service;

import com.my.app.domain.Student;

public interface StudentService {
    
    int save(String name);
    
    Student findById(int id);
    
}
