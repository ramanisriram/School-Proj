package com.js.school.service;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.js.school.dao.Student;

public class SchoolJPAService {
	private static final EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory("SchoolJPA");	
	private static final EntityManager entityMgr = getInstance();
	
	public static EntityManager getInstance() {
		return emFactoryObj.createEntityManager();
	}
	
	public SchoolJPAService() {
		
	}
	
	public static void main(String[] args) {
		 
        entityMgr.getTransaction().begin();
 
        Student studentObj = new Student();
        studentObj.setId(new BigDecimal(101));
        studentObj.setName("Sriram");
        entityMgr.persist(studentObj);
 
        entityMgr.getTransaction().commit();
 
        entityMgr.clear();
        System.out.println("Record Successfully Inserted In The Database");
    }
}