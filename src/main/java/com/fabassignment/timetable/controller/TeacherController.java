package com.fabassignment.timetable.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabassignment.timetable.entities.Teacher;
import com.fabassignment.timetable.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	Logger logger = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	private TeacherRepository repo;

	@GetMapping()
	public Iterable<Teacher> getAllTeachers() {
		logger.info("in get all method");
		return repo.findAll();
	}

	@GetMapping(value = "/{id}")
	public Teacher getTeacherByID(@PathVariable(value = "id") Long id) {
		Optional<Teacher> teacher = repo.findById(id);
		return teacher.orElseThrow(NoSuchElementException::new);
	}

	@PostMapping()
	public Teacher createTeacher(String firstName, String lastName) {
		return repo.save(new Teacher(firstName, lastName));
	}

}
