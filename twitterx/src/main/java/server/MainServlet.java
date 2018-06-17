package server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.getRequestDispatcher("/WEB-INF/views/not_logged_in.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if(userExists(login, password)) {
			request.getRequestDispatcher("/WEB-INF/views/logged_in.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/not_logged_in.jsp").forward(request, response);
		}
		
	}
	
	private boolean userExists(String login, String password) {
		
		if(login.equals("example") && password.equals("example")) {
			return true;
		}
		return false;
		
	}
	
}
