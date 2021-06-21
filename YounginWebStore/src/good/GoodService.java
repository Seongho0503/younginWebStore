package good;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class GoodService extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String method = request.getParameter("method");
		if(method==null){
			method="viewGoodList";
		 }
		try{
			if(method.equals("viewGood")){
				viewGood(request,response);
			}else if(method.equals("addGoodForm")){
				addGoodForm(request,response);
			}else if(method.equals("userViewGoodList")){
				userViewGoodList(request,response);
			}else if(method.equals("addGoodComplete")){
				addGoodComplete(request,response);
			}
			else{
				viewGoodList(request,response);
			}
		}catch(Exception e){e.printStackTrace();}
	}
	public static void addGoodComplete(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		
		RequestDispatcher rd=
			request.getRequestDispatcher
			("/good/addGoodComplete.jsp");
		rd.forward(request,response);
			
	}
	public static void addGoodForm(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		
		RequestDispatcher rd=
			request.getRequestDispatcher
			("/good/addGood.jsp");
		rd.forward(request,response);
			
	}
	public static void userViewGoodList(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		
		ArrayList<Good>list=GoodDAO.selectGoodList();
	
		request.setAttribute("GOOD_LIST",list);
		 
		RequestDispatcher rd=
			request.getRequestDispatcher
			("/good/userViewGoodList.jsp");
		rd.forward(request,response);
			
	}
	public static void viewGoodList(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		
		ArrayList<Good>list=GoodDAO.selectGoodList();
	
		request.setAttribute("GOOD_LIST",list);
		
		RequestDispatcher rd=
			request.getRequestDispatcher
			("main.jsp");
		rd.forward(request,response);
			
	}
	public static void viewGood(HttpServletRequest request,HttpServletResponse response)  throws Exception{
	
		String gid=request.getParameter("gid");
	
		Good good=GoodDAO.selectGood(gid);
		
		request.setAttribute("GOOD",good);
	
		RequestDispatcher rd=
			request.getRequestDispatcher
			("/good/userViewGood.jsp");
		rd.forward(request,response);
		}

 }