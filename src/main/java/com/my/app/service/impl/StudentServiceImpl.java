package com.my.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.dao.StudentDao;
import com.my.app.domain.Student;
import com.my.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentDao studentDao;

    @Override
    public int save(String name) {
        return studentDao.save(name);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }
    
    @Override
    public Student findByName(String name) {
        return studentDao.findByName(name);
    }
}
