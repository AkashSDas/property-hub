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
import models.PropertyOwner;

@WebServlet("/property-info")
public class PropertyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PropertyInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int propertyId = Integer.parseInt(request.getParameter("propertyId"));
		Property property = SearchPropertyDB.getPropertiesForLocation(propertyId);
		PropertyOwner propertyOwner = SearchPropertyDB.getPropertyOwner(property.getOwnerId());
		LinkedList<String> propertyImageUrls = SearchPropertyDB.getPropertyImageUrls(propertyId);
		request.setAttribute("property", property);
		request.setAttribute("propertyOwner", propertyOwner);
		request.setAttribute("propertyImageUrls", propertyImageUrls);

		System.out.println(property.getTitle() + " " + propertyOwner.getEmail());

		String jspFileUrl = "/views/PropertyInfo.jsp";
		getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
