package com.raidencentral.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raidencentral.app.domain.Student;
import com.raidencentral.app.mappers.StudentMapper;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}

	@Override
	public void createStudent(Student student) {
		StudentMapper mapper = this.sqlSession.getMapper(StudentMapper.class);
		mapper.insertStudent(student);
	}
	
	@Override
	public Student selectStudentById(Integer studId){
		StudentMapper mapper = this.sqlSession.getMapper(StudentMapper.class);
		return mapper.selectStudentWithAddress(studId);
	}
}
