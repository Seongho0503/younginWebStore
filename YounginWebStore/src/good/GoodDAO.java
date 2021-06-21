package good;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import util.ConnectionUtil;




public class GoodDAO {
	
	public static String getGid()throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		long gid=0;
		try{
			conn=ConnectionUtil.getConnection();
		
			sql="SELECT max(gid) FROM good";
		
			psmt=conn.prepareStatement(sql);
           
			rs=psmt.executeQuery();
		
			if(rs.next())
				gid=rs.getLong(1);
			
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
	   
        return new Long(++gid).toString();
	} 

 public static void insertGood(Good good)throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		try{
			
			conn=ConnectionUtil.getConnection();
			
			sql="INSERT INTO good (gid,gname,price,detail,image) VALUES (?,?,?,?,?)";
			
        	psmt=conn.prepareStatement(sql);
			
        	psmt.setString(1, good.getGid());
        	psmt.setString(2,good.getGname());
        	psmt.setLong(3, good.getPrice());
        	psmt.setString(4,good.getDetail());
        	psmt.setString(5,good.getImage());
        	
        	psmt.executeUpdate();
	        
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
		
	}
	
	public static Good selectGood(String gid)throws Exception {

		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		Good good=null;
		try{
			conn=ConnectionUtil.getConnection();
			
			sql="SELECT gname,price,detail,image FROM good WHERE gid=?";
		
			psmt=conn.prepareStatement(sql);
        	
			psmt.setString(1, gid);
        	
			rs=psmt.executeQuery();
		
			if(rs.next()){
				good=new Good();
				good.setGid(gid);
				good.setGname(rs.getString(1));
				good.setPrice(rs.getLong(2));
				good.setDetail(rs.getString(3));
				good.setImage(rs.getString(4));
			}
	        
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
		return good;
	}
	
	public static ArrayList selectGoodList()throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList <Good>list =new ArrayList<Good>();
		try{
		conn=ConnectionUtil.getConnection();
		
		sql="SELECT gid,gname,price,detail,image FROM good";
	   
		psmt=conn.prepareStatement(sql);
		
		rs=psmt.executeQuery();
	
		while(rs.next()){
			Good good=new Good();
			good.setGid(rs.getString(1));
			good.setGname(rs.getString(2));
			good.setPrice(rs.getLong(3));
			good.setDetail(rs.getString(4));
			good.setImage(rs.getString(5));
			list.add(good);
		}
		
			
			
		}catch(Exception e){e.printStackTrace();
		}finally{
			try{psmt.close();}catch(Exception e){}
			try{conn.close();}catch(Exception e){}
		}
		return list;
	}
	public static void main(String args[])
	  throws Exception{
		Good newGood=new Good();
		newGood.setGid(GoodDAO.getGid());
		newGood.setGname("잭필드3종셋트");
		newGood.setPrice(39000);
		newGood.setImage("jack.gif");
		newGood.setDetail("놀라지 마십시오" +
				" 잭필드 3종셋트" +
				"단돈 3만 9천원!!!");
		GoodDAO.insertGood(newGood);
		
		
		ArrayList<Good> list=GoodDAO.selectGoodList();
		for(int i=0;i<list.size();i++){
			Good good=list.get(i);
			System.out.println(good.getGid());
			System.out.println(good.getGname());
			System.out.println(good.getPrice());
			System.out.println(good.getImage());
			System.out.println(good.getDetail());
			System.out.println("==================");
		}
		Good pin=GoodDAO.selectGood("1030");
		System.out.println("==================");
		System.out.println("gid 1030의 검색 결과");
		System.out.println(pin.getGid());
		System.out.println(pin.getGname());
		System.out.println(pin.getPrice());
		System.out.println(pin.getImage());
		System.out.println(pin.getDetail());
		System.out.println("==================");
	}
}










