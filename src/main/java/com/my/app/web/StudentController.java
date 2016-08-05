package com.my.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.domain.Student;
import com.my.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @RequestMapping
    public String index(){
        Student student = studentService.findById(3);
        return student == null ? null : student.getId()+":"+student.getName();
    }
    
    @RequestMapping(params = {"name"})
    public String index(String name){
        Student student = studentService.findByName(name);
        return student == null ? null : student.getId()+":"+student.getName();
    }
    
    @RequestMapping(value = "/save")
    public String save(){
        String name = "sunhuwh";
        int id = studentService.save(name);
        return "id:"+id+"name"+name;
    }
    
}
