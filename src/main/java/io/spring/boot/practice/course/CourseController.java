package io.spring.boot.practice.course;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.boot.practice.topic.Topic;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllcourses(@PathVariable String topicId) {
		return courseservice.getAllcourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getcourse(@PathVariable String id) {
		return courseservice.getcourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addcourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseservice.addcourse(course);
		
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updatecourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseservice.updatecourse(id, course);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deletecourse(@PathVariable String id) {
		courseservice.deletecourse(id);
	}
}
