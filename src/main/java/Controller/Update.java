package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;
import dto.User;

@WebServlet("/UpdateServlet")
public class Update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		
		int id = Integer.parseInt(userId);

		req.setAttribute("UserId", id);
		Userdao userdao = new Userdao();
	    User user =	userdao.fecthbyid(id);
		if(user!=null) {
			req.setAttribute("obj",user);
			req.setAttribute("username", user.getUserName());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("update.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("singin.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}
}
