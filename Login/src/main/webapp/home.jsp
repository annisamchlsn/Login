<%@page import="model.User"%>
<%@page import="response.StudentResponse"%>
<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<script>
        function showPopup(data) {
            document.getElementById("popupContent").innerText = data;
            document.getElementById("popup").style.display = "block";
        }

        function closePopup() {
            document.getElementById("popup").style.display = "none";
        }
    </script>
</head>
<body>
	<% List<StudentResponse> users = (List<StudentResponse>)request.getAttribute("users"); %>
	<% User loggedInUser = (User) request.getAttribute("username"); %>
	<h1>Welcome <%=loggedInUser.getUsername() %></h1>
</body>

<table border="1" style="width: 50%" height="50%">
	<thead>
	<tr>
		<th>Department</th>
		<th>Student ID</th>
		<th>Marks</th>
		<th>Pass</th>
	</tr>
	</thead>
	<tbody>
	<%
	for(StudentResponse user : users){
	%>
		<tr>
			<td rowspan=<%=user.getStudentDataResponses().size() %>><%=user.getDepartment() %></td>
			<td><a href="javascript:void(0);" onclick="showPopup('<%=user.getStudentDataResponses().get(0).getStudentName() %>')"><%=user.getStudentDataResponses().get(0).getStudentId() %></a></td>
			<td><%=user.getStudentDataResponses().get(0).getMark() %></td>		
			<td rowspan=<%=user.getStudentDataResponses().size() %>><%=user.getPass() %></td>
		</tr>
		<% for(int i = 1; i < user.getStudentDataResponses().size(); i++) { %>
			<tr>
				<td><a href="javascript:void(0);" onclick="showPopup('<%=user.getStudentDataResponses().get(i).getStudentName() %>')"><%=user.getStudentDataResponses().get(i).getStudentId() %></a></td>
				<td><%=user.getStudentDataResponses().get(i).getMark() %></td>		
			</tr>
		<% } %>
	<%} %>
	</tbody>
</table>

<div id="popup" style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); border: 1px solid black; background-color: white; padding: 20px;">
        <span id="popupContent"></span>
        <br>
        <button onclick="closePopup()">Close</button>
    </div>

</html>