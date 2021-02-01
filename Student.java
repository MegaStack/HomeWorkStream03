package com.gmail.oastro36;

public class Student extends Human{
	private String groupName;
	private int zachNumber;

	public Student(String name, String lastName, String sureName, int age, boolean sex, String groupName, int zachNumber) {
		super(name, lastName, sureName, age, sex);
		this.groupName = groupName;
		this.zachNumber = zachNumber;
	}

	public Student() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getZachNumber() {
		return zachNumber;
	}

	public void setZachNumber(int zachNumber) {
		this.zachNumber = zachNumber;
	}

	@Override
	public String toString() {
		return super.toString() + " group name: " + groupName + ", id: " + zachNumber;
	}	
}