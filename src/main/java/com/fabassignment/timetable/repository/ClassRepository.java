package com.fabassignment.timetable.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabassignment.timetable.entities.AcademicClass;

@Repository
public interface ClassRepository extends CrudRepository<AcademicClass, Long> {
	List<AcademicClass> findByClassCode(String classCode);

	List<AcademicClass> findByClassName(String className);
}
