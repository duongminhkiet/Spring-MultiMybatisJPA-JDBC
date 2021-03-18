package com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.model.Employeej2;

@Repository
public interface EmployeesjRepository2 extends JpaRepository<Employeej2,Integer> {
}
