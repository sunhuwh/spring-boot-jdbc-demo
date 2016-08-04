package com.my.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.domain.Student;
import com.my.app.service.StudentService;

@RestController
@RequestMapping
public class IndexController {

    @Autowired
    private StudentService studentService;
    
    @RequestMapping
    public String index(){
        Student student = studentService.findById(1);
        return student.getId()+":"+student.getName();
    }
    
    @RequestMapping(value = "/save")
    public String save(){
        String name = "sunhuwh";
        int id = studentService.save(name);
        return "id:"+id+"name"+name;
    }
    
}
