package com.fabassignment.timetable.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabassignment.timetable.entities.Class;
import com.fabassignment.timetable.entities.Subject;
import com.fabassignment.timetable.repository.ClassRepository;
import com.fabassignment.timetable.repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectRepository repo;

	@Autowired
	ClassRepository classRepository;

	@GetMapping("/")
	public Iterable<Subject> getSubjectes() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Subject getSubject(@PathVariable(value = "id") Long id) {
		Optional<Subject> data = repo.findById(id);
		return data.orElseThrow(NoSuchElementException::new);
	}

	@PostMapping()
	public Subject createSubject(Long classId, String code, String name) throws Exception {
		Optional<com.fabassignment.timetable.entities.Class> class1 = classRepository.findById(classId);
		if (class1.isPresent()) {
			Class data = class1.get();
			List<Subject> subjects = data.getSubjects();
			Subject subject = repo.save(new Subject(code, name));
			subjects.add(subject);
			classRepository.save(data);
			return subject;
		}
		throw new Exception("No such class exist");
	}

}
