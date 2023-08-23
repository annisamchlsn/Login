package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import dao.StudentDao;
import model.Student;
import response.StudentDataResponse;
import response.StudentResponse;

public class StudentService {

	private static final Logger logger = Logger.getLogger(StudentService.class.getName());

	private StudentDao studentDao;

	public StudentService() {

		this.studentDao = new StudentDao();

	}

	public List<StudentResponse> getUsers() {

		List<StudentResponse> userResponsesList = new ArrayList<StudentResponse>();
		List<StudentDataResponse> studentDataList = new ArrayList<StudentDataResponse>();

		List<Student> userList = this.studentDao.getUsers();
		String department = "";
		for (int i = 0; i < userList.size(); i++) {
			StudentDataResponse studentDataResponse = new StudentDataResponse();
			StudentResponse userResponse = new StudentResponse();
			if (i == 0) {
				department = userList.get(i).getDepartment();
			}
			if (i > 0 && !userList.get(i).getDepartment().equalsIgnoreCase(department)) {
				userResponse.setData(new ArrayList<>(studentDataList));
				userResponse.setDepartment(department);
				userResponse.setPass(getPass(studentDataList));
				userResponsesList.add(userResponse);
				studentDataList.clear();
				department = userList.get(i).getDepartment();
			}

			studentDataResponse.setStudentId(userList.get(i).getStudentId());
			studentDataResponse.setStudentName(userList.get(i).getStudentName());
			studentDataResponse.setMark(userList.get(i).getMark());
			studentDataList.add(studentDataResponse);
			if (i == (userList.size() - 1)) {
				userResponse.setData(studentDataList);
				userResponse.setDepartment(department);
				userResponse.setPass(getPass(studentDataList));
				userResponsesList.add(userResponse);
			}

		}

		return userResponsesList;

	}

	private double getPass(List<StudentDataResponse> students) {
		int noOfPass = 0;
		for (StudentDataResponse student : students) {
			if (student.getMark() >= 40) {
				noOfPass++;
			}
		}
		double pass = (double) noOfPass / students.size() * 100;

		return pass;
	}

	public String getUserName(String studentId) {

		List<Student> userList = this.studentDao.getUsers();

		String name = "";

		for (Student user : userList) {
			if (studentId == user.getStudentId()) {
				name = user.getStudentName();
				break;
			}
		}

		return name;

	}

}
