package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.SignUpDB;

@WebServlet("/sign-up")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jspFileUrl = "/views/SignUp.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Check if user exists
		if (email != null) {
			// If user has entered an email address then

			if (SignUpDB.checkUserExists(email)) {
				request.setAttribute("message", "This email address is already used");
				getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
			} else {
				boolean userCreated = SignUpDB.signUpUser(email, password);
				if (userCreated) {
					response.sendRedirect("home");
				} else {
					request.setAttribute("message", "An error occured, Please try again");
					getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
				}
			}
		} else {
			getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
