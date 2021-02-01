package com.gmail.oastro36;

import java.util.Optional;

import javax.swing.JOptionPane;

public class Main {

	public static Student[] creatStudentsArray(Group gr) {
		Student stOne = new Student("Qwe", "Wer", "Ert", 18, true, gr.getGroupName(), 2);
		Student stTwo = new Student("Rty", "Tyu", "Yui", 19, true, gr.getGroupName(), 3);
		Student stThree = new Student("Uio", "Iop", "Asd", 17, false, gr.getGroupName(), 7);
		Student stFour = new Student("Sdf", "Dfg", "Fgh", 17, true, gr.getGroupName(), 1);
		Student stFive = new Student("Ghj", "Hjk", "Jkl", 20, false, gr.getGroupName(), 8);
		Student stSix = new Student("Zxc", "Xcv", "Cvb", 18, true, gr.getGroupName(), 6);
		Student stSeven = new Student("Vbn", "Bnm", "Ewq", 19, true, gr.getGroupName(), 10);
		Student stEight = new Student("Rew", "Tre", "Ytr", 20, true, gr.getGroupName(), 4);
		Student stNine = new Student("Uyt", "Iuy", "Oiu", 17, false, gr.getGroupName(), 9);
		Student stTen = new Student("Poi", "Dsa", "Fds", 18, true, gr.getGroupName(), 5);
		Student[] studentsArray = new Student[] { stOne, stTwo, stThree, stFour, stFive, stSix, stSeven, stEight,
				stNine, stTen };
		return studentsArray;
	}

	public static void main(String[] args) {
		Group gr = new Group("ST-91");
		Student[] studentsArray = creatStudentsArray(gr);
		fillingArray(studentsArray, gr);
//		Student stEleven = new Student("Gfd", "Hgf", "Jhg", 18, true, gr.getGroupName(), 11);
//		fillingArray(stEleven, gr); //try add 11-th student
		int delStudentsByNumberZach = 7;
		delStudentByZach(gr.delStudent(delStudentsByNumberZach), delStudentsByNumberZach);
		System.out.println(gr);
		InteractiveAddStudent ias = new InteractiveAddStudent(gr);
		try {
		ias.interactiveGetStudent();
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Calceled!");
		}
		System.out.println(gr);
		Optional<Student> resultFound = gr.findStudentByLastNameOptional("Dfg");
		if (resultFound.isPresent()) {
			Student st = resultFound.get();
			System.out.println(st + System.lineSeparator());
		} else {
			System.out.println("Studetn is not exist!");
		}
//		gr.sortByLastName(); // sort by lastname
		gr.sortByParameter(3, -1); // Sorted by: (0 - name, 1 - lastname, 2 - surename, 3 - by age)// (1 - ascending, -1 descending)
		System.out.println(gr);
		Voenkom v = gr; // 
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
			System.out.println("Student is fired");
			System.out.println();
		} else {
			System.out.println("Student with id: " + zach + " is not found!");
			System.out.println();
		}
	}

	public static void goToArmy(Student[] array) {
		for (Student student : array) {
			System.out.println("Student to army NOW: " + student);
		}
	}
}