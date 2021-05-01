package mvc.adminCulture.model.service;

import java.sql.Connection;
import java.util.List;

import mvc.adminCulture.model.dao.CultureDAO;
import mvc.adminCulture.model.vo.Culture;

import static mvc.common.jdbc.JDBCTemplate.*;

public class CultureService {
	
	private CultureDAO dao = new CultureDAO();

	public int getCultureCount() {
		Connection connection = getConnection();
		int count = dao.getCultureCount(connection);
		
		close(connection);
		return count;
	}

	public List<Culture> getCultureList() {
		Connection connection = getConnection();
		List<Culture> list = dao.findAll(connection);
		
		close(connection);
		return list;
	}

	public Culture findCultureByNo(String cultureNo, boolean b) {
		Culture culture = null;
		Connection connection = getConnection();
		
		culture = dao.findCultureByNo(connection,cultureNo);
		
	
		return culture;
	}

	public int save(Culture culture) {
		int result = 0;
		Connection connection = getConnection();
		
//		if(culture.getCul_no() != null) {
//		result = dao.updateCulture(connection,culture);
//		}else {
			result = dao.insertCulture(connection,culture);

		
		

		if(result > 0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public int saveCulImg(Culture cul_img) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.insertImg(connection,cul_img);
		
		if(result > 0 ) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public String findNo(Culture culture) {
		Connection connection = getConnection();
		String find_no = dao.findNo(connection, culture);
		close(connection);
		return find_no;
	}

	public int update(Culture culture) {
		int result = 0;
		Connection connection = getConnection();
		
		if(culture.getCul_no() != null) {
		result = dao.updateCulture(connection,culture);
		}
		
		

		if(result > 0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public int updateImg(Culture cul_img) {
		int result = 0;
		Connection connection = getConnection();
		
		if(cul_img.getCul_no() != null) {
		result = dao.updateCulImg(connection,cul_img);
		}
		
		

		if(result > 0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public int delete(String cul_no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = dao.updateStatus(connection, cul_no,"N");
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}



	
}
