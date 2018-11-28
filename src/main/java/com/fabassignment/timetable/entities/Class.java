package com.fabassignment.timetable.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String classCode;
	private String className;

	public Class(String code, String name) {
		this.classCode = code;
		this.className = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Class[id=%d, classCode='%s', className='%s']", id, classCode, className);
	}

}
