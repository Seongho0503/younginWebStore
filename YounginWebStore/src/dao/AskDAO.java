 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import util.ConnectionUtil;

import entity.Code;
import entity.Dept;
import entity.Ask;


/**
 * DB에 JDBC를 이용하여 관련 작업을 수행하는 Data Access Object.
 * 
  */
public class AskDAO {
	
    
	
	public  static void insertAsk(Ask ask)
			throws Exception {
		//DB 접속
		Connection con = ConnectionUtil.getConnection();
		//트랜잭션을 개발자가 직접 컨트롤 하기 위해서 AutoCommit을 false로 설정
		con.setAutoCommit(false);
		PreparedStatement psmt = null;
		try {
			/*StringBuffer 객체를 생성하고 
			 * INSERT 쿼리를 저장*/
			StringBuffer sb = new StringBuffer();
			sb.append(" INSERT into ASK(id, reqNo, name, ");
			sb.append(" dept, status,dat,details,writer) ");
			sb.append(" VALUES(?, ?, ?, ?, ?,now(),?,?) ");			
			/*INSERT 쿼리를 실행하는 PreparedStatement 객체 생성*/
			psmt = con.prepareStatement(sb.toString());
			
			psmt.setInt(1, getNextId(con));
			
			psmt.setString(2, ask.getRegNo());
			psmt.setString(3, ask.getName());			
			psmt.setString(4, ask.getDept().getCode());
			psmt.setString(5, ask.getStatus().getCodeValue() );
			psmt.setString(6, ask.getDetails());
			psmt.setString(7, ask.getWriter());
			
			
			psmt.executeUpdate();
		
			con.commit();
		} catch (SQLException e) {

			con.rollback();
			e.printStackTrace();
		} finally {
			psmt.close();
			con.close();
		}
	}
	
	
	public  static Ask selectAsk(int id) throws Exception {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		Ask ask = null;
		ResultSet rs = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb	.append(" SELECT   s.id, s.reqNo, s.name,");
			sb.append("s.dept,d.dept_name, s.status,c.code_name,s.dat,s.details,s.writer");
			sb.append(" FROM ASK s,dept d,code c  WHERE s.id = ?  and " +
					"s.dept=d.dept_cd and c.code_value=s.status order by id desc");
			
			psmt = con.prepareStatement(sb.toString());
		
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
		
			if(rs.next()){
				
				ask = new Ask();
			
				ask.setId(rs.getInt(1));
				ask.setRegNo(rs.getString(2));			
				ask.setName(rs.getString(3));
				
				Dept dept = new Dept();
				
				dept.setCode(rs.getString(4));
				
				dept.setName(rs.getString(5));
				
				ask.setDept(dept);	
				
				Code code = new Code();
				
				code.setCodeValue(rs.getString(6));
				
				code.setCodeName(rs.getString(7));
				
				ask.setDat(rs.getString(8));
				ask.setDetails(rs.getString(9));
				ask.setWriter(rs.getString(10));
				ask.setStatus(code);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			psmt.close();
			con.close();
		}
		return ask;
	}
	
	public  static void updateAsk(Ask ask)
			throws Exception {
		
		Connection con = ConnectionUtil.getConnection();

		con.setAutoCommit(false);
		PreparedStatement psmt = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" UPDATE ASK SET ");
			sb.append(" name = ?,");
			sb.append("dept = ?, reqno = ?  ");
			sb.append(" WHERE id = ? ");
			
			
			psmt = con.prepareStatement(sb.toString());			
			
			psmt.setString(1,ask.getName());
			psmt.setString(2, ask.getDept().getCode());
			psmt.setString(3, ask.getRegNo());
			psmt.setString(4,Integer.toString(ask.getId()));
			
			psmt.executeUpdate();
		
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			psmt.close();
			con.close();
		}
	}
	
	public  static List selectAskList1() throws Exception {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		Ask ask = null;
		ResultSet rs = null;
		List askList = new ArrayList();
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT  id, reqNo, name,  ");
			sb.append("dept, status,dat FROM ASK");
			
			psmt = con.prepareStatement(sb.toString());
			//SELECT 쿼리 실행
			rs = psmt.executeQuery();

			while (rs.next()) {
				
				ask = new Ask();
				
				ask.setId(rs.getInt(1));
				ask.setRegNo(rs.getString(2));			
				ask.setName(rs.getString(3));
				
				Dept dept = new Dept();
			
				dept.setCode(rs.getString(4));
				
				dept.setName(rs.getString(5));
				
				ask.setDept(dept);	
				
				Code code = new Code();
				
				code.setCodeValue(rs.getString(6));
				
				code.setCodeName(rs.getString(7));
				
				ask.setDat(rs.getString(8));
				ask.setStatus(code);
				
				askList.add(ask);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
			rs.close();
			}
			if(psmt != null){
			psmt.close();
			}
			con.close();
		}
		return askList;
	}
	
	public  static List selectAskList(int page,int length) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		Ask ask = null;
		ResultSet rs = null;
		List askList = new ArrayList();
		
		
		try {			
			
			StringBuffer sb = new StringBuffer();
		
			sb	.append(" SELECT   s.id, s.reqNo, s.name,");
			sb.append("s.dept,d.dept_name, s.status,c.code_name,s.dat,s.writer");
			sb.append(" FROM ASK s,dept d,code c  WHERE " +
					"s.dept=d.dept_cd and c.code_value=s.status order by id desc");
			
			
			psmt =
				con.prepareStatement(
						sb.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			rs = psmt.executeQuery();

			if (page > 1) {
			
				absolute(rs,(page - 1) * length);
			}
			int recCount = 0;
			
			while ((recCount++ < length) && rs.next()) {

				ask = new Ask();
				
				ask.setId(rs.getInt(1));
				ask.setRegNo(rs.getString(2));			
				ask.setName(rs.getString(3));
				
				Dept dept = new Dept();
				
				dept.setCode(rs.getString(4));
				
				dept.setName(rs.getString(5));
				
				ask.setDept(dept);	
				
				Code code = new Code();
				
				code.setCodeValue(rs.getString(6));
				
				code.setCodeName(rs.getString(7));
				
				ask.setDat(rs.getString(8));
				ask.setWriter(rs.getString(9));
				ask.setStatus(code);
				askList.add(ask);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
			rs.close();
			}
			if(psmt != null){
			psmt.close();
			}
			con.close();
		}
		return askList;
	}
	
	public  static List selectAskList
	  (int page,int length,String column,String keyword) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		Ask ask = null;
		ResultSet rs = null;
		List askList = new ArrayList();
		
		
		try {			
		
			StringBuffer sb = new StringBuffer();
			
			sb	.append(" SELECT   s.id, s.reqNo, s.name,");
			sb.append("s.dept,d.dept_name, s.status,c.code_name,s.dat");
			sb.append(" FROM ASK s,dept d,code c  WHERE " +
					"s.dept=d.dept_cd and c.code_value=s.status " +
					" " +
					"and "+column+" like '%"+keyword+"%'");
			
			
			psmt =
				con.prepareStatement(
						sb.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			
			rs = psmt.executeQuery();
			
			if (page > 1) {
				
				absolute(rs,(page - 1) * length);
			}
			int recCount = 0;
			
			while ((recCount++ < length) && rs.next()) {

				ask = new Ask();
				
				ask.setId(rs.getInt(1));
				ask.setRegNo(rs.getString(2));			
				ask.setName(rs.getString(3));
				
				
				Dept dept = new Dept();
				
				dept.setCode(rs.getString(4));
			
				dept.setName(rs.getString(5));
				
				ask.setDept(dept);	
				
				Code code = new Code();
				
				code.setCodeValue(rs.getString(6));
				
				code.setCodeName(rs.getString(7));
				
				ask.setDat(rs.getString(8));
				ask.setStatus(code);
				askList.add(ask);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
			rs.close();
			}
			if(psmt != null){
			psmt.close();
			}
			con.close();
		}
		return askList;
	}
	
	public  static int selectAskRow() throws Exception {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;		
		ResultSet rs = null;
		int cnt =0;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from ASK ");
			
			psmt = con.prepareStatement(sb.toString());
			
			rs = psmt.executeQuery();
			
			rs.next();
			
			cnt = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			psmt.close();
			con.close();
		}
		return cnt;
	}
	
	
	public  static void deleteAsk(String id) throws Exception {
		
		Connection con = ConnectionUtil.getConnection();

		con.setAutoCommit(false);
		PreparedStatement psmt = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" DELETE FROM ASK");
			sb.append(" WHERE Id = ? ");
			
			psmt = con.prepareStatement(sb.toString());
           
			psmt.setString(1, id);
		
			psmt.executeUpdate();
		
			con.commit();
		} catch (SQLException e) {
		
			con.rollback();
			e.printStackTrace();
		} finally {
			psmt.close();
			con.close();
		}
	}

   
	private  static int getNextId(Connection con ) throws Exception{		
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int nextId = 1;
				try {
				psmt = con.prepareStatement("select count from seqtable  WHERE tablename = 'ASK' ");
				rs = psmt.executeQuery();
			if (rs.next()){
			    nextId = rs.getInt(1)+1;
				psmt = con.prepareStatement("update seqtable set count = ?  WHERE tablename = 'ASK' ");
			}	else{
				psmt = con.prepareStatement("insert into seqtable (count,tablename) values ( ? ,'ASK') ");
			}		
			
			psmt.setInt(1,nextId);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			psmt.close();
		}
		return nextId;		

	}
	private  static void absolute(ResultSet rs, int row) throws SQLException {
		int rsType = rs.getType();
		
		switch(rsType) {
			case ResultSet.TYPE_FORWARD_ONLY:
				for (int i = 0; i < row; i++) {
					rs.next();
				}
				break;
			
			default:
				rs.absolute(row);
		}
	}
}
