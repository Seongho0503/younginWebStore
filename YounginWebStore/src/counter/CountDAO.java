package counter;

import good.Good;
import good.GoodDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import counter.Counter;

import util.ConnectionUtil;

public class CountDAO {
public static ArrayList selectCountList()throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList <Counter>list =new ArrayList<Counter>();
		try{
		conn=ConnectionUtil.getConnection();
		
		sql="select d.access_time,d.session_id,d.login_count,m.m_name,m.email,m.dept from dbcounter d,member m where d.session_id= m.m_id";
	  
		psmt=conn.prepareStatement(sql);
		
		rs=psmt.executeQuery();
		while(rs.next()){
			if((rs.getString(2)).equals("admin") != true){
				Counter counter=new Counter();
				counter.setAccess_time(rs.getString(1));
				counter.setSession_id(rs.getString(2));
				counter.setLogin_count(rs.getString(3));
				counter.setMember_name(rs.getString(4));
				counter.setEmail(rs.getString(5));
				counter.setDept(rs.getString(6));
				list.add(counter);
			}
		}
		
			
			
		}catch(Exception e){e.printStackTrace();
		}finally{
			try{psmt.close();}catch(Exception e){}
			try{conn.close();}catch(Exception e){}
		}
		return list;
	}
	public static Counter selectSessionId(String mId)throws Exception {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		Counter counter=null;
		try{
			conn=ConnectionUtil.getConnection();
			sql="SELECT login_count FROM dbcounter where session_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,mId);
			rs=psmt.executeQuery();
			if(rs.next()){
            	counter=new Counter();
            	counter.setLogin_count(rs.getString(1));
            	counter.setSession_id(mId);
            }
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return counter;
	}
	public static void count(String mId) throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		
		try{
			conn=ConnectionUtil.getConnection();
			if((selectSessionId(mId)!= null) && (selectAccessTime()!=null)){  //존재한다면
				sql="UPDATE dbcounter set login_count=? WHERE session_id=?";
	        	psmt=conn.prepareStatement(sql);
	        	psmt.setString(1, CountDAO.getLoginCount(mId));
	        	psmt.setString(2,mId);
	        	psmt.executeUpdate();
			}else{
				sql="insert into dbcounter values(now(), ?, '1')";
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, mId);
				psmt.executeUpdate();
			}
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	if(psmt != null)
	    		psmt.close();
	    	if(conn != null)
	    		conn.close();
	    }
	}
	private static Counter selectAccessTime() throws SQLException {
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		Counter counter=null;
		try{
			conn=ConnectionUtil.getConnection();
			Calendar cal = Calendar.getInstance();
			java.util.Date currentTime=cal.getTime();
			SimpleDateFormat formatter=new SimpleDateFormat("yy/MM/dd");
			String sTimestr=formatter.format(currentTime);
			
			sql="SELECT login_count FROM dbcounter where access_time=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, sTimestr);
			rs=psmt.executeQuery();
			if(rs.next()){
            	counter=new Counter();
            	counter.setLogin_count(rs.getString(1));
            }
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	psmt.close();	
	    	conn.close();
	    }
		return counter;
	}
	public static String getLoginCount(String mId)throws Exception {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql=null;
		//Good good=null;
		long count=0;
		try{
			conn=ConnectionUtil.getConnection();
			sql="SELECT login_count FROM dbcounter where session_id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,mId);
			rs=psmt.executeQuery();
			if(rs.next()){
				count=rs.getLong(1);
			}
		}catch(Exception e){e.printStackTrace();
	    }finally{
	    	try{rs.close();}catch(Exception e){ }
	    	try{psmt.close();}catch(Exception e){ }
	    	try{conn.close();}catch(Exception e){ }
	    }
	  
        return new Long(++count).toString();
	} 
}