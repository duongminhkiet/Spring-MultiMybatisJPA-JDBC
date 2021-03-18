package com.zmk.spring.test.rd.multidb.mybatisjpa1.p2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zmk.spring.test.rd.multidb.mybatisjpa1.helper.GlobalVariable;

@Entity
@Table(name = GlobalVariable.TBL_EMPLOYEESJ2)
public class Employeej2 {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String des;
 
    public Employeej2() {
  
    }
 
    public Employeej2(long id, String firstName, String lastName, String emailId, String des) {
        this.id = id; 
    	this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
         this.des = des;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    @Column(name = "des", nullable = true)
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
       +", des=" + des
       + "]";
    }
 
}
