package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/edit")
public class Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid =req.getParameter("id");
		int id = Integer.parseInt(userid);
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = new User();
		user.setUserId(id);
		user.setUserName(name);
		user.setUserAge(age);
		user.setUserPhone(phone);
		user.setUserAddress(address);
		user.setUserEmail(email);
		user.setUserPassword(password);

		Userdao userdao = new Userdao();
		boolean flag = userdao.updatedata(user);
		if (flag) {
			List<User> users = userdao.fetchAll();
			req.setAttribute("obj", users);
			req.setAttribute("username", user.getUserName());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		} 

	}

}
