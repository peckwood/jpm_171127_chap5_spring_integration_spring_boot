package com.raidencentral.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raidencentral.app.dao.StudentDao;
import com.raidencentral.app.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	//@Transactional
	public void insertStudent(Student student) {
		studentDao.createStudent(student);
		int a = 1/0;
	}
	
	@Override
	public Student selectStudentById(Integer studId){
		return studentDao.selectStudentById(studId);
	}

}
