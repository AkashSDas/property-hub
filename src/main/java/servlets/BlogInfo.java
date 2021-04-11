package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BlogDB;

@WebServlet("/blog-info")
public class BlogInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BlogInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int blogId = Integer.parseInt(request.getParameter("blogId"));
		models.Blog blog = BlogDB.getBlog(blogId);
		request.setAttribute("blog", blog);
		String jspFileUrl = "/views/BlogInfoPage.jsp";
		getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
