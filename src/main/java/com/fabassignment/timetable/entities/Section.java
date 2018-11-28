package com.fabassignment.timetable.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String sectionCode;
	private String sectionName;

	@ManyToOne(fetch = FetchType.LAZY)
	private AcademicClass academicClass;

	public Section(String code, String name) {
		this.sectionCode = code;
		this.sectionName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Section[id=%d, sectionCode='%s', sectionName='%s']", id, sectionCode, sectionName);
	}
}
