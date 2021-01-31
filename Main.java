package com.gmail.oastro36;

import java.util.Optional;

import javax.swing.JOptionPane;

public class Main {

	public static Student[] creatStudentsArray(Group gr) {
		Student stOne = new Student("Аві", "Нвп", "Уоб", 18, true, gr.getGroupName(), 2);
		Student stTwo = new Student("Нві", "Ийп", "Лкб", 19, true, gr.getGroupName(), 3);
		Student stThree = new Student("Гіі", "Роп", "Ячб", 17, false, gr.getGroupName(), 7);
		Student stFour = new Student("Ені", "Лзп", "Тнб", 17, true, gr.getGroupName(), 1);
		Student stFive = new Student("Щші", "Рдп", "Еиб", 20, false, gr.getGroupName(), 8);
		Student stSix = new Student("Цчі", "Штп", "Адб", 18, true, gr.getGroupName(), 6);
		Student stSeven = new Student("Имі", "Вап", "Лоб", 19, true, gr.getGroupName(), 10);
		Student stEight = new Student("Зьі", "Нип", "Учб", 20, true, gr.getGroupName(), 4);
		Student stNine = new Student("Длі", "Укп", "Гнб", 17, false, gr.getGroupName(), 9);
		Student stTen = new Student("Мсі", "Тип", "Счб", 18, true, gr.getGroupName(), 5);
		Student[] studentsArray = new Student[] { stOne, stTwo, stThree, stFour, stFive, stSix, stSeven, stEight,
				stNine, stTen };
		return studentsArray;
	}

	public static void main(String[] args) {
		Group gr = new Group("СТ-91");
		Student[] studentsArray = creatStudentsArray(gr);
		fillingArray(studentsArray, gr);
//		Student stEleven = new Student("Саша", "Иванов", "Петрович", 18, true, gr.getGroupName(), 11);
//		fillingArray(stEleven, gr);//добавление 11-го студента
		int delStudentsByNumberZach = 7;
		delStudentByZach(gr.delStudent(delStudentsByNumberZach), delStudentsByNumberZach);
		System.out.println(gr);
		InteractiveAddStudent ias = new InteractiveAddStudent(gr);
		try {
		ias.interactiveGetStudent();
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Відміна введення або некоректний формат введення!");
		}
		System.out.println(gr);
		Optional<Student> resultFound = gr.findStudentByLastNameOptional("Лзп");
		if (resultFound.isPresent()) {
			Student st = resultFound.get();
			System.out.println(st + System.lineSeparator());
		} else {
			System.out.println("Немає студента з таким іменем!");
		}
//		gr.sortByLastName();//всортировка по фамилии
		gr.sortByParameter(3, -1); // Сортування (0 - за іменем, 1 - за прізвищем, 2 - за побатькові, 3 - за віком)// (1 - по зростанню, -1 по спаданню)
		System.out.println(gr);
		Voenkom v = gr; // Створення інтерфейсу і присвоєння йому єкземпляру групи
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
			System.out.println("Студент відрахований");
			System.out.println();
		} else {
			System.out.println("Студента з номером заліковки: " + zach + " не знайдено");
			System.out.println();
		}
	}

	public static void goToArmy(Student[] array) {
		for (Student student : array) {
			System.out.println("До строкової служби: " + student);
		}
	}
}
