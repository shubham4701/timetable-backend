package com.fabassignment.timetable.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabassignment.timetable.entities.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
	List<Subject> findBySubjectCode(String subjectCode);

	List<Subject> findBySubjectName(String subjectName);
}
