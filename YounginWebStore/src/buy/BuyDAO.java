package buy;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import util.ConnectionUtil;
import customer.Customer;
import good.Good;



public class BuyDAO {
	
	public static long getBuyId()throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		long buyId=0;
		try{
			conn=ConnectionUtil.getConnection();
			
		    sql="SELECT max(buy_id) FROM buy";
			
		    psmt=conn.prepareStatement(sql);
           
		    rs=psmt.executeQuery();
		
		    if(rs.next())
		    	buyId=rs.getInt(1);
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
	 
        return ++buyId;
	}
	
	public static long getBuyNum()throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		long buyNum=0;
		try{ conn=ConnectionUtil.getConnection();
			
		sql="SELECT max(buy_num) FROM buy";
		
		psmt=conn.prepareStatement(sql);
         
		rs=psmt.executeQuery();
	
		if(rs.next())
			buyNum=rs.getLong(1);
		
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
	   
        return ++buyNum;
	}
	
	
	public static void insertBuy(Long buyId,Buy buy)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		try{
			conn=ConnectionUtil.getConnection();
		
			sql="INSERT INTO buy (buy_num,buy_id,gid,qty," +
					"buy_price,buy_date,m_id)" +
					" VALUES(?,?,?,?,?,now(),?)";
		
		 psmt=conn.prepareStatement(sql);
		
		 psmt.setLong(1,BuyDAO.getBuyNum());
		 psmt.setLong(2,buyId);
		 psmt.setString(3, buy.getGood().getGid());
		 psmt.setLong(4, buy.getQty());
		 psmt.setLong(5,buy.getBuyPrice());
		 psmt.setString(6, buy.getCustomer().getM_id());
		
		 psmt.executeUpdate();

		}catch(Exception e){e.printStackTrace();
		}finally{
			psmt.close();
			conn.close();
		}
	}
	public static void selectBuyDate(Buy buy)throws Exception{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Buy> list=new ArrayList<Buy>();
		try{
			conn=ConnectionUtil.getConnection();

             sql="SELECT date_format(buy_date,'YYYY-MM-DD HH24:MI:SS') FROM buy WHERE buy_id=?";
             psmt=conn.prepareStatement(sql);
             psmt.setLong(1, buy.getBuyId());
             rs=psmt.executeQuery();
             if(rs.next()){
            	 buy.setBuyDate(rs.getString(1));
             }
			
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		
	}
	
	public static ArrayList selectBuyList(String customerId)throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		Buy buy=null;
		ArrayList<Buy> list=new ArrayList<Buy>();
		try{
			conn=ConnectionUtil.getConnection();
			
             sql="SELECT buy_id,sum(buy_price) FROM buy WHERE m_id=? GROUP BY(buy_id)";
			
             psmt=conn.prepareStatement(sql);
			
             psmt.setString(1, customerId);
		
             rs=psmt.executeQuery();
	    	
             while(rs.next()){
            	 buy=new Buy();
            	 buy.setBuyId(rs.getLong(1));
               	 buy.setBuyPrice(rs.getLong(2));
            	 list.add(buy);
             }
			
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return list;
	}
	
	public static ArrayList selectBuyList(String customerId,
			long buyId)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		ArrayList <Buy>list=new ArrayList<Buy>();
		try{
			conn=ConnectionUtil.getConnection();
			
			 sql="SELECT b.buy_num,b.buy_id,b.gid," +
             		"g.gname,g.price,b.qty,b.buy_price," +
             		"date_format(b.buy_date,'%Y%m%d%H%i%s'),b.m_id,m.m_name " +
             		"  FROM buy  b,good  g, member m " +
             		"   WHERE b.gid=g.gid AND " +
             		"   m.m_id=b.m_id " +
             		"   AND b.m_id=? AND b.buy_id=?";

			
			 psmt=conn.prepareStatement(sql);
	       
            psmt.setString(1, customerId);
            psmt.setLong(2, buyId);
			
            rs=psmt.executeQuery();
			
            while(rs.next()){
            	Buy buy=new Buy();
            	buy.setBuyNum(rs.getLong(1));
            	buy.setBuyId(rs.getLong(2));
            	Good good=new Good();
            	good.setGid(rs.getString(3));
            	good.setGname(rs.getString(4));
            	good.setPrice(rs.getLong(5));
            	buy.setGood(good);
            	buy.setQty(rs.getInt(6));
            	buy.setBuyPrice(rs.getLong(7));
            	buy.setBuyDate(rs.getString(8));
            	Customer customer=new Customer();
            	customer.setM_id(rs.getString(9));
            	customer.setM_name(rs.getString(10));
            	buy.setCustomer(customer);
            	list.add(buy);
            	
            }
		   
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return list;
	}
	
	public static Buy selectBuy(long buyNum)throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		Buy buy=new Buy();
		try{conn=ConnectionUtil.getConnection();
			
             sql="SELECT b.buy_num,b.buy_id,b.gid," +
             		"g.gname,g.price,b.qty,b.buy_price," +
             		"b.buy_date,b.m_id,c.m_name " +
             		"  FROM buy  b,good  g, member c " +
             		"   WHERE b.gid=g.gid AND " +
             		"   b.m_id=c.m_id " +
             		"   AND b.buy_num=?";
			
             psmt=conn.prepareStatement(sql);
	      
             psmt.setLong(1,buyNum); 
			
             rs=psmt.executeQuery();
			
		    if(rs.next()){
		    	buy.setBuyNum(rs.getLong(1));
		    	buy.setBuyId(rs.getLong(2));
		    	
		    	Good good=new Good();
		    	good.setGid(rs.getString(3));
		    	good.setGname(rs.getString(4));
		    	good.setPrice(rs.getLong(5));
		    	buy.setGood(good);
		    	
		    	buy.setQty(rs.getLong(6));
		    	buy.setBuyPrice(rs.getLong(7));
		    	buy.setBuyDate(rs.getString(8));
		    	
		    	Customer customer=new Customer();
		    	customer.setM_id(rs.getString(9));
		    	customer.setM_name(rs.getString(10));
		    	
		    	buy.setCustomer(customer);	    	
		    }
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return buy;
	}
	
	
	
	
	
	
  public static	void main(String args[])throws Exception{
	  ArrayList <Buy>list=BuyDAO.selectBuyList("guest",1);
	  for(int i=0;i<list.size();i++){
		Buy buy=list.get(i);
	   System.out.println("buyId:"+buy.getBuyId());
	  System.out.println("buyNum:"+buy.getBuyNum());
	  System.out.println("gid:"+buy.getGood().getGid());
	  System.out.println("gname:"+buy.getGood().getGname());
	  System.out.println("price:"+buy.getGood().getPrice());
	  System.out.println("qty:"+buy.getQty());
	  System.out.println("buyPrice:"+buy.getBuyPrice());
	  System.out.println("buyDate:"+buy.getBuyDate());
	  System.out.println("customerId:"+
			  buy.getCustomer().getM_id());
	  System.out.println("customerName:"+
			  buy.getCustomer().getM_name());
	  }
	
	    
  } 
   
}





















