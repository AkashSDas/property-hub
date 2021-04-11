package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LoanDB;

@WebServlet("/loan")
public class Loan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Loan() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkedList<models.Loan> loans = LoanDB.getAllBankLoans();
		request.setAttribute("loans", loans);
		String jspFileUrl = "/views/LoansPage.jsp";
		getServletContext().getRequestDispatcher(jspFileUrl).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
