package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

//import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.omg.CORBA.Request;

import dao.StudentDao;
import model.User;
import response.StudentResponse;
import service.StudentService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/users")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(StudentController.class.getName());

	private StudentService studentService;

	
	public StudentController() {
		this.studentService = new StudentService();
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String domain = requestURL.substring(0, requestURL.indexOf(requestURI));
		String addPath = "/getId";
		URL addUrl = new URL(new URL(domain), addPath);
		logger.info("Domain URL = " + domain);
		logger.info("Servlet path = " + action);
		switch (action) {
		case "/getId":
			showPopUp(request, response);
			break;
		default:
			process(request, response);
			break;
		}

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}



	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
		List<StudentResponse> listUser = this.studentService.getUsers();
		logger.info("Usernya = " + loggedInUser.getUsername());
		request.setAttribute("username", loggedInUser);
		request.setAttribute("users", listUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

	private void showPopUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String sudentId = this.studentService.getUserName(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/popup.jsp");
		request.setAttribute("user", sudentId);
		dispatcher.forward(request, response);
	}

}
