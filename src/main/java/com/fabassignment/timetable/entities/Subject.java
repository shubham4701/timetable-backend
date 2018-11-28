package com.fabassignment.timetable.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String subjectCode;
	private String subjectName;

	@ManyToOne(fetch = FetchType.LAZY)
	private AcademicClass academicClass;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Teacher.class, mappedBy = "subject", cascade = CascadeType.ALL)
	List<Teacher> teachers;

	public Subject(String subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + "]";
	}

}
