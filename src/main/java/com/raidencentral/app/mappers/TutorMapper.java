package com.raidencentral.app.mappers;

import com.raidencentral.app.domain.Tutor;

/**
 * @author Siva
 *
 */
public interface TutorMapper
{

	Tutor selectTutorWithCourses(int tutorId);
	
	Tutor selectTutorById(int tutorId);
	
}
