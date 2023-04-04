package com.main;

import java.time.LocalDate;

public class Person {
	String name;
	Integer age;
	LocalDate dateOfBirth;
	
	public Person(String name, Integer age, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
