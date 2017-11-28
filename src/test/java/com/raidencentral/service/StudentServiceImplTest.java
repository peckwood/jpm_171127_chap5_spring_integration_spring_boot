package com.raidencentral.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raidencentral.app.dao.StudentDao;
import com.raidencentral.app.domain.Address;
import com.raidencentral.app.domain.PhoneNumber;
import com.raidencentral.app.domain.Student;
import com.raidencentral.app.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:applicationContext-mixed.xml")
//@ContextConfiguration(locations="classpath:applicationContext-minimum.xml")
@ContextConfiguration(locations={
	"classpath:applicationContext-minimum-with-trans.xml",
	"classpath:applicationContext-trans.xml"})
public class StudentServiceImplTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testSeletStudentById(){
		int studId= 2;
		Student student = studentService.selectStudentById(studId);
		System.out.println("student: " + student);
	}
	
	@Test
	public void testInsertStudent(){
		Student student = new Student();
		student.setStudId(2);
		Address add = new Address(1);
		student.setAddress(add);
		student.setEmail("a@a.com");
		student.setName("Raptor");
		PhoneNumber phone = new PhoneNumber("123-123-4444"); 
		student.setPhone(phone);
		studentService.insertStudent(student);
	}
}
