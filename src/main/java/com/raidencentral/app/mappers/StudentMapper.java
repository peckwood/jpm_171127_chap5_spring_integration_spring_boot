package com.raidencentral.app.mappers;

import java.util.List;
import java.util.Map;

import com.raidencentral.app.domain.Student;

/**
 * @author Siva
 *
 */
public interface StudentMapper
{

	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	Student selectStudentWithAddress(int id);
	
	void insertStudent(Student student);
	
	void insertStudentWithMap(Map<String, Object> map);

	void updateStudent(Student student);
	
	int deleteStudent(int id);
	
}
