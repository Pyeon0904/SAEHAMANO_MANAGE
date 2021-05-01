package mvc.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static mvc.common.jdbc.JDBCTemplate.*;

import mvc.login.model.vo.Admin;

public class AdminDAO {

	public Admin findMemberById(Connection connection, String id) {
		Admin admin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			query ="SELECT * FROM ADMIN WHERE ID=? AND STATUS='Y'";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				admin = new Admin();
				
				admin.setNo(rs.getInt("NO"));
				admin.setId(rs.getString("ID"));
				admin.setPassword(rs.getString("PASSWORD"));
				admin.setStatus(rs.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}	
		return admin;
	}
/*
	public int updateAdmin(Connection connection, Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	public int insertAdmin(Connection connection, Admin admin) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			query = "INSERT INTO ADMIN VALUES(SEQ_ADMIN_NO.NEXTVAL,?,?,DEFAULT)";
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int confirmSecurity(Connection connection, String adminKey) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		
		try {
			query ="SELECT SECURITY FROM SECURITY WHERE SECURITY=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1,adminKey);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				result = 1;


			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}	
		return result;

	}
}
