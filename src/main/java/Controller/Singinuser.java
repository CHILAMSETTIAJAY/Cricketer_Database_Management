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

@WebServlet("/singin")
public class Singinuser extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	PrintWriter printWriter=resp.getWriter();
	 String username = req.getParameter("name");
	 String userpassword = req.getParameter("password");
	 
	 Userdao userdao = new Userdao();
	String password =  userdao.getPassword(username);
	if(password == null) {
		resp.sendRedirect("singin.jsp");
	}
	else if(password.equals("MultiUseres")) {
		printWriter.print("Multi Useres found");
	}
	else if(password.equals(userpassword)){
		List<User> users = userdao.fetchAll();
		req.setAttribute("obj", users);
		req.setAttribute("username", username);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, resp);
	}
	else {
		
		 req.setAttribute("msg","Invalid Credentials");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./singin.jsp");
			requestDispatcher.forward(req, resp);
	
	}
}
}
