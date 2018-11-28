package com.fabassignment.timetable.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabassignment.timetable.entities.Class;
import com.fabassignment.timetable.repository.ClassRepository;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	ClassRepository repo;

	@GetMapping("/")
	public Iterable<Class> getClasses() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Class getClass(@PathVariable(value = "id") Long id) {
		Optional<Class> data = repo.findById(id);
		return data.orElseThrow(NoSuchElementException::new);
	}

	@PostMapping()
	public Class createClass(String code, String name) {
		return repo.save(new Class(code, name));
	}

}
