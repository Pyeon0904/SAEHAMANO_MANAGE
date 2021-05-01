package mvc.adminCulture.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.adminCulture.model.vo.Culture;

import static mvc.common.jdbc.JDBCTemplate.*;
public class CultureDAO {
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;

	public int getCultureCount(Connection connection) {
		int count = 0;
		
		try {
			query = "SELECT COUNT(*) FROM CULTURE";
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count= rs.getInt(1);
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

	public List<Culture> findAll(Connection connection) {
		List<Culture> list = new ArrayList<>();
		
		try {
			query="SELECT RNUM, CUL_NO, CUL_NAME, CUL_CATEGORY, CUL_ERA, DEG_DATE, CUL_LOCATION "
					+ "					FROM ( "
					+ "						    SELECT ROWNUM AS RNUM, CUL_NO, CUL_NAME, CUL_CATEGORY, CUL_ERA, DEG_DATE, CUL_LOCATION "
					+ "						    FROM ( "
					+ "                        SELECT  CUL_NO, CUL_NAME, CUL_CATEGORY, CUL_ERA, DEG_DATE, CUL_LOCATION "
					+ "						        FROM CULTURE WHERE STATUS = 'Y' "
													
					+ "						    ) "
					+ "						)";
			pstmt = connection.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Culture culture = new Culture();
				
				culture.setCul_no(rs.getString("CUL_NO"));
				culture.setCul_name(rs.getString("CUL_NAME"));
				culture.setCul_category(rs.getString("CUL_CATEGORY"));
				culture.setCul_era(rs.getString("CUL_ERA"));
				culture.setDeg_date(rs.getString("DEG_DATE"));
				culture.setCul_location(rs.getString("CUL_LOCATiON"));
				
				list.add(culture);
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

	public Culture findCultureByNo(Connection connection, String cultureNo) {
		Culture culture = null;
		
		try {
			query = "SELECT  CUL_NO, C.CUL_NAME, C.CUL_CATEGORY, C.CUL_ERA, C.DEG_DATE, C.CUL_REGION, C.CUL_LOCATION, "
					+ "        C.CUL_INVALID, C.CUL_FIELD, C.CUL_DESCRIPTION , I.IMG1, I.IMG2, I.IMG3,I.ORIGINAL_FILENAME, I.RENAMED_FILENAME "
					+ "					FROM CULTURE C JOIN CUL_IMAGE I USING(CUL_NO)  "
					+ "					WHERE CUL_NO=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, cultureNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				culture = new Culture();
				culture.setCul_no(rs.getString("CUL_NO"));
				culture.setCul_name(rs.getString("CUL_NAME"));
				culture.setCul_region(rs.getString("CUL_REGION"));
				culture.setCul_location(rs.getString("CUL_LOCATION"));
				culture.setCul_invalid(rs.getString("CUL_INVALID"));
				culture.setDeg_date(rs.getString("DEG_DATE"));
				culture.setCul_era(rs.getString("CUL_ERA"));
				culture.setCul_category(rs.getString("CUL_CATEGORY"));
				culture.setCul_field(rs.getString("CUL_FIELD"));
				culture.setCul_description(rs.getString("CUL_DESCRIPTION"));
				culture.setImg1(rs.getString("IMG1"));
				culture.setImg2(rs.getString("IMG2"));
				culture.setImg3(rs.getString("IMG3"));
				culture.setOriginal_filename(rs.getString("ORIGINAL_FILENAME"));
				culture.setRenamed_filename(rs.getString("RENAMED_FILENAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return culture;
	}

	public int updateCulture(Connection connection, Culture culture) {
		int result = 0;
		
		
		try {
			query = "UPDATE CULTURE "
					+ "SET CUL_NAME=?,CUL_REGION=?, CUL_LOCATION=?,CUL_INVALID=?, DEG_DATE=?, CUL_ERA=?, "
					+ "    CUL_CATEGORY=?, CUL_FIELD=?, CUL_DESCRIPTION=? WHERE CUL_NO=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, culture.getCul_name());
			pstmt.setString(2, culture.getCul_region());
			pstmt.setString(3, culture.getCul_location());
			pstmt.setString(4, culture.getCul_invalid());
			pstmt.setString(5, culture.getDeg_date());
			pstmt.setString(6, culture.getCul_era());
			pstmt.setString(7, culture.getCul_category());
			pstmt.setString(8, culture.getCul_field());
			pstmt.setString(9, culture.getCul_description());
			pstmt.setString(10, culture.getCul_no());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertCulture(Connection connection, Culture culture) {
		int result = 0;
		String query = null;

		
		try {
			query = "INSERT INTO CULTURE VALUES(?,DEFAULT,?,?,?,?,?,?,?,?,?,default) ";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, culture.getCul_no());
			pstmt.setString(2, culture.getCul_name());
			pstmt.setString(3, culture.getCul_region());
			pstmt.setString(4, culture.getCul_location());
			pstmt.setString(5, culture.getCul_invalid());
			pstmt.setString(6, culture.getDeg_date());
			pstmt.setString(7, culture.getCul_era());
			pstmt.setString(8, culture.getCul_category());
			pstmt.setString(9, culture.getCul_field());
			pstmt.setString(10, culture.getCul_description());

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertImg(Connection connection, Culture cul_img) {
		int result = 0;
		
		try {
			query = " INSERT INTO CUL_IMAGE VALUES (SEQ_IMG_NO.NEXTVAL,?,?,?,?,NULL,NULL)";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, cul_img.getImg1());
			pstmt.setString(2, cul_img.getImg2());
			pstmt.setString(3, cul_img.getImg3());		
			pstmt.setString(4, cul_img.getCul_no());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public String findNo(Connection connection, Culture culture) {
		String find_no = null;
		
		try {
			query = "SELECT CUL_NO "
					+ "FROM( "
					+ "    SELECT "
					+ "        * "
					+ "    FROM CULTURE "
					+ "    ORDER BY ROWNUM DESC) "
					+ "WHERE ROWNUM = 1";
			
			pstmt = connection.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			find_no = rs.getString("CUL_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return find_no;
	}

	public int updateCulImg(Connection connection, Culture cul_img) {
int result = 0;
		
		
		try {
			query = "UPDATE CUL_IMAGE "
					+ "SET IMG1=?, IMG2=?, IMG3=? WHERE CUL_NO=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, cul_img.getImg1());
			pstmt.setString(2, cul_img.getImg2());
			pstmt.setString(3, cul_img.getImg3());
			pstmt.setString(4, cul_img.getCul_no());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateStatus(Connection connection, String cul_no, String status) {
		int result =0;
		
		try {
			query = "UPDATE CULTURE SET STATUS=? WHERE CUL_NO=?";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, status);
			pstmt.setString(2, cul_no);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



}
