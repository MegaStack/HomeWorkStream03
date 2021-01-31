package com.gmail.oastro36;

import java.util.Optional;

import javax.swing.JOptionPane;

public class Main {

	public static Student[] creatStudentsArray(Group gr) {
		Student stOne = new Student("��", "���", "���", 18, true, gr.getGroupName(), 2);
		Student stTwo = new Student("��", "���", "���", 19, true, gr.getGroupName(), 3);
		Student stThree = new Student("ó�", "���", "���", 17, false, gr.getGroupName(), 7);
		Student stFour = new Student("��", "���", "���", 17, true, gr.getGroupName(), 1);
		Student stFive = new Student("���", "���", "���", 20, false, gr.getGroupName(), 8);
		Student stSix = new Student("���", "���", "���", 18, true, gr.getGroupName(), 6);
		Student stSeven = new Student("��", "���", "���", 19, true, gr.getGroupName(), 10);
		Student stEight = new Student("���", "���", "���", 20, true, gr.getGroupName(), 4);
		Student stNine = new Student("��", "���", "���", 17, false, gr.getGroupName(), 9);
		Student stTen = new Student("��", "���", "���", 18, true, gr.getGroupName(), 5);
		Student[] studentsArray = new Student[] { stOne, stTwo, stThree, stFour, stFive, stSix, stSeven, stEight,
				stNine, stTen };
		return studentsArray;
	}

	public static void main(String[] args) {
		Group gr = new Group("��-91");
		Student[] studentsArray = creatStudentsArray(gr);
		fillingArray(studentsArray, gr);
//		Student stEleven = new Student("����", "������", "��������", 18, true, gr.getGroupName(), 11);
//		fillingArray(stEleven, gr);//���������� 11-�� ��������
		int delStudentsByNumberZach = 7;
		delStudentByZach(gr.delStudent(delStudentsByNumberZach), delStudentsByNumberZach);
		System.out.println(gr);
		InteractiveAddStudent ias = new InteractiveAddStudent(gr);
		try {
		ias.interactiveGetStudent();
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "³���� �������� ��� ����������� ������ ��������!");
		}
		System.out.println(gr);
		Optional<Student> resultFound = gr.findStudentByLastNameOptional("���");
		if (resultFound.isPresent()) {
			Student st = resultFound.get();
			System.out.println(st + System.lineSeparator());
		} else {
			System.out.println("���� �������� � ����� ������!");
		}
//		gr.sortByLastName();//����������� �� �������
		gr.sortByParameter(3, -1); // ���������� (0 - �� ������, 1 - �� ��������, 2 - �� ���������, 3 - �� ����)// (1 - �� ���������, -1 �� ��������)
		System.out.println(gr);
		Voenkom v = gr; // ��������� ���������� � ��������� ���� ���������� �����
		Student[] studentsToArmy = v.toArmy();
		goToArmy(studentsToArmy);		
		SaveGroupToFile.readGroup(gr);		
	}

	public static void fillingArray(Student student, Group g) {
		try {
			g.addStudent(student);
		} catch (EleventhStudentExeption e) {
			System.out.println(e.getMessage());
		}
	}

	public static void fillingArray(Student[] array, Group g) {
		for (Student student : array) {
			try {
				g.addStudent(student);
			} catch (EleventhStudentExeption e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void delStudentByZach(boolean res, int zach) {
		if (res == true) {
			System.out.println("������� �����������");
			System.out.println();
		} else {
			System.out.println("�������� � ������� ��������: " + zach + " �� ��������");
			System.out.println();
		}
	}

	public static void goToArmy(Student[] array) {
		for (Student student : array) {
			System.out.println("�� �������� ������: " + student);
		}
	}
}
