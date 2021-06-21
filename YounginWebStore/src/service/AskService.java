package service;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.Customer;
import customer.CustomerDAO;


import util.ConnectionUtil;
import util.PageUtil;

import dao.CodeDAO;
import dao.DeptDAO;
import dao.AskDAO;
import entity.Code;
import entity.Dept;
import entity.Ask;



/**
 * 학생정보를 관리하는 서블렛
 * 
 */
public class AskService extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		
		String method = request.getParameter("method");
		if(method==null)
			method="viewAskList";
		try {
			if (method.equalsIgnoreCase("addAskForm")) { // 등록화면
				// 요청
				addAskForm(request, response);
			}else if (method.equalsIgnoreCase("searchAskList")) { // 등록화면
				// 요청
				searchAskList(request, response);
			} 
			else if (method.equalsIgnoreCase("viewAsk")) { // 조회하기
				viewAsk(request, response);
			} else if (method.equalsIgnoreCase("editAskForm")) { // 수정화면
				// 요청
				editAskForm(request, response);
			} else if (method.equalsIgnoreCase("editAsk")) { // 수정
				editAsk(request, response);
			} else if (method.equalsIgnoreCase("viewAskList")) { // 목록보기
				viewAskList(request, response);
			} else if (method.equalsIgnoreCase("removeAsk")) { // 삭제하기
				removeAsk(request, response);
			}else if(method.equalsIgnoreCase("addAsk")){
				addAsk(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addAskForm(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		
		List statusList = CodeDAO.selectCodeList("status");
	
		List deptList = DeptDAO.selectDeptList();
		String writer = CustomerDAO.getWriter();
	
		request.setAttribute("STATUS_LIST", statusList);
		
		request.setAttribute("DEPT_LIST", deptList);
		request.setAttribute("WRITER", writer);
	
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask/addAsk.jsp");
		dispatcher.forward(request, response);
}

	public static  void addAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String writer = request.getParameter("writer");
		String name = request.getParameter("name");
		String deptCd = request.getParameter("dept");
		String details = request.getParameter("details");
		Dept dept = new Dept();
		dept.setCode(deptCd);
		String regNo = request.getParameter("regNo");
		Code status = new Code();
		status.setCodeValue(request.getParameter("status"));

		if (name == null || name.equalsIgnoreCase("")) {
			 RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask?method=addAskForm");
		     dispatcher.forward(request, response);
		 }
		    Ask ask = new Ask();
			ask.setName(name);
			ask.setRegNo(regNo);
			ask.setDept(dept);
			ask.setStatus(status);
			ask.setDetails(details);
			ask.setWriter(writer);
			
			AskDAO.insertAsk(ask);
			
		
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/Ask?method=viewAskList");
			dispatcher.forward(request, response);
	}
	public static void viewAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String user = CustomerDAO.getWriter();
		String writer = request.getParameter("writer");

		if(user != writer){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ask/wrongAsk.jsp");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Ask ask = AskDAO.selectAsk(id);
		request.setAttribute("ASK", ask);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask/viewAsk.jsp");
		dispatcher.forward(request, response);
	}

	public static void editAskForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Ask ask = AskDAO.selectAsk(id);
		
		
		List statusList = CodeDAO.selectCodeList("status");
		List deptList = DeptDAO.selectDeptList();
		request.setAttribute("STATUS_LIST", statusList);
		request.setAttribute("DEPT_LIST", deptList);
		request.setAttribute("ASK", ask);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask/editAsk.jsp");
		dispatcher.forward(request, response);
	}
	public static void editAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("name");
		Dept dept = new Dept();
		dept.setCode(request.getParameter("dept"));
		String regNo = request.getParameter("reqNo");
		Code code = new Code();
		code.setCodeValue(request.getParameter("status"));
		String strId=request.getParameter("id");
		strId.trim();

		if (strId ==null || strId.equalsIgnoreCase("")) {
				 RequestDispatcher dispatcher = request
					.getRequestDispatcher("/ask?method=addAskForm");
			     dispatcher.forward(request, response);
			 }

		int id = Integer.parseInt(strId);

		
		Ask ask = new Ask();
		ask.setName(name);
		ask.setRegNo(regNo);
		ask.setDept(dept);
		ask.setStatus(code);
		ask.setId(id);
		
		AskDAO.updateAsk(ask);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/Ask?method=viewAskList");
		dispatcher.forward(request, response);
	}
	public static void viewAskList(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		int length = 10;
		
		
		int curPage = 1;
		
		if (request.getParameter("page") != null)
		{
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		
		List askList = AskDAO.selectAskList(curPage,length);
		
		
		int totalRows = AskDAO.selectAskRow();
		
		
		String page = PageUtil.generate(curPage, totalRows, length, "ask?method=viewAskList");
		
		
		request.setAttribute("ASK_LIST", askList);
		
		request.setAttribute("CUR_PAGE", Integer.toString(curPage));
	
		request.setAttribute("TOTAL_PAGE", page);
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask/viewAskList.jsp");
		dispatcher.forward(request, response);
	}
	
	public static void searchAskList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
        
		
      
		int length = 10;

		
		int curPage = 1;
		
		if (request.getParameter("page") != null)
		{
			curPage = Integer.parseInt(request.getParameter("page"));
		}
		String column=request.getParameter("column");
		String keyword=request.getParameter("keyword");
		
		
		List askList = 
			AskDAO.selectAskList(curPage,length,
					column,keyword);
		
        
		int totalRows = AskDAO.selectAskRow();
		
		
		String page = PageUtil.generate(curPage, totalRows, length,
				"ask?method=viewAskList&keyword="+keyword+"&column="+column);

		
		request.setAttribute("ASK_LIST", askList);
		
		request.setAttribute("CUR_PAGE", Integer.toString(curPage));
	
		request.setAttribute("TOTAL_PAGE", page);

		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/ask/viewAskList.jsp");
		dispatcher.forward(request, response);
	}

	public static void removeAsk(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String id = request.getParameter("id");
		
		
		AskDAO.deleteAsk(id);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Ask?method=viewAskList");

		dispatcher.forward(request, response);
	}

}
