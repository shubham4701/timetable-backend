package com.fabassignment.timetable.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String classCode;
	private String className;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicClass", cascade = CascadeType.ALL)
	private List<Section> sections = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicClass", cascade = CascadeType.ALL)
	private List<Subject> subjects = new ArrayList<>();

	public AcademicClass(String code, String name) {
		this.classCode = code;
		this.className = name;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder(
				String.format("AcademicClass[id=%d, classCode='%s', className='%s']", id, classCode, className));
		if (sections.size() > 0) {
			for (Section section : sections) {
				result.append(String.format("Section[id=%d, code='%s', name='%s']%n", section.getId(),
						section.getSectionCode(), section.getSectionName()));
			}
		}
		if (subjects.size() > 0) {
			for (Subject subject : subjects) {
				result.append(String.format("Subject[id=%d, code='%s', name='%s']%n", subject.getId(),
						subject.getSubjectCode(), subject.getSubjectName()));
			}
		}
		return result.toString();
	}

}
