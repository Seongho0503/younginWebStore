package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import entity.Dept;


/**
 * 사용자의 요구사항을 받아서 처리하고 JSP 페이지로 이동하는 서블렛
 * 
 */
public class DeptService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // doGet으로 가는것은 doPost로
	}
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String method = request.getParameter("method");
		if(method==null)
			method="viewDeptList";
				
		try {
			if (method.equalsIgnoreCase("addDeptForm")) { // 등록화면  요청
				addDeptForm(request, response);
			}else if (method.equalsIgnoreCase("addDept")) { // 등록하기
				addDept(request, response);
			}  else if (method.equalsIgnoreCase("viewDept")) { // 조회하기
				viewDept(request, response);
			} else if (method.equalsIgnoreCase("editDeptForm")) { // 수정화면
				// 요청
				editDeptForm(request, response);
			} else if (method.equalsIgnoreCase("editDept")) { // 수정
				editDept(request, response);
			} else if (method.equalsIgnoreCase("viewDeptList")) { // 목록보기
				viewDeptList(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private  static void addDeptForm(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
    
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("/dept/addDept.jsp");
		dispatcher.forward(request, response);
}
  
	private  static void addDept(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String name =  request.getParameter("name"); 
		String code =  request.getParameter("code"); 
		String price =  request.getParameter("price"); 
		int maxAskCnt = Integer.parseInt(request.getParameter("max_cnt"));	
        
		Dept dept = new Dept();
		dept.setName(name);
		dept.setCode(code);
		dept.setPrice(price);
		dept.setMaxAskCnt(maxAskCnt);

		
		
		DeptDAO.insertDept(dept);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Dept?method=viewDeptList");
		dispatcher.forward(request, response);
	}
	
	private static void editDeptForm(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		String code =  request.getParameter("code"); 
		
		
		Dept dept = DeptDAO.selectDept(code);		
		
		request.setAttribute("DEPT", dept);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/dept/editDept.jsp");
		dispatcher.forward(request, response);
}

private static void editDept(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
	
	String name =  request.getParameter("name"); 
	String code =  request.getParameter("code"); 
	String price =  request.getParameter("price"); 
	int maxAskCnt = Integer.parseInt(request.getParameter("max_cnt"));	
	
	Dept dept = new Dept();
	
	dept.setName(name);
	dept.setCode(code);
	dept.setPrice(price);
	dept.setMaxAskCnt(maxAskCnt);
	
	
	DeptDAO.updateDept(dept);
	
	RequestDispatcher dispatcher = request
			.getRequestDispatcher("/Dept?method=viewDeptList");
	dispatcher.forward(request, response);
}

  
	private static  void viewDept(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String code =  request.getParameter("code"); 
		
		
		Dept dept = DeptDAO.selectDept(code);		
		
		request.setAttribute("DEPT", dept);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/dept/viewDept.jsp");
		dispatcher.forward(request, response);
	}

   
	private static void viewDeptList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		List deptList = DeptDAO.selectDeptList();
		
		request.setAttribute("DEPT_LIST", deptList);

		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/dept/viewDeptList.jsp");
		dispatcher.forward(request, response);
	}
}
