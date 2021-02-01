package com.gmail.oastro36;

import javax.swing.JOptionPane;

public class InteractiveAddStudent {
	private Group gr;

	public InteractiveAddStudent(Group gr) {
		super();
		this.gr = gr;
	}

	public InteractiveAddStudent() {
		super();
	}
	
	private boolean interactiveGetSex(String text) throws IllegalArgumentException {
		boolean sex = true;
		SexEnum se = SexEnum.valueOf(JOptionPane.showInputDialog(text));
		switch (se.ordinal()) {
		case 0:
			sex = true;
			break;
		case 1:
			sex = true;
			break;
		case 2:
			sex = false;
			break;
		case 3:
			sex = false;
		default:
			throw new IllegalArgumentException();
		}
		return sex;
	}
	
	public void interactiveGetStudent() throws NullPointerException{
		Student student = null;
		try {
			String name = JOptionPane.showInputDialog("Input name");
			if(name == null) {
				throw new NullPointerException();
			}
			String lastName = JOptionPane.showInputDialog("Input lastname");
			if(lastName == null) {
				throw new NullPointerException();
			}
			String sureName = JOptionPane.showInputDialog("Input surename");
			if(sureName == null) {
				throw new NullPointerException();
			}
			int age = Integer.valueOf(JOptionPane.showInputDialog("Input age"));
			boolean sex = interactiveGetSex("Input sex: m/w (m - man, w - woman)");
			int zachNumber = Integer.valueOf(JOptionPane.showInputDialog("Input zach number"));
			student = new Student(name, lastName, sureName, age, sex, gr.getGroupName(), zachNumber);
			try {
			gr.addStudent(student);
			}catch(EleventhStudentExeption e) {
				System.out.println(e.getMessage());
			}
		}catch( IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "data entered incorrectly!");
		}
	}
}