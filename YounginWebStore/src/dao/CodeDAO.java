package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil;

import entity.Code;


/**
 * DB에 JDBC를 이용하여 관련 작업을 수행하는 Data Access Object.
 * 
  */
public class CodeDAO {
   
	public static List selectCodeList(String category) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List codeList = new ArrayList();
		try {
			StringBuffer sb = new StringBuffer();
			sb
					.append(" SELECT   code_name, code_value FROM code WHERE category = ?");
			psmt = con.prepareStatement(sb.toString());
			psmt.setString(1, category);
			rs = psmt.executeQuery();
        
			while (rs.next()) {
				
				Code code = new Code();
				code.setCodeName(rs.getString("code_name"));
				code.setCodeValue(rs.getString("code_value"));

			
			codeList.add(code);
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
		return codeList;
	}

	public static  Code selectCode(String category, String codeValue) throws Exception {
		
		Connection con = null;	
		/*DB접속*/
		con = ConnectionUtil.getConnection();
		
		

		
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		Code code = null;
		try {
           
			StringBuffer sb = new StringBuffer();
			
			sb
					.append(" SELECT   code_name, code_value FROM code WHERE code_value = ? and category= ?");
         
			psmt = con.prepareStatement(sb.toString());
			
			psmt.setString(1, codeValue);
			psmt.setString(2, category);
		
			rs = psmt.executeQuery();
			
			if(rs.next()){
			
			code = new Code();
			code.setCodeName(rs.getString("code_name"));
			code.setCodeValue(rs.getString("code_value"));
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
		
		return code;
	}
	
	public  static Code selectCode(Connection con,String category, String codeValue) throws Exception {		
		
		con = ConnectionUtil.getConnection();
		
		

		
		PreparedStatement psmt = null;
		ResultSet rs = null;
	
		Code code = null;
		try {

			StringBuffer sb = new StringBuffer();
			sb
					.append(" SELECT   code_name, code_value FROM code WHERE code_value = ? and category= ?");

			psmt = con.prepareStatement(sb.toString());
			psmt.setString(1, codeValue);
			psmt.setString(2, category);
			rs = psmt.executeQuery();
			rs.next();
			
			code = new Code();
			code.setCodeName(rs.getString("code_name"));
			code.setCodeValue(rs.getString("code_value"));

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
		return code;
	}
}
