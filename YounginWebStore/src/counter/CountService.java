package counter;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class CountService extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String method = request.getParameter("method");
		if(method==null){
			method="viewCountList";
		 }
		try{
			viewCountList(request,response);
		}catch(Exception e){e.printStackTrace();}
	}
	public static void viewCountList(HttpServletRequest request,HttpServletResponse response)  throws Exception{
	
		ArrayList<Counter>list=CountDAO.selectCountList();
		
		request.setAttribute("COUNT_LIST",list);
	
		RequestDispatcher rd=
			request.getRequestDispatcher
			("/admin/viewCount.jsp");
		rd.forward(request,response);
			
	}
 }