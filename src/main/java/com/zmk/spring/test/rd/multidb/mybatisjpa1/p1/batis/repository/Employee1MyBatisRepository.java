package com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.batis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.helper.GlobalVariable;
import com.zmk.spring.test.rd.multidb.mybatisjpa1.p1.model.Employeej1;

@Mapper
public interface Employee1MyBatisRepository {
	@Select("select * from "+GlobalVariable.TBL_EMPLOYEESJ1)
    public List < Employeej1 > findAll();

    @Select("SELECT * FROM "+GlobalVariable.TBL_EMPLOYEESJ1+" WHERE id = #{id}")
    public Employeej1 findById(long id);

    @Delete("DELETE FROM "+GlobalVariable.TBL_EMPLOYEESJ1+" WHERE id = #{id}")
    public int deleteById(long id);

    @Insert(
//    		"SET IDENTITY_INSERT "+GlobalVariable.TBL_EMPLOYEESJ1+" ON; "+
    "INSERT INTO "+GlobalVariable.TBL_EMPLOYEESJ1+"(id, first_name, last_name,email_address) " +
        " VALUES (#{id}, #{firstName}, #{lastName}, #{emailId}); "
//    +"SET IDENTITY_INSERT "+GlobalVariable.TBL_EMPLOYEESJ1+" OFF;"
    )
    public int insert(Employeej1 employee);
    
    
    @Insert("INSERT INTO "+GlobalVariable.TBL_EMPLOYEESJ1+"(first_name, last_name,email_address) " +
        " VALUES (#{firstName}, #{lastName}, #{emailId}); ")
    public int insertWithoutId(Employeej1 employee);

    @Update("Update "+GlobalVariable.TBL_EMPLOYEESJ1+" set first_name=#{firstName}, " +
        " last_name=#{lastName}, email_address=#{emailId} where id=#{id}")
    public int update(Employeej1 employee);
}
