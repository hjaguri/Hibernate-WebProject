package com.Hans.Project.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hans.Project.Service.IStudentService;
import com.Hans.Project.factory.StudentServiceFactory;
import com.Hans.program.bean.StudentDto;



/**
 * Servlet implementation class ControllerService
 */
@WebServlet("/Controller/*")
public class ControllerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request , response); 
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Request URI : " + request.getRequestURI());
	    System.out.println("Path Info : " + request.getPathInfo());

	    IStudentService service = StudentServiceFactory.getStudentService();

	    if (request.getRequestURI().endsWith("addStudent")) {
	       // String studentID = request.getParameter("studentId");
	        String studentName = request.getParameter("studentName");
	        String studentAge = request.getParameter("studentAge");
	        String studentAddress = request.getParameter("studentAddress");

	        // Validation to check if required fields are provided
	        if ( studentName == null || studentName.isEmpty() || studentAge == null || studentAge.isEmpty() || studentAddress == null || studentAddress.isEmpty()) {
	            // Handle missing fields (send error message or redirect)
	            System.out.println("Error: Missing required fields");
	            return; // Early exit or redirect to an error page
	        }

	        try {
	            // Parse the studentID and studentAge as integers
	           // int sid = Integer.parseInt(studentID);
	            int sage = Integer.parseInt(studentAge);

	            StudentDto dto = new StudentDto();
	           // dto.setSid(sid);
	            dto.setSname(studentName);
	            dto.setSage(sage);
	            dto.setSaddress(studentAddress);
	            RequestDispatcher rd =null;
	            String status = service.insertRecord(dto);
	            System.out.println(status);
	            if (status.equalsIgnoreCase("success")) {
	            	
	                 rd = request.getRequestDispatcher("../Success.html");
	                
	            } else {
	            	rd = request.getRequestDispatcher("../Failed.html");
	            }
	            rd.forward(request, response);
	        } catch (NumberFormatException e) {
	           
	            System.out.println("Error: Invalid number format for studentId or studentAge");
	           
	        }
	    }
	    if(request.getRequestURI().endsWith("ReadStudent")){
	        String sid = request.getParameter("readId");
	        System.out.println("Student ID : " + sid);
	        StudentDto dto = service.readRecord(Integer.parseInt(sid));
	        PrintWriter out = response.getWriter();

	        // Start of HTML and CSS
	        out.print("<html>");
	        out.print("<head>");
	        out.print("<style>");
	        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; }");
	        out.print("h1 { color: #333; font-size: 24px; }");
	        out.print("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
	        out.print("table, th, td { border: 1px solid #ddd; }");
	        out.print("th, td { padding: 12px 15px; text-align: left; }");
	        out.print("th { background-color: #4CAF50; color: white; }");
	        out.print("tr:nth-child(even) { background-color: #f2f2f2; }");
	        out.print("tr:hover { background-color: #ddd; }");
	        out.print("button { background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; font-size: 16px; margin-top: 20px; }");
	        out.print("button:hover { background-color: #45a049; }");
	        out.print("</style>");
	        out.print("</head>");
	        out.print("<body>");

	        if(dto != null) {
	            System.out.println("Inside dto : " + dto);
	            out.print("<h1>Student Details</h1>");
	            out.print("<table>");
	            out.print("<tr><th>STUDENT ID</th><th>STUDENT NAME</th><th>STUDENT AGE</th><th>STUDENT ADDRESS</th></tr>");
	            out.print("<tr>");
	            out.print("<td>" + dto.getSid() + "</td>");
	            out.print("<td>" + dto.getSname() + "</td>");
	            out.print("<td>" + dto.getSage() + "</td>");
	            out.print("<td>" + dto.getSaddress() + "</td>");
	            out.print("</tr>");
	            out.print("</table>");
	            
	            // Adding a button
	            out.print("<form action='/FirstWebProjectUsingCURD/Controller' method='get'>");
	            out.print("</form>");
	        } else {
	            System.out.println("Inside else");
	            out.print("<h1>The Record is not found in table</h1>");
	        }

	        out.print("</body>");
	        out.print("</html>");

	        out.close();
	    }
	    
	   if(request.getRequestURI().endsWith("DeleteStudent")) {
		   
		   String studentId = request.getParameter("deleteId");
		  String status =  service.deleteRecord(Integer.parseInt(studentId));	
		  RequestDispatcher rd =null;
		  if (status.equalsIgnoreCase("success")) {
              rd = request.getRequestDispatcher("../Success.html");
              rd.forward(request, response);
             
         } else {
         	rd = request.getRequestDispatcher("../Failed.html");
         	  rd.forward(request, response);
         }
	   }
	   
	   if(request.getRequestURI().endsWith("updateStudent")) {
		    String studentID = request.getParameter("updateId");
		    PrintWriter pw = response.getWriter();
		    StudentDto dto = service.readRecord(Integer.parseInt(studentID));
		    if (dto != null) {
		        pw.print("<body style='font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f7fc; padding: 40px;'>");
		        pw.print("<h1 style='text-align: center; color: #4CAF50; font-size: 36px; font-weight: bold;'>STUDENT MANAGEMENT SYSTEM</h1>");
		        pw.print("<h2 style='text-align: center; color: #333; font-size: 24px;'>UPDATE STUDENT INFORMATION</h2>");
		        pw.print("<form method='POST' action='./Controller/UpdateRecord'>");

		        // Table Styling with hover effect, smooth shadow, and responsiveness
		        pw.println("<table style='border-collapse: collapse; width: 80%; margin: 30px auto; box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1); border-radius: 10px; overflow: hidden;'>");
		        pw.println("<thead style='background-color: #4CAF50; color: white;'>");
		        pw.println("<tr>");
		        pw.println("<th style='padding: 12px 20px; text-align: left;'>Student ID</th>");
		        pw.println("<th style='padding: 12px 20px; text-align: left;'>Student Name</th>");
		        pw.println("<th style='padding: 12px 20px; text-align: left;'>Student Age</th>");
		        pw.println("<th style='padding: 12px 20px; text-align: left;'>Student Address</th>");
		        pw.println("</tr>");
		        pw.println("</thead>");

		        pw.println("<tbody style='background-color: white; text-align: left;'>");

		        pw.println("<tr style='border-bottom: 1px solid #ddd; transition: background-color 0.3s;'>");
		        pw.println("<td style='padding: 12px 20px;'><input type='text' name='sid' value='" + dto.getSid() + "' style='width: 100%; padding: 10px; font-size: 14px; border: 1px solid #ddd; border-radius: 6px;'/></td>");
		        pw.println("<td style='padding: 12px 20px;'><input type='text' name='sname' value='" + dto.getSname() + "' style='width: 100%; padding: 10px; font-size: 14px; border: 1px solid #ddd; border-radius: 6px;'/></td>");
		        pw.println("<td style='padding: 12px 20px;'><input type='text' name='sage' value='" + dto.getSage() + "' style='width: 100%; padding: 10px; font-size: 14px; border: 1px solid #ddd; border-radius: 6px;'/></td>");
		        pw.println("<td style='padding: 12px 20px;'><input type='text' name='saddress' value='" + dto.getSaddress() + "' style='width: 100%; padding: 10px; font-size: 14px; border: 1px solid #ddd; border-radius: 6px;'/></td>");
		        pw.println("</tr>");

		        pw.println("</tbody>");
		        pw.println("</table>");

		        // Submit button styling
		        pw.println("<div style='text-align: center; margin-top: 20px;'>");
		        pw.println("<input type='submit' value='Update Student' style='padding: 12px 30px; background-color: #4CAF50; color: white; font-size: 16px; border: none; border-radius: 6px; cursor: pointer; transition: background-color 0.3s;'>");
		        pw.println("</div>");

		        pw.print("</form>");
		        pw.println("</body>");

		    } else {
		        // "Not found" message with better style and alignment
		        pw.print("<div style='text-align: center; margin-top: 40px;'>");
		        pw.print("<p style='font-size: 22px; color: #e74c3c; font-weight: bold;'>Student Not Found</p>");
		        pw.println("<a href='previousPage.jsp' style='font-size: 18px; color: #4CAF50; text-decoration: none;'>Go Back</a>");
		        pw.println("</div>");
		    }
		    pw.close();
		}

		
		
		if(request.getRequestURI().endsWith("UpdateRecord")) {
		    System.out.println("I m inside the updateRecord");
		    String studentId = request.getParameter("sid");
		    String studentName = request.getParameter("sname");
		    String studentAge = request.getParameter("sage");
		    String studentAddress = request.getParameter("saddress");

		    StudentDto studentDto = new StudentDto();
		    studentDto.setSid(Integer.parseInt(studentId));
		    studentDto.setSage(Integer.parseInt(studentAge));
		    studentDto.setSaddress(studentAddress);
		    studentDto.setSname(studentName);

		    String status = service.updateRecord(studentDto);  // Update method
		    RequestDispatcher rd =null;
		    if (status.equalsIgnoreCase("success")) {
		        rd = request.getRequestDispatcher("../../Success.html");
		        rd.forward(request, response);
		    } else {
		        rd = request.getRequestDispatcher("../../Failed.html");
		        rd.forward(request, response);
		    }
		}
	   }
	}

		

	   
	

