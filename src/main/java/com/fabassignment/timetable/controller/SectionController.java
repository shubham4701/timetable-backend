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
import com.fabassignment.timetable.entities.Section;
import com.fabassignment.timetable.repository.ClassRepository;
import com.fabassignment.timetable.repository.SectionRepository;

@RestController
@RequestMapping("/section")
public class SectionController {

	@Autowired
	SectionRepository repo;

	@Autowired
	ClassRepository classRepository;

	@GetMapping("/")
	public Iterable<Section> getSectiones() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Section getSection(@PathVariable(value = "id") Long id) {
		Optional<Section> data = repo.findById(id);
		return data.orElseThrow(NoSuchElementException::new);
	}

	@PostMapping()
	public Section createSection(Long classId, String code, String name) throws Exception {
		Optional<com.fabassignment.timetable.entities.Class> class1 = classRepository.findById(classId);
		if (class1.isPresent()) {
			Class data = class1.get();
			List<Section> sections = data.getSections();
			Section section = repo.save(new Section(code, name));
			sections.add(section);
			classRepository.save(data);
			return section;
		}
		throw new Exception("No such class exist");
	}

}
