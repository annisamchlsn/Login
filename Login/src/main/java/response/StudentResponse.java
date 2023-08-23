package response;

import java.util.List;

public class StudentResponse {

	private List<StudentDataResponse> data;
	private String department;
	private double pass;

	public StudentResponse() {
		this.data = data;
		this.department = department;
		this.pass = pass;
	}

	public List<StudentDataResponse> getStudentDataResponses() {
		return data;
	}

	public String getDepartment() {
		return department;
	}

	public double getPass() {
		return pass;
	}

	public void setData(List<StudentDataResponse> data) {
		this.data = data;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPass(double pass) {
		this.pass = pass;
	}

	public String toString() {
		return "UserResponse{" + "data=" + data + ", department='" + department + '\'' + ", pass=" + pass + '}';
	}

}
