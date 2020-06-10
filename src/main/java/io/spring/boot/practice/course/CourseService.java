package io.spring.boot.practice.course;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllcourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getcourse(String id) {
		return courseRepository.findById(id);
	}
	
	public void addcourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updatecourse(String id, Course course) {
		courseRepository.save(course);
	}

	public void deletecourse(String id) {
		courseRepository.deleteById(id);
	}
}

