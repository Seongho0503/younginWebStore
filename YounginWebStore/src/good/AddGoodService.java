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
		 // 저장할 디렉토리 (절대경로)
         PrintWriter out=response.getWriter();
		 int sizeLimit = 5 * 1024 * 1024 ; 
		 // 5메가까지 제한 넘어서면 예외발생
		 try{
			MultipartRequest multi=
				new MultipartRequest(request, savePath, 
						sizeLimit,"euc-kr",
						new DefaultFileRenamePolicy());
		 	Enumeration formNames=multi.getFileNames();  // 폼의 이름 반환
			String formName=(String)formNames.nextElement(); // 자료가 많을 경우엔 while 문을 사용
			//업로드되서 저장된 파일 이름 
			String fileName=multi.getFilesystemName(formName); // 파일의 이름 얻기
		    //클라이언트가 선택했던 파일이름
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
			if(fileName == null) {   // 파일이 업로드 되지 않았을때
				out.print("파일 업로드 되지 않았음");
			} else {  // 파일이 업로드 되었을때
				fileName=
					new String(fileName.getBytes("euc-kr")
							,"euc-kr"); // 한글인코딩 - 브라우져에 출력
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