package com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.batis.repository.Employee1MyBatisRepository;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.model.Employeej1;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.repository.EmployeesjRepository1;

@Service
public class EmployeesjService1 {
	@Autowired 
	private EmployeesjRepository1 employeesjRepository1;
	
	@Autowired 
	private Employee1MyBatisRepository employee1MyBatisRepository;
	
	
	public List<Employeej1> getAllEm1JPA(){
		return employeesjRepository1.findAll();
	}
	
	public Employeej1 saveJPA(Employeej1 e) {
		return employeesjRepository1.save(e);
	}
	//
	
	
	public List<Employeej1> getAllEm1Batis(){
		return employee1MyBatisRepository.findAll();
	}
	public Employeej1 findByIdBatis(long id) {
		return employee1MyBatisRepository.findById(id);
	}
	public int deleteByIdBatis(long id) {
		return employee1MyBatisRepository.deleteById(id);
	}
	public int saveWithoutIdBatis(Employeej1 employee) {
		return employee1MyBatisRepository.insertWithoutId(employee);
	}
	
	
//	@Transactional("sqlServer1TransactionMybatis")//=> fail all
	public void insertListEmployeeNoIdBatis() {
		List<Employeej1> employees = Arrays.asList(
				new Employeej1("1emailx1Batis@email.com", "firstname1", "lastname1"),
				new Employeej1("1emailx2Batis@email.com", "firstname2", "lastname2"),
				new Employeej1("1emailx3Batis@email.com", "firstname3", "lastname3"),
				new Employeej1("1emailx4Batis@email.com", "firstname4", "lastname4"));

		employees.forEach(employee -> {
			employee1MyBatisRepository.insertWithoutId(employee);
		});
    }
	public void insertListEmployeeIdBatis() {
		List<Employeej1> employees = Arrays.asList(
				new Employeej1(2001L,"1Batisemailx1@email.com", "firstname1", "lastname1"),
				new Employeej1(2002L,"1Batisemailx2@email.com", "firstname2", "lastname2"),
				new Employeej1(2003L,"1Batisemailx3@email.com", "firstname3", "lastname3"),
				new Employeej1(2004L,"1Batisemailx4@email.com", "firstname4", "lastname4"));

		employees.forEach(employee -> {
			employee1MyBatisRepository.insert(employee);
		});
    }
	public void insertListEmployeeNoIdJPA() {
		List<Employeej1> employees = Arrays.asList(
				new Employeej1("1emailx1JPA@email.com", "firstname1", "lastname1"),
				new Employeej1("1emailx2JPA@email.com", "firstname2", "lastname2"),
				new Employeej1("1emailx3JPA@email.com", "firstname3", "lastname3"),
				new Employeej1("1emailx4JPA@email.com", "firstname4", "lastname4"));

		employees.forEach(employee -> {
			employeesjRepository1.save(employee);
		});
    }
	public void insertListEmployeeIdJPA() {
		List<Employeej1> employees = Arrays.asList(
				new Employeej1(1001L,"1emailx1JPA@email.com", "firstname1", "lastname1"),
				new Employeej1(1002L,"1emailx2JPA@email.com", "firstname2", "lastname2"),
				new Employeej1(1003L,"1emailx3JPA@email.com", "firstname3", "lastname3"),
				new Employeej1(1004L,"1emailx4JPA@email.com", "firstname4", "lastname4"));

		employees.forEach(employee -> {
			employeesjRepository1.save(employee);
		});
    }
}
