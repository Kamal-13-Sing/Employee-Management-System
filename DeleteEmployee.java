package employees;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String id = req.getParameter("id");
		//pw.println(id);
		
		GetSet gs = new GetSet();
		gs.setId(id);
		
		int status = CrudOperation.delete(gs);
		if(status > 0) {
			res.sendRedirect("ViewEmployee");
		}
		
	}
 

}
