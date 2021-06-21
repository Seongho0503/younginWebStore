package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;
import customer.Customer;

public class CustomerDAO {
public static void updateCustomer(Customer customer)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try{
			conn=ConnectionUtil.getConnection();
			
			if(selectCustomer(customer.getM_id())==null)
			   throw new Exception("존재하지 않는 회원입니다.");
			

			sql="UPDATE member set " +
					"m_name=?,m_pw=?,email=?,address=?,dept=?,s_no=? WHERE m_id=? ";
		
			psmt=conn.prepareStatement(sql);
			
		   psmt.setString(1, customer.getM_name());
		   psmt.setString(2, customer.getM_pw());
		   psmt.setString(3, customer.getEmail());
		   psmt.setString(4, customer.getAddress());
		   psmt.setString(5, customer.getDept());
		   psmt.setString(6, customer.getS_no());
		   psmt.setString(7, customer.getM_id());
		 
		  psmt.executeUpdate();

		}catch(Exception e){e.printStackTrace();
		}finally{
			psmt.close();
			conn.close();
		}
	}
	
	public static void insertCustomer(Customer customer)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try{

			conn=ConnectionUtil.getConnection();
			
			if(selectCustomer(customer.getM_id())!= null)
				throw new Exception("존재하는 회원입니다.");
			
			sql="INSERT INTO member (m_name, m_id, m_pw, email, address, dept, S_NO)" +
					"  VALUES (?,?,?,?,?,?,?)";
			
		
			psmt=conn.prepareStatement(sql);
			
		    psmt.setString(1, customer.getM_name());
		    psmt.setString(2, customer.getM_id());
		    psmt.setString(3, customer.getM_pw());
		    psmt.setString(4, customer.getEmail());
		    psmt.setString(5, customer.getAddress());
		    psmt.setString(6, customer.getDept());
		    psmt.setString(7, customer.getS_no());
			
			psmt.executeUpdate();

		}catch(Exception e){e.printStackTrace();
		}finally{
			psmt.close();
			conn.close();
		}
	}
	
	public static Customer selectCustomer(String customerId)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		Customer customer=null;
		try{
			conn=ConnectionUtil.getConnection();
			
			sql="SELECT m_name,m_pw,email,address,dept,s_no FROM Member WHERE m_id=?";
			
			psmt=conn.prepareStatement(sql);
	      
            psmt.setString(1,customerId);
			
            rs=psmt.executeQuery();
			
            if(rs.next()){
            	customer=new Customer();
            	customer.setM_name(rs.getString(1));
            	customer.setM_pw(rs.getString(2));
            	customer.setEmail(rs.getString(3));
            	customer.setAddress(rs.getString(4));
            	customer.setDept(rs.getString(5));
            	customer.setS_no(rs.getString(6));
            	customer.setM_id(customerId);
            }
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return customer;
	}
	public static void setTempId(String id) throws SQLException {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		try{

			conn=ConnectionUtil.getConnection();
			sql="update tempId set tempId=? where num='1'";
			psmt=conn.prepareStatement(sql);
		    psmt.setString(1, id);
			psmt.executeUpdate();

		}catch(Exception e){e.printStackTrace();
		}finally{
			psmt.close();
			conn.close();
		}
	}
public static String getWriter()throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		String writer=null;
		try{
			conn=ConnectionUtil.getConnection();
			sql="select tempid from tempId where num='1'";
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()){
				writer = rs.getString(1);
			}
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return writer;
	}
}