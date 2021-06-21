package buy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.Customer;
import good.Good;


/**
 * Servlet implementation class for Servlet: BuyService
 *
 */
 public class BuyService extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   
	public BuyService() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method==null)
			method="addBuy";
	try{	
			if(method.equalsIgnoreCase("addBuy")){
				addBuy(request,response);
			}else if(method.equalsIgnoreCase("viewBuyList")){
				viewBuyList(request,response);
			}else if(method.equalsIgnoreCase("viewBuyDetailList")){
				viewBuyDetailList(request,response);
			}
			
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	} 
	
	public static void viewBuyDetailList(
			HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		String buyId=request.getParameter("buyId");
		
		HttpSession session=request.getSession(false);
		
		if(session==null){
			RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			rd.forward(request,response);
			return;
		}
			
		
		Object o=session.getAttribute("CUSTOMER");
		
		if(o==null){
			RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			rd.forward(request,response);
			return;
		}
		
		Customer customer=(Customer)o;
		
		ArrayList list=
			 BuyDAO.selectBuyList(customer.getM_id(), Long.parseLong(buyId));
		
		request.setAttribute("BUY_LIST",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/buy/userViewBuyDetailList.jsp");
		rd.forward(request,response);
	
	}

	public static void viewBuyList(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
	
		HttpSession session=request.getSession(false);
		
		if(session==null){
			RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			rd.forward(request,response);
			return;
		}
		
		Object o=session.getAttribute("CUSTOMER");
		
		if(o==null){
			RequestDispatcher rd=request.getRequestDispatcher("/customer/tryLogin.jsp");
			rd.forward(request,response);
			return;
		}
		
		Customer customer=(Customer)o;
		
		ArrayList <Buy>list=
			 BuyDAO.selectBuyList(customer.getM_id());
		for(int i=0;i<list.size();i++){
			Buy buy=list.get(i);
			BuyDAO.selectBuyDate(buy);
		}
	
		request.setAttribute("BUY_LIST",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/buy/userViewBuyList.jsp");
		rd.forward(request,response);
		
	}
	public static void addBuy
	  (HttpServletRequest request, HttpServletResponse response)
	 throws Exception {
		HttpSession session = request.getSession(false); 
		if(session == null){  
			response.sendRedirect(
					request.getContextPath()+"/Good");
			return; 
		}	 
		String total="0";
		ArrayList <Good>cart=new ArrayList<Good>();
		Object o=session.getAttribute("cart");
		if(o!=null)
			cart=(ArrayList)o;
		
		long totalPrice=0;
		long buyId=BuyDAO.getBuyId();
		for(int i=0;i<cart.size();i++){
			Good good=cart.get(i);
			totalPrice+=good.getPrice()*good.getGty();
			
			Buy buy=new Buy();
			buy.setGood(good);
			buy.setQty(good.getGty());
			buy.setBuyPrice(good.getGty()*good.getPrice());
			
			Object c=session.getAttribute("CUSTOMER");
			Customer customer=(Customer)c;
			buy.setCustomer(customer);
			
			BuyDAO.insertBuy(buyId, buy);
		}
			total=new Long(totalPrice).toString();
			
		
		request.setAttribute("total",total);
		
		RequestDispatcher rd=
			request.getRequestDispatcher("/good/userBuy.jsp");
		rd.forward(request,response);
	}	
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 