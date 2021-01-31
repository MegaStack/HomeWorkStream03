package com.gmail.oastro36;

import java.util.Comparator;

public class ComparatorOfStudents implements Comparator {
	private int typeSorting;// 0 - по імені, 1 - по прізвищу, 2 - по батькові, 3 - по віку
	private int direction;// 1 - сортування по зростанню, -1 - по спаданню
	
	public ComparatorOfStudents(int typeSorting, int direction) {
		super();
		this.typeSorting = typeSorting;
		this.direction = direction;
	}
	
	@Override
	public int compare(Object stOne, Object stTwo) {
		if (stOne == null && stTwo == null) {
			return 0;
		}
		if (stOne != null && stTwo == null) {
			return 1;
		}
		if (stOne == null && stTwo != null) {
			return -1;
		}
		Student studentOne = (Student) stOne;
		Student studentTwo = (Student) stTwo;
		switch (typeSorting) {
		case 0:
			return studentOne.getName().compareToIgnoreCase(studentTwo.getName()) * direction;
		case 1:
			return studentOne.getLastName().compareToIgnoreCase(studentTwo.getLastName()) * direction;
		case 2:
			return studentOne.getSureName().compareToIgnoreCase(studentTwo.getSureName()) * direction;
		case 3:
			if (studentOne.getAge() > studentTwo.getAge()) {
				return 1 * direction;
			}
			if (studentOne.getAge() < studentTwo.getAge()) {
				return -1 * direction;
			}
			if(studentOne.getAge() == studentTwo.getAge()) {
				return 0;
			}		
		}
		return 0;
	}

}
