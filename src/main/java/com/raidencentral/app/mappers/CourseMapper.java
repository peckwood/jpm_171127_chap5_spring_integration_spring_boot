package com.raidencentral.app.mappers;

import java.util.List;
import java.util.Map;

import com.raidencentral.app.domain.Course;

/**
 * @author Siva
 *
 */
public interface CourseMapper
{

	List<Course> selectCoursesByTutor(int tutorId);

	List<Course> searchCourses(Map<String, Object> map);

	List<Course> searchCoursesByTutors(Map<String, Object> map);

}
