package com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.model.Employeej2;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.repository.EmployeesjRepository2;

@Service
public class EmployeesjService2 {
	@Autowired 
	private EmployeesjRepository2 employeesjRepository2;
	public List<Employeej2> getAllEm2(){
		return employeesjRepository2.findAll();
	}
}
