package evidyarthy.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import evidyarthy.database.EvidyarthyDatabase;

/**
 * Servlet implementation class QuestionSubmissionServlet
 */
@WebServlet("/QuestionSubmissionServlet")
public class QuestionSubmissionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting the details from the form
		ArrayList<String> details = new ArrayList<>();
		int k=0;
		
		details.add(request.getParameter("regid"));
		details.add(request.getParameter("name"));
		details.add(request.getParameter("topic"));
		
		for(int i=0;i<30;i++)
		{
			details.add(request.getParameter("Q "+(i+1)));
		}
		
		EvidyarthyDatabase edb = new EvidyarthyDatabase();
		
		try {
			k = edb.insertExam(details);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k>0)
		{
			response.sendRedirect("home.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
