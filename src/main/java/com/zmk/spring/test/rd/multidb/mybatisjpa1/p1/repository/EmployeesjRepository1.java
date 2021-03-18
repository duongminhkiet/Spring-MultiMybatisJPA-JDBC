package com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.model.Employeej1;

@Repository
public interface EmployeesjRepository1 extends JpaRepository<Employeej1,Integer> {
}
