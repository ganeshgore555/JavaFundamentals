package com.main;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
	String name;
	Integer age;
	LocalDate dateOfBirth;
	
	@Override
	public int hashCode() {
		return Objects.hash(age, dateOfBirth, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(age, other.age) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(name, other.name);
	}
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
