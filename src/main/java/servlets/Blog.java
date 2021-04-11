package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BlogDB;

@WebServlet("/blog")
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Blog() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// To avoid name collision with servlets.Blog and models.Blog, using models.Blog
		LinkedList<models.Blog> blogs = BlogDB.getAllBlogs();
		request.setAttribute("blogs", blogs);
		String jspFileUrl = "/views/BlogPage.jsp";
		getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
