package employees;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		
		res.setContentType("text/html");
		
		PrintWriter pw = res.getWriter();
		
		CrudOperation co = new CrudOperation();
		
		List<GetSet> gs  = co.readData();
		
		pw.println("<style>"
				+ "	.header{border:1px solid black; height:80px; width:auto;}"
				+ "	.c1{border:1px solid black; height:460px; width:300px; float:left;}"
				+ "	.c2{border:1px solid black; height:460px; width:1000px; float:right;}"
				+ "	.h{text-align:center;}"
				+ "	.btn{ padding:5px; margin:10px 0 0 20px;}"
				
				+ "</style>");
		
		pw.println("<div class='header'> </div>");
		
		pw.println("<div class='c1'></div>");
		pw.println("<div class='c2'>");
		
		pw.println("<h2 class='h'>Details of Employee</h2>");
		pw.println("<button class='btn'><a href='employee.html'>Add New Employees</a></button>");
		
		pw.println("<br><br>");
		
		
			
		pw.println("<table border=1>");
			
			pw.println("<tr>"
					+ "<th>Id</th><th>Name</th><th>Gender</th><th>DateOfBirth</th>"
					+ "<th>Address</th><th>Email</th><th>Job Type</th><th>Join Date</th>"
					+ "<th>A-Salary</th><th>Contact</th><th colspan=2>Tool</th>"
					+ "</tr>");
			
			
			for(GetSet data : gs)  {
				
			pw.println("<tr>"
					
					+ "<td>"+data.getId()+"</td>"
					+ "<td>"+data.getName()+"</td>"
					+ "<td>"+data.getGender()+"</td>"
					+ "<td>"+data.getDob()+"</td>"
					+ "<td>"+data.getAddress()+"</td>" 
					+ "<td>"+data.getEmail()+"</td>"
					+ "<td>"+data.getJobType()+"</td>"
					+ "<td>"+data.getJoinDate()+"</td>"
					+ "<td>"+data.getSalary()+"</td>"
					+ "<td>"+data.getContact()+"</td>"
					
					+ "<td><a href='EditEmployee?id="+data.getId()+"'> Edit </a></td>"
					+ "<td><a href='DeleteEmployee?id="+data.getId()+"'> Delete </a></td>"
					
					+ "</tr>");
			}
			
			pw.println("</table>");
		
		pw.println("</div>");
		
//----------------------------------Another Way---------------------------------------		
		/*
		
		pw.println("<style>"
				+ "	.header{border:1px solid black; height:80px; width:auto;}"
				+ "	.c1{border:1px solid black; height:460px; width:300px; float:left;}"
				+ "	.c2{border:1px solid black; height:460px; width:1000px; float:right;}"
				+ "	.h{text-align:center;}"
				+ "	.btn{ padding:5px; margin:10px 0 0 20px;}"
				+ "</style>");
		
		pw.println("<div class='header'> </div>");
		
		pw.println("<div class='c1'></div>");
		
		pw.println("<div class='c2'>");
		
		pw.println("<h2 class='h'>Details of Employee</h2>");
		
		pw.println("<button class='btn'><a href='employee.html'>Add New Employees</a></button>");
		pw.println("<br><br>");
		
		try {
			
			Connection con = CrudOperation.getConnection();
			String read = "select * from employee";
			PreparedStatement pst = con.prepareStatement(read);
			
			ResultSet data = pst.executeQuery();
			
			pw.println("<table border=1>");
			
			pw.println("<tr>"
					+ "<th>Id</th><th>Name</th><th>Gender</th><th>DateOfBirth</th>"
					+ "<th>Address</th><th>Email</th><th>Job Type</th><th>Join Date</th>"
					+ "<th>A-Salary</th><th>Contact</th><th colspan=2>Tool</th>"
					+ "</tr>");
			
			while(data.next()) {
				
			pw.println("<tr>"
					+ "<td>"+data.getString(1)+"</td>"
					+ "<td>"+data.getString(2)+"</td>"
					+ "<td>"+data.getString(3)+"</td>"
					+ "<td>"+data.getString(4)+"</td>"
					+ "<td>"+data.getString(5)+"</td>" 
					+ "<td>"+data.getString(6)+"</td>"
					+ "<td>"+data.getString(7)+"</td>"
					+ "<td>"+data.getString(8)+"</td>"
					+ "<td>"+data.getString(9)+"</td>"
					+ "<td>"+data.getString(10)+"</td>"
					+ "<td><a href='EditEmployee?id="+data.getString(1)+"'>Edit</a></td>"
					+ "<td><a href='DeleteEmployee?id="+data.getString(1)+"'>Delete</a></td>"
					+ "</tr>");
			}
			
			pw.println("</table>");
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
		
		pw.println("</div>");
		
		*/
	}

}
