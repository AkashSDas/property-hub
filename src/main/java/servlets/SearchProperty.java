package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.SearchPropertyDB;
import models.Property;

@WebServlet("/search-property")
public class SearchProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProperty() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LinkedList<Property> properties = new LinkedList<>();
		String location = request.getParameter("location");
		if (location.length() == 0) {
			properties = SearchPropertyDB.getAllProperties();
		} else {
			properties = SearchPropertyDB.getPropertiesForLocation(location);
		}

		request.setAttribute("properties", properties);
		String jspFileUrl = "/views/SearchProperty.jsp";
		getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
