package employees;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/EmployeeForm")
public class EmployeeForm extends HttpServlet {
	
	int i,n,g,d,a,e,jt,jd,s,c;
	
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
		
		 /*
		 pw.println("<h1>Hwwllo</h1>");
		 
		 pw.println("Eid: "+id);
		 pw.println("<br>Name: "+name);
		 pw.println("<br>Gender: "+gender);
		 pw.println("<br>DOB: "+dob);
		 pw.println("<br>Address: "+address);
		 pw.println("<br>Email: "+email);
		 pw.println("<br>JobType: "+jobType);
		 pw.println("<br>JoinDate: "+joinDate);
		 pw.println("<br>Salary: "+salary);
		 pw.println("<br>Contact: "+contact);
		*/
		 
		 //----------Id validation---------------
		 if(id.equals("")) {
			 pw.println("*Id is Required");
		 }else {i = 1;}
		 
		//----------Name validation---------------
		 if(name.equals("")) {
			 pw.println("*Name is Required");
		 }else {n = 1;}
		 
		//----------Gender validation---------------
		 if(gender.equals(null)) {
			 pw.println("*Gender is Required");
		 }else {g = 1;}
		 
		//----------DoB validation---------------
		 if(dob.equals("")) {
			 pw.println("*DoB is Required");
		 }else {d = 1;}
		 
		//----------Address validation---------------
		 if(address.equals("")) {
			 pw.println("*Address is Required");
		 }else {a = 1;}
		 
		//----------Email validation---------------
		 if(email.equals("")) {
			 pw.println("*Email is Required");
		 }else {e = 1;}
		 
		//----------JobType validation---------------
		 if(jobType.equals("")) {
			 pw.println("*JobType is Required");
		 }else {jt = 1;}
		 
		//----------JoinDate validation---------------
		 if(joinDate.equals("")) {
			 pw.println("*Join Date is Required");
		 }else {jd = 1;}
		 
		//----------salary validation---------------
		 if(salary.equals("")) {
			 pw.println("*Salary is Required");
		 }else {s = 1;}
		 
		//----------Contact validation---------------
		 if(contact.equals("")) {
			 pw.println("*Contact is Required");
		 }else if(contact.length() != 10) {
			 pw.println("*Contact Must be 10 digit");
			 
			 }else {c = 1;}
		 
		 if(i==1&&n==1&&g==1&&d==1&&a==1&&e==1&&jt==1&&jd==1&&s==1&&c==1) {
			 
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
			 
			 CrudOperation co = new CrudOperation();
			 
			 
			 int status = co.insertData(gs);
			 if(status > 0 ) {
				 res.sendRedirect("ViewEmployee");
			 }
			 
		 }else {
			 req.getRequestDispatcher("employee.html").include(req, res);
		 }
		 
		
	}


}
