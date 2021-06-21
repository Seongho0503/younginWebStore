package customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import counter.CountDAO;
import customer.Customer;
import customer.CustomerDAO;

public class CustomerService extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");

		String method = request.getParameter("method");
		if(method==null){
			method="loginCustomerForm";
		}
		try{
			if(method.equals("loginCustomer")){
				loginCustomer(request,response);
			}else if(method.equals("loginCustomerForm")){
				loginCustomerForm(request,response);
			}else if(method.equals("logoutCustomer")){
				logoutCustomer(request,response);
			}else if(method.equals("addCustomer")){
				addCustomer(request,response);
			}else if(method.equals("addCustomerForm")){
				addCustomerForm(request,response);
			}else if(method.equals("editCustomerForm")){
				editCustomerForm(request,response);
			}else if(method.equals("editCustomer")){
				editCustomer(request,response);
			}else if(method.equals("userHome")){
				userHome(request,response);
			}else if(method.equals("adminHome")){
				adminHome(request,response);
			}else if(method.equals("tryLoginForm")){
				tryLoginForm(request,response);
			}
		}catch(Exception e){e.printStackTrace();}
	}
	public  void editCustomer(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
			String name=request.getParameter("customerName");
			String id=request.getParameter("customerId");
			String password=request.getParameter("customerPassword");
			String email=request.getParameter("customerEmail");
			String address=request.getParameter("customerAddress");
			String dept=request.getParameter("customerDept");
			String sno=request.getParameter("customerSno");
		
			HttpSession session=request.getSession(false);
		 
			if(session==null){
				
					 request.setAttribute("ERROR", "로그인되어있지 않습니다.");
					 RequestDispatcher rd=request.getRequestDispatcher("/Customer?method=loginCustomerForm");
					 rd.forward(request, response);
					 return;
				 }

		
		 Object o=session.getAttribute("CUSTOMER");
		 
		 
		  if(o==null){
				
			 request.setAttribute("ERROR", "로그인되어있지 않습니다.");
			 RequestDispatcher rd=request.getRequestDispatcher("/Customer?method=loginCustomerForm");
			 rd.forward(request, response);
			 return;
		 }
		 
		  Customer customer=new Customer();
		
		  customer.setM_name(name);
		  customer.setM_id(id);
		  customer.setM_pw(password);
		  customer.setEmail(email);
		  customer.setAddress(address);
		  customer.setDept(dept);
		  customer.setS_no(sno);
		 
		  CustomerDAO.updateCustomer(customer);
		 
		  session.setAttribute("CUSTOMER",customer);
		
		  RequestDispatcher rd=request.getRequestDispatcher("/customer/user.jsp");
			 rd.forward(request, response);
		}
	
	public  void editCustomerForm(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 HttpSession session=request.getSession(false);
		 
		 if(session==null){
			 RequestDispatcher rd=request.getRequestDispatcher("/Customer?method=loginCustomerForm");
			 rd.forward(request, response);
			 return;
		 }
		 
		 Object o=session.getAttribute("CUSTOMER");
		 
		
		 if(o==null){
			 RequestDispatcher rd=request.getRequestDispatcher("/Customer?method=loginCustomerForm");
			 rd.forward(request, response);
			 return;
		 }
		
		 Customer customer=(Customer)o;
		 Customer editCustomer=CustomerDAO.selectCustomer(customer.getM_id());
		 if(editCustomer==null){
			 request.setAttribute("ERROR", "존재하지 않는 회원입니다.");
			 RequestDispatcher rd=request.getRequestDispatcher("/Customer?method=loginCustomerForm");
			 rd.forward(request, response);
			 return;
		 }
		
		 RequestDispatcher rd=request.getRequestDispatcher("/customer/edit.jsp");
		 rd.forward(request, response);
	}
	
	public  void addCustomerForm(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		RequestDispatcher rd=
			request.getRequestDispatcher("/customer/apply.jsp");
		rd.forward(request, response);
	}
	public  void addCustomer
	(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String name=request.getParameter("customerName");
		String id=request.getParameter("customerId");
		String password=request.getParameter("customerPassword");
		String email=request.getParameter("customerEmail");
		String address=request.getParameter("customerAddress");
		String dept=request.getParameter("customerDept");
		String sno=request.getParameter("customerSno");
		
		
		if(CustomerDAO.selectCustomer(id)!=null){
			
			 request.setAttribute("ERROR", "존재하는 회원 아이디입니다.");
			 RequestDispatcher rd=request.getRequestDispatcher("/customer/apply.jsp");
			 rd.forward(request, response);
			 return;
		 }
		
		Customer customer=new Customer();
		 
		
		customer.setM_name(name);
		customer.setM_id(id);
		customer.setM_pw(password);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setDept(dept);
		customer.setS_no(sno);
		
		CustomerDAO.insertCustomer(customer);
	
		RequestDispatcher rd=
			request.getRequestDispatcher("/Customer?method=loginCustomerForm");
		rd.forward(request,response);
		
	}
	
	public  void logoutCustomer(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		RequestDispatcher rd=
			request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
	public  void loginCustomerForm
	(HttpServletRequest request,HttpServletResponse response) throws Exception{

		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
	public  void userHome
	(HttpServletRequest request,HttpServletResponse response) throws Exception{

		RequestDispatcher rd = request.getRequestDispatcher("/customer/user.jsp");
		rd.forward(request, response);
	}
	
	public  void adminHome
	(HttpServletRequest request,HttpServletResponse response) throws Exception{

		RequestDispatcher rd = request.getRequestDispatcher("/admin/admin.jsp");
		rd.forward(request, response);
	}
	
	public  void tryLoginForm
	(HttpServletRequest request,HttpServletResponse response) throws Exception{

		RequestDispatcher rd = request.getRequestDispatcher("/customer/tryLogin.jsp");
		rd.forward(request, response);
	}

	private void loginCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id=request.getParameter("customerId");
		String password=request.getParameter("customerPassword");
		
		Customer customer=CustomerDAO.selectCustomer(id);
		
		if(customer==null){
			request.setAttribute("ERROR", "존재하지 않는 회원아아디입니다.");
			 RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			 rd.forward(request, response);
			 return;
		}
		
		if(!customer.getM_pw().equals(password)){
			request.setAttribute("ERROR", "비밀번호 오류입니다.");
			 RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			 rd.forward(request, response);
			 return;
		}
		if(id!=null){
			CountDAO.count(id);
			CustomerDAO.setTempId(id);
		}
	
		HttpSession session=request.getSession();
		session.setAttribute("CUSTOMER",customer);
		
		if(id.equals("admin")){
			 RequestDispatcher rd=request.getRequestDispatcher("/admin/admin.jsp");
			 rd.forward(request, response);
			 return;
		}
		RequestDispatcher rd=request.getRequestDispatcher("/customer/user.jsp");
		rd.forward(request, response);
	}
}