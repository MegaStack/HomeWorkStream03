package com.gmail.oastro36;

public class Human {
	private String name;
	private String lastName;
	private String sureName;
	private int age;
	private boolean sex;

	public Human(String name, String lastName, String sureName, int age, boolean sex) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.sureName = sureName;
		this.age = age;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "name: " + name + ", lastname: " + lastName + ", surename: " + sureName + ", age: " + age + ", sex: " + this.isSex() + ",";
	}
	
	
}