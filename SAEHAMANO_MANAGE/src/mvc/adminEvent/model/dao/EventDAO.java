//2021-04-30 19:33 이재용
package mvc.adminEvent.model.dao;

import static mvc.common.jdbc.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.adminEvent.model.vo.Event;



public class EventDAO {

	public int getAdminCount(Connection connection) {
		int count =0;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		String query = null;
		
		try {
			query = "SELECT COUNT(*) FROM EVENT WHERE STATUS='Y'";
			pstmt = connection.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}

	public List<Event> findAll(Connection connection) {
		List<Event> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			query = "    SELECT RNUM, EVENT_NO, EVENT_NAME , EVENT_START_DATE, EVENT_LAST_DATE ,STATUS, EVENT_IMG, EVENT_CONTENT "
					+ "					FROM ( "
					+ "						    SELECT ROWNUM AS RNUM, EVENT_NO, EVENT_NAME, EVENT_START_DATE, EVENT_LAST_DATE, STATUS, EVENT_IMG, EVENT_CONTENT "
					+ "						    FROM ( "
					+ "						        SELECT  E.EVENT_NO, E.EVENT_NAME, E.EVENT_START_DATE, E.EVENT_LAST_DATE, E.STATUS, E.EVENT_IMG, EVENT_CONTENT "
					+ "						        FROM EVENT E "
					+ "						        WHERE E.STATUS = 'Y'  ORDER BY E.EVENT_NO DESC "
					+ "						    ) "
					+ "						) ";
			pstmt = connection.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Event event = new Event();
				
				event.setEvent_no(rs.getInt("EVENT_NO"));
				event.setRowNum(rs.getInt("RNUM"));
				event.setEvent_name(rs.getString("EVENT_NAME"));
				event.setEvent_start_date(rs.getString("EVENT_START_DATE"));
				event.setEvent_last_date(rs.getString("EVENT_LAST_DATE"));
				event.setStatus(rs.getString("STATUS"));
				event.setEvent_img(rs.getString("EVENT_IMG"));
				event.setEvent_content(rs.getString("EVENT_CONTENT"));
				list.add(event);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	
	}

	public int insertEvent(Connection connection, Event event) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			query = "INSERT INTO EVENT VALUES(SEQ_EVENT_CODE.NEXTVAL, ?,?,?,?,?,?,?,?,?,NULL,NULL,DEFAULT)";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, event.getEvent_name());
			pstmt.setString(2, event.getEvent_start_date());
			pstmt.setString(3, event.getEvent_last_date());
			pstmt.setString(4, event.getEvent_content());
			pstmt.setString(5, event.getEvent_insta());
			pstmt.setString(6, event.getEvent_home());
			pstmt.setString(7, event.getEvent_place());
			pstmt.setString(8, event.getEvent_hosting());
			pstmt.setString(9, event.getEvent_img());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Event findEventByNo(Connection connection, int eventNo) {
		Event event = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		
		try {
			query = " SELECT  EVENT_NO, EVENT_NAME,EVENT_START_DATE, EVENT_LAST_DATE, EVENT_CONTENT, EVENT_INSTA, EVENT_HOME, "
					+ "    EVENT_PLACE, EVENT_HOSTING, EVENT_IMG, ORIGINAL_FILENAME, RENAMED_FILENAME "
					+ "					FROM EVENT  "
					+ "					WHERE STATUS = 'Y' AND EVENT_NO=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, eventNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				event = new Event();
				event.setEvent_no(rs.getInt("EVENT_NO"));
				event.setEvent_name(rs.getString("EVENT_NAME"));
				event.setEvent_start_date(rs.getString("EVENT_START_DATE"));
				event.setEvent_last_date(rs.getString("EVENT_LAST_DATE"));
				event.setEvent_content(rs.getString("EVENT_CONTENT"));
				event.setEvent_insta(rs.getString("EVENT_INSTA"));
				event.setEvent_home(rs.getString("EVENT_HOME"));
				event.setEvent_place(rs.getString("EVENT_PLACE"));
				event.setEvent_hosting(rs.getString("EVENT_HOSTING"));
				event.setEvent_img(rs.getString("EVENT_IMG"));
				event.setOriginal_FileName(rs.getString("ORIGINAL_FILENAME"));
				event.setRenamed_FileName(rs.getString("RENAMED_FILENAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return event;
	}

	public int updateEvent(Connection connection, Event event) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			query = "UPDATE EVENT SET EVENT_NAME=?,EVENT_START_DATE=?, EVENT_LAST_DATE=?, "
				+ " EVENT_CONTENT =?, EVENT_INSTA =?, EVENT_HOME =?, "
				+ "	EVENT_PLACE =?, EVENT_HOSTING =?, EVENT_IMG =? "
				+ " WHERE EVENT_NO=?";
			pstmt= connection.prepareStatement(query);
			
			pstmt.setString(1, event.getEvent_name());
			pstmt.setString(2, event.getEvent_start_date());
			pstmt.setString(3, event.getEvent_last_date());
			pstmt.setString(4, event.getEvent_content());
			pstmt.setString(5, event.getEvent_insta());
			pstmt.setString(6, event.getEvent_home());
			pstmt.setString(7, event.getEvent_place());
			pstmt.setString(8, event.getEvent_hosting());
			pstmt.setString(9, event.getEvent_img());
			pstmt.setInt(10, event.getEvent_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateStatus(Connection connection, int eventNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		try {
			query = "UPDATE EVENT SET STATUS=? WHERE EVENT_NO=? ";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, status);
			pstmt.setInt(2, eventNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
