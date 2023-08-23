package model;

public class Student {

	private String studentId;
	private String studentName;
	private String department;
	private Integer mark;

	public Student(String studentId, String studentName, String department, Integer mark) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.department = department;
		this.mark = mark;

	}

	public String getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getDepartment() {
		return department;
	}

	public Integer getMark() {
		return mark;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String toString() {
		return "User{" + "studentId=" + studentId + ", studentName='" + studentName + '\'' + ", department='"
				+ department + '\'' + ", mark='" + mark + '\'' + '}';
	}
}
