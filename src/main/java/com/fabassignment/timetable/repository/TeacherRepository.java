package com.fabassignment.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabassignment.timetable.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
