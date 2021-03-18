package com.zmk.spring.test.rd.multidb.mybatisjpa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.model.Employeej1;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.service.EmployeesjService1;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.model.Employeej2;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.service.EmployeesjService2;

@RestController
public class TestController {
    
    @Autowired 
    private EmployeesjService1 employeesjService1;
    @Autowired 
    private EmployeesjService2 employeesjService2;
    
    @GetMapping("/api/db1/insertListEmployeeNoIdJPA")
    public void insertListEmployeeNoIdJPA(){
    	 employeesjService1.insertListEmployeeNoIdJPA();
    }
    @GetMapping("/api/db1/insertListEmployeeIdJPA")
    public void insertListEmployeeIdJPA(){
    	 employeesjService1.insertListEmployeeIdJPA();
    }
    @GetMapping("/api/db1/insertListEmployeeNoIdBatis")
    public void insertListEmployeeNoIdBatis(){
    	 employeesjService1.insertListEmployeeNoIdBatis();
    }
    @GetMapping("/api/db1/insertListEmployeeIdBatis")
    public void insertListEmployeeIdBatis(){
    	 employeesjService1.insertListEmployeeIdBatis();
    }
    @GetMapping("/api/db1/getAllEm1JPA")
    public List<Employeej1> getAllEm1JPA(){
    	return employeesjService1.getAllEm1JPA();
    }
    //batis
    
    @GetMapping("/api/db1/getAllEm1Batis")
    public List<Employeej1> getAllEm1Batis(){
    	return employeesjService1.getAllEm1Batis();
    }
    
    @GetMapping("/api/db1/findByIdBatis/{id}")
    public Employeej1 findByIdBatis(long id){
    	return employeesjService1.findByIdBatis(id);
    }
    
    //
    @GetMapping("/api/db2/getAllEm2")
    public List<Employeej2> getAllEm2(){
    	return employeesjService2.getAllEm2();
    }
}
