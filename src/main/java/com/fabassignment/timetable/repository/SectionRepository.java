package com.fabassignment.timetable.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabassignment.timetable.entities.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
	List<Section> findBySectionCode(String sectionCode);

	List<Section> findBySectionName(String sectionName);
}
