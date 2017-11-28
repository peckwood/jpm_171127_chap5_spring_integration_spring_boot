package com.raidencentral.app.service;

import com.raidencentral.app.domain.Student;

public interface StudentService {
	void insertStudent(Student student);

	Student selectStudentById(Integer studId);
}
