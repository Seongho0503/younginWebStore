package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;

import entity.Dept;
import entity.Ask;


/**
 * DB에 JDBC를 이용하여 관련 작업을 수행하는 Data Access Object.
 * 
  */

public class DeptDAO {
   
    public static void insertDept(Dept dept) throws Exception {
    	
		Connection con = ConnectionUtil.getConnection();
		// 트랜잭션을 개발자가 직접 컨트롤 하기 위해서 AutoCommit을 false로 설정
		con.setAutoCommit(false);
		PreparedStatement psmt = null;
		try {
            /*Insert 쿼리를 저장하는 StringBuffer 객체를 저장*/ 
			StringBuffer sb = new StringBuffer();
			sb.append(" INSERT INTO dept  ");
			sb.append(" ( DEPT_CD, DEPT_NAME, PRICE, MAX_CNT) values  ");
			sb.append("(?, ?, ?, ?)");
			
			psmt = con.prepareStatement(sb.toString());
			
			psmt.setString(1, dept.getCode());
			psmt.setString(2, dept.getName());
			psmt.setString(3, dept.getPrice());
			psmt.setInt(4, dept.getMaxAskCnt());
           
			psmt.executeUpdate();
			/*Insert 쿼리를 커밋*/
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			psmt.close();
			con.close();
		}
	}
   
	public  static void updateDept(Dept dept) throws Exception {
		/*DB에 접속*/
		Connection con = ConnectionUtil.getConnection();
		
		con.setAutoCommit(false);
		PreparedStatement psmt = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append(" UPDATE dept SET ");
			sb.append("  DEPT_NAME = ? , MAX_CNT = ?   ");
			sb.append(" WHERE DEPT_CD = ? AND PRICE = ?");
			
			psmt = con.prepareStatement(sb.toString());
			
			psmt.setString(1, dept.getName());
			psmt.setInt(2, dept.getMaxAskCnt());
			psmt.setString(3, dept.getCode());
			psmt.setString(4, dept.getPrice());
			
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
	
	public  static Dept selectDept(String dept_cd) throws Exception {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		Dept dept = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb
					.append("SELECT DEPT_CD, DEPT_NAME, MAX_CNT,PRICE FROM dept WHERE DEPT_CD = ?");
		
			psmt = con.prepareStatement(sb.toString());
			
			psmt.setString(1, dept_cd);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
			
			
			dept = new Dept();
			
			dept.setCode(rs.getString("DEPT_CD"));
			dept.setName(rs.getString("DEPT_NAME"));
			dept.setMaxAskCnt(rs.getInt("MAX_CNT"));
			dept.setPrice(rs.getString("PRICE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			con.close();
		}
	
		return dept;
	}
	
	public  static Dept selectDept(Connection con, String dept_cd) throws Exception {
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Dept dept = null;
		try {

			StringBuffer sb = new StringBuffer();
			sb
					.append("SELECT DEPT_CD, DEPT_NAME, MAX_CNT,PRICE FROM dept WHERE DEPT_CD = ?");

			psmt = con.prepareStatement(sb.toString());

			psmt.setString(1, dept_cd);

			rs = psmt.executeQuery();
			if(rs.next()){
			
			dept = new Dept();
			dept.setCode(rs.getString("DEPT_CD"));
			dept.setName(rs.getString("DEPT_NAME"));
			dept.setMaxAskCnt(rs.getInt("MAX_CNT"));
			dept.setPrice(rs.getString("PRICE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}

		}
		return dept;
	}

	
	public  static List selectDeptList() throws Exception {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List deptList = new ArrayList();
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT   DEPT_CD, DEPT_NAME, MAX_CNT,PRICE FROM dept order by DEPT_CD desc");
			
			psmt = con.prepareStatement(sb.toString());
			
			rs = psmt.executeQuery();

			while (rs.next()) {
			
				Dept dept = new Dept();
				
				dept.setCode(rs.getString("DEPT_CD"));
				dept.setName(rs.getString("DEPT_NAME"));
				dept.setMaxAskCnt(rs.getInt("MAX_CNT"));
				dept.setPrice(rs.getString("PRICE"));
				
				deptList.add(dept);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			con.close();
		}
	
		return deptList;
	}

	
	public  static List selectDeptList(String price_cd) throws Exception {
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
	
		List deptList = new ArrayList();
		try {
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT   DEPT_CD, DEPT_NAME  FROM dept WHERE price = ?");
			
			psmt = con.prepareStatement(sb.toString());
		
			psmt.setString(1, price_cd);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				Dept dept = new Dept();
				
				dept.setCode(rs.getString("DEPT_CD"));
				dept.setName(rs.getString("DEPT_NAME"));
				
				deptList.add(dept);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			con.close();
		}
		
		return deptList;
	}
}
