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
 * ������� �䱸������ �޾Ƽ� ó���ϰ� JSP �������� �̵��ϴ� ����
 * 
 */
public class DeptService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // doGet���� ���°��� doPost��
	}
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String method = request.getParameter("method");
		if(method==null)
			method="viewDeptList";
				
		try {
			if (method.equalsIgnoreCase("addDeptForm")) { // ���ȭ��  ��û
				addDeptForm(request, response);
			}else if (method.equalsIgnoreCase("addDept")) { // ����ϱ�
				addDept(request, response);
			}  else if (method.equalsIgnoreCase("viewDept")) { // ��ȸ�ϱ�
				viewDept(request, response);
			} else if (method.equalsIgnoreCase("editDeptForm")) { // ����ȭ��
				// ��û
				editDeptForm(request, response);
			} else if (method.equalsIgnoreCase("editDept")) { // ����
				editDept(request, response);
			} else if (method.equalsIgnoreCase("viewDeptList")) { // ��Ϻ���
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
