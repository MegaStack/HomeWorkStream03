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
			String name = JOptionPane.showInputDialog("¬вед≥ть ≥мТ€");
			if(name == null) {
				throw new NullPointerException();
			}
			String lastName = JOptionPane.showInputDialog("¬вед≥ть пр≥звище");
			if(lastName == null) {
				throw new NullPointerException();
			}
			String sureName = JOptionPane.showInputDialog("¬вед≥ть по батьков≥");
			if(sureName == null) {
				throw new NullPointerException();
			}
			int age = Integer.valueOf(JOptionPane.showInputDialog("¬вед≥ть в≥к"));
			boolean sex = interactiveGetSex("¬вед≥ть стать m/w (m - чолов≥ча, w - ж≥ноча)");
			int zachNumber = Integer.valueOf(JOptionPane.showInputDialog("¬вед≥ть номер зал≥ковки"));
			student = new Student(name, lastName, sureName, age, sex, gr.getGroupName(), zachNumber);
			try {
			gr.addStudent(student);
			}catch(EleventhStudentExeption e) {
				System.out.println(e.getMessage());
			}
		}catch( IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "¬≥дм≥на введенн€ або некоректний формат введенн€!");
		}
	}
}
