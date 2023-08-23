package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Student;

public class StudentDao {

	public List<Student> getUsers() {

		List<Student> userList = Arrays.asList(new Student("S1", "S1 Name", "Dep 1", 35),
				new Student("S2", "S2 Name", "Dep 1", 70), new Student("S3", "S3 Name", "Dep 1", 60),
				new Student("S4", "S4 Name", "Dep 1", 90), new Student("S5", "S5 Name", "Dep 2", 30),
				new Student("S6", "S6 Name", "Dep 3", 32), new Student("S7", "S7 Name", "Dep 3", 70),
				new Student("S8", "S8 Name", "Dep 3", 20));

		return userList;
	}

}
