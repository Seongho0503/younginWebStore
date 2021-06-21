package buy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import good.Good;


 public class CartService extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    
	public CartService() {
		super();
	}   	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");	
		String gid = request.getParameter("gid");
		
		if(gid==null){
			response.sendRedirect(
					request.getContextPath()+"/Good");
			return;
		}
	
		HttpSession session=request.getSession(false);
		if(session==null){
			RequestDispatcher rd=
				request.getRequestDispatcher(
						"/Customer");
			rd.forward(request,response);
			return;
		}
		Object customer=session.getAttribute("CUSTOMER");
		if(customer==null){
		  RequestDispatcher rd=
				request.getRequestDispatcher(
						"/Customer");
			rd.forward(request,response);
			return;
		}
			
		String gname=request.getParameter("gname");
		String price=request.getParameter("price");
		
		Good good=new Good();
		good.setGid(gid);
		good.setGname(gname);
		good.setPrice(Long.parseLong(price));
		
		//HttpSession session=request.getSession();
		Object o=session.getAttribute("cart");
		
		ArrayList<Good> cart=new ArrayList<Good>();
		if(o!=null)
			cart=(ArrayList)o;
		
		//cart.add(good);
		
		int searchIndex=cart.indexOf(good);
		Good searchGood=null;
		if(searchIndex<0){
			cart.add(good);
		}else{
			searchGood=cart.get(searchIndex);
			searchGood.setGty(searchGood.getGty()+1);
			cart.set(searchIndex,searchGood);
		}
		
		
		
		request.setAttribute("good",good);
		session.setAttribute("cart",cart);
		
		RequestDispatcher rd=
			request.getRequestDispatcher("/good/userCart.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		 
	}   	  	    
}