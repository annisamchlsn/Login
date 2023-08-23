package response;

public class StudentDataResponse {

	private String studentId;
	private Integer mark;
	private String studentName;

	public StudentDataResponse() {
		this.studentId = studentId;
		this.mark = mark;
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public Integer getMark() {
		return mark;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String toString() {
		return "StudentDataResponse{" + "studentId=" + studentId + ", mark='" + mark + '\'' + ", studentName='"
				+ studentName + '\'' + '}';
	}
}
