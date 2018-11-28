package com.fabassignment.timetable.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabassignment.timetable.entities.AcademicClass;
import com.fabassignment.timetable.repository.ClassRepository;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	ClassRepository repo;

	@GetMapping("/")
	public Iterable<AcademicClass> getClasses() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public AcademicClass getClass(@PathVariable(value = "id") Long id) {
		Optional<AcademicClass> data = repo.findById(id);
		return data.orElseThrow(NoSuchElementException::new);
	}

	@PostMapping()
	public AcademicClass createClass(String code, String name) {
		return repo.save(new AcademicClass(code, name));
	}

}
