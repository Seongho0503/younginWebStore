package good;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class for Servlet: AddGoodService
 *
 */

 public class AddGoodService extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddGoodService() {
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
		response.setContentType("text/html;charset=euc-kr");
		String savePath=
			 getServletContext().getRealPath("/image"); 
		 // ������ ���丮 (������)
         PrintWriter out=response.getWriter();
		 int sizeLimit = 5 * 1024 * 1024 ; 
		 // 5�ް����� ���� �Ѿ�� ���ܹ߻�
		 try{
			MultipartRequest multi=
				new MultipartRequest(request, savePath, 
						sizeLimit,"euc-kr",
						new DefaultFileRenamePolicy());
		 	Enumeration formNames=multi.getFileNames();  // ���� �̸� ��ȯ
			String formName=(String)formNames.nextElement(); // �ڷᰡ ���� ��쿣 while ���� ���
			//���ε�Ǽ� ����� ���� �̸� 
			String fileName=multi.getFilesystemName(formName); // ������ �̸� ���
		    //Ŭ���̾�Ʈ�� �����ߴ� �����̸�
			String originalName=
		    	multi.getOriginalFileName(formName);
			
			String gname=multi.getParameter("gname");
			String price=multi.getParameter("price");
			String detail=multi.getParameter("detail");
			
			Good good=new Good();
			good.setGid(GoodDAO.getGid());
			good.setGname(gname);
			long longPrice=0;
			if(price!=null)
				longPrice=Long.parseLong(price);
			good.setPrice(longPrice);
			good.setDetail(detail);
			good.setImage(fileName);
			
			GoodDAO.insertGood(good);
			
			response.sendRedirect(
					request.getContextPath()+"/Good?method=addGoodComplete");
			if(fileName == null) {   // ������ ���ε� ���� �ʾ�����
				out.print("���� ���ε� ���� �ʾ���");
			} else {  // ������ ���ε� �Ǿ�����
				fileName=
					new String(fileName.getBytes("euc-kr")
							,"euc-kr"); // �ѱ����ڵ� - �������� ���
				out.print("Form Name : " + formName + "<BR>");
				out.print("File Name  : " + fileName+"<br>");
				out.print("gname:"+gname+"<br>");
				out.print("price:"+price+"<br>");
				out.print("detail:"+detail+"<br>");
			} 
			
		 } catch(Exception e) {
			e.printStackTrace();
		 } 
	}   	  	    
}