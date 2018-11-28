package com.fabassignment.timetable.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabassignment.timetable.entities.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
	List<Class> findByClassCode(String classCode);

	List<Class> findByClassName(String className);
}
