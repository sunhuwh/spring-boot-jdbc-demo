package com.my.app.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.my.app.dao.StudentDao;
import com.my.app.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * java8 save
     */
    @Override
    public int save(String name) {
        String sql = "insert into student (name) values (?)";
        KeyHolder key = new GeneratedKeyHolder();
        this.jdbcTemplate.update(con -> {
            PreparedStatement preState =null;
            try {
                preState = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preState.setString(1, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return preState;
        }, key);
        return key.getKey().intValue();
    }

    /**
     * java8 query
     */
    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ? ";
        List<Student> students = jdbcTemplate.query(sql, new Object[] {id}, (rs, rowNum)->{
            return this.initStudent(rs);
        });
        return students != null && !students.isEmpty() ? students.get(0) : null;
    }

    private Student initStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        return student;
    }
    
}
