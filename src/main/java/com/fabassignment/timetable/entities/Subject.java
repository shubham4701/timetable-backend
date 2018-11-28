package com.fabassignment.timetable.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String subjectCode;
	private String subjectName;

	public Subject(String subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + "]";
	}

}
