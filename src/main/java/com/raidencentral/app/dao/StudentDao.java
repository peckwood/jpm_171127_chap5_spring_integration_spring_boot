package com.raidencentral.app.dao;

import com.raidencentral.app.domain.Student;

public interface StudentDao {

	void createStudent(Student student);

	Student selectStudentById(Integer studId);

}
