package com.gmail.oastro36;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGroupToFile {

	public SaveGroupToFile() {
		super();
	}

	public static void readGroup(Group group) {
		Student[] student = group.getGroupStudents();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < student.length; i++) {
			if (i < student.length - 1) {
				sb.append("" + student[i].getName() + " ");
				sb.append("" + student[i].getLastName() + " ");
				sb.append("" + student[i].getSureName() + " ");
				sb.append("" + student[i].getAge() + " ");
				sb.append("" + ((student[i].isSex()) ? "m" : "w") + " ");
				sb.append("" + student[i].getGroupName() + " ");
				sb.append("" + student[i].getZachNumber());
				sb.append(System.lineSeparator());
			} else {
				sb.append("" + student[i].getName() + " ");
				sb.append("" + student[i].getLastName() + " ");
				sb.append("" + student[i].getSureName() + " ");
				sb.append("" + student[i].getAge() + " ");
				sb.append("" + ((student[i].isSex()) ? "m" : "w") + " ");
				sb.append("" + student[i].getGroupName() + " ");
				sb.append("" + student[i].getZachNumber());
			}
		}

		saveToFile(sb.toString());
	}

	private static void saveToFile(String group) {
		File file = new File("fileGruop.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(group);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}