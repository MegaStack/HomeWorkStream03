package com.gmail.oastro36;

import java.util.Arrays;
import java.util.Optional;

public class Group implements Voenkom{
	private Student[] groupStudents = new Student[10];
	private String groupName;

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Student[] getGroupStudents() {
		return groupStudents;
	}

	public Optional<Student> findStudentByLastNameOptional(String lastName) {
		Student foundStudent = null;
		for (int i = 0; i < groupStudents.length; i++) {
			if ((groupStudents[i] != null) && (groupStudents[i].getLastName()).equals(lastName)) {
				foundStudent = groupStudents[i];
				break;
			}
		}
		return Optional.ofNullable(foundStudent);
	}
	
	public void addStudent(Student student) throws EleventhStudentExeption {
		for (int i = 0; i < groupStudents.length; i++) {
			if (groupStudents[i] == null) {
				groupStudents[i] = student;
				return;
			}
		}
		throw new EleventhStudentExeption();
	}

	public boolean delStudent(int zach) {
		boolean resultDel = false;
		for (int i = 0; i < groupStudents.length; i++) {
			if ((groupStudents[i] != null) && (groupStudents[i].getZachNumber()) == zach) {
				groupStudents[i] = null;
				resultDel = true;
			} 
		}
		return resultDel;
	}
	
	public void sortByParameter(int parOne, int parTwo) {
		Arrays.sort(groupStudents, new ComparatorOfStudents(parOne, parTwo));
	}

	private int sort(Student a, Student b) {
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return a.getLastName().compareToIgnoreCase(b.getLastName());
	}

	public void sortByLastName() {
		for (int i = 0; i < groupStudents.length - 1; i++) {
			for (int j = groupStudents.length - 1; j > i; j--) {
				int s = sort(groupStudents[j - 1], groupStudents[j]);
				if (s > 0) {
					Student tmp = groupStudents[j - 1];
					groupStudents[j - 1] = groupStudents[j];
					groupStudents[j] = tmp;
				}
			}
		}
	}
	
	@Override
	public Student[] toArmy() {
		int count = 0;
		for (int i = 0; i < groupStudents.length; i++) {
			if (groupStudents[i] != null && groupStudents[i].isSex() && groupStudents[i].getAge() >= 18) {
				count += 1;
			}
		}

		Student[] arrayToArmy = new Student[count];
		int flag = 0;
		for (int i = 0; i < groupStudents.length; i++) {
			if (groupStudents[i] != null && groupStudents[i].isSex() && groupStudents[i].getAge() >= 18) {
				arrayToArmy[flag] = groupStudents[i];
				flag += 1;
			}
		}
		return arrayToArmy;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("√рупа є " + this.groupName + System.lineSeparator());
		for (int i = 0; i < groupStudents.length; i++) {
			if (groupStudents[i] == null) {
				sb.append(i + 1 + ") ");
				sb.append("в≥льне м≥сце");
				sb.append(System.lineSeparator());
			} else {
				sb.append(i + 1 + ") ");
				sb.append(groupStudents[i].toString());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}