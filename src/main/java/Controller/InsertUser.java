package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/register")
public class InsertUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User();
		user.setUserName(name);
		user.setUserAge(age);
		user.setUserPhone(phone);
		user.setUserAddress(address);
		user.setUserEmail(email);
		user.setUserPassword(password);

		Userdao userdao = new Userdao();
	 String passwordString =	userdao.getPassword(name);
	 if(passwordString == null) {
		User user2 = userdao.insert(user);
		if (user2 != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("singin.jsp");
			requestDispatcher.forward(req, resp);
		} 
	 }
	 else {
		 req.setAttribute("msg","Name already in use");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./index.jsp");
			requestDispatcher.forward(req, resp);
	}

	}

}
