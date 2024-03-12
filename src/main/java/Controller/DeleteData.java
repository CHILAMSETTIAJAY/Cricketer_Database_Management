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

@WebServlet("/DeleteUserServlet")
public class DeleteData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		if(userId !=null) {
			int id = Integer.parseInt(userId);

			Userdao userdao = new Userdao();
			Boolean flag = userdao.deletebyid(id);
			
		if(flag) {
			List<User> users = userdao.fetchAll();
			req.setAttribute("obj", users);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("user.html");
			requestDispatcher.forward(req, resp);
		}
		}
	}
}
