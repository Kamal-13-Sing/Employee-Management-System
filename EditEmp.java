package employees;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
	 
	 res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
		
	String id = req.getParameter("eid");
	 String name = req.getParameter("name");
	 String gender = req.getParameter("gender");
	 String dob = req.getParameter("dob");
	 String address = req.getParameter("add");
	
	 String email = req.getParameter("email");
	 String jobType = req.getParameter("jobtype");
	 String joinDate = req.getParameter("joindate");
	 String salary = req.getParameter("salary");
	 String contact = req.getParameter("cno");

	 GetSet gs = new GetSet();
	 
	 gs.setId(id);
	 gs.setName(name);
	 gs.setGender(gender);
	 gs.setDob(dob);
	 gs.setAddress(address);
	 gs.setEmail(email);
	 gs.setJobType(jobType);
	 gs.setJoinDate(joinDate);
	 gs.setSalary(Integer.parseInt(salary));
	 gs.setContact(contact);
	 
	 int status = CrudOperation.updateData(gs);
	 
	 if(status > 0) {
		 res.sendRedirect("ViewEmployee");
	 }
	
 }

}
