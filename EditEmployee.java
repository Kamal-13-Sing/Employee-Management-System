package employees;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doTrace(arg0, arg1);
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String id = req.getParameter("id");
		GetSet gs = CrudOperation.getData(id);
		
		//pw.println(gs.getId());
		pw.println("<style>"
				+ "	.header{border:1px solid black; height:80px; width:auto;}"
				+ "	.c1{border:1px solid black; height:460px; width:300px; float:left;}"
				+ "	.c2{border:1px solid black; height:460px; width:1000px; float:right;}"
				+ " .a{height:300px; width:400px; margin:50px 0 0 100px;}"
				+ " .b{height:300px; width:400px; margin:-300px 0 0 510px;}"
				+ "	.h{text-align:center;}"
				+ "	.btn{ padding:5px; margin:-30px 0 0 20px;}"
				+ " .s{float:right; padding:5px;  margin:-12px 15px 0 0;}"
				+ "</style>");
		
		pw.println("<div class='header'> </div>");
		pw.println("<div class='c1'></div>");
		
		pw.println("<div class='c2'>");
		
		pw.println("<h2 class='h'>Update Employee Details</h2>");
		pw.println("<button class='btn'><a href='employee.html'>Add New Employees</a></button>");
		pw.println("<br><br>");
		
		pw.println("<form action='EditEmp' method='post'>");
		
		pw.println("<div class='a'>");
		
		pw.println("Employee Id: <input type='text' name='eid' value='"+gs.getId()+"'><br><br><br>");
		pw.println("Employee Name: <input type='text' name='name' value='"+gs.getName()+"'><br><br><br>");
		pw.println("Select Gender*: <input type='radio' name='gender' value='Male'>Male");
		pw.println("<input type='radio' name='gender' value='Female'>FeMale<br><br><br>");
					   
		pw.println("Date Of Birth: <input type='date' name='dob' value='"+gs.getDob()+"'><br><br><br>");
		pw.println("Address: <input type='text' name='add' value='"+gs.getAddress()+"'><br><br><br>");
		
		pw.println("</div>");
		pw.println("<div class='b'>");
		
		pw.println("Email: <input type='text' name='email' value='"+gs.getEmail()+"'><br><br><br>");
		pw.println("Job Type: <input type='text' name='jobtype' value='"+gs.getJobType()+"'><br><br><br>");
		pw.println("Join Date: <input type='date' name='joindate' value='"+gs.getJoinDate()+"'><br><br><br>");
		pw.println("Annual Salary: <input type='number' name='salary' value='"+gs.getSalary()+"'><br><br><br>");
		pw.println("Contact No: <input type='number' name='cno' value='"+gs.getContact()+"'>");
		
		pw.println("</div>");
		
		pw.println("<input class='s' type='submit' value='Update Employee'>");
		pw.println("<input class='s' type='reset' value='Reset'> ");
		pw.println("</form>");
		pw.println("<button class='btn'><a href='ViewEmployee'>View Employees</a></button>");
		
		pw.println("</div>");
		
		
	}

}
