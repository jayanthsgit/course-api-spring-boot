package io.spring.boot.practice.lesson;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> courses = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Lesson> getLesson(String id) {
		return lessonRepository.findById(id);
	}
	
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}
	
	public void updateLesson(String id, Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
	}
}

