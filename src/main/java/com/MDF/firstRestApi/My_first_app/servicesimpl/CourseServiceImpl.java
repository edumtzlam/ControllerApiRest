package com.MDF.firstRestApi.My_first_app.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.MDF.firstRestApi.My_first_app.exception.CourseApiException;
import com.MDF.firstRestApi.My_first_app.models.Course;
import com.MDF.firstRestApi.My_first_app.services.ICourseService;

@Component
public class CourseServiceImpl implements ICourseService {

	private List<Course> courseList = new ArrayList<>();

	@Override
	public Course saveCourse(Course course) {
		if (courseList.isEmpty())
			course.setId(1);
		else
			course.setId(courseList.get(courseList.size() - 1).getId() + 1);

		if (courseList.stream().filter(_course -> _course.getName().equals(course.getName())).findFirst().isPresent()) {
			throw new CourseApiException(HttpStatus.BAD_REQUEST, "Error al agregar el curso");
		}
		this.courseList.add(course);
		return course;
	}

	@Override
	public Course getCourse(String pName) {
		if (pName == null)
			throw new CourseApiException(HttpStatus.OK, "it's neccesary the CourseName param to execute the serach");

		if (pName.isEmpty())
			throw new CourseApiException(HttpStatus.OK, "the CourseName don't have value.");

		return this.courseList.stream().filter(_course -> _course.getName().contains(pName)).findFirst().orElseThrow(
				() -> new CourseApiException(HttpStatus.NO_CONTENT, "Did not find course with the name provide"));
	}

	@Override
	public List<Course> getAllCourse(int from, int limit) {
		return this.courseList.stream().skip(from).limit(limit).toList();
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course deleteCourse(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
