package mvc.login.model.service;

import java.sql.Connection;
import static mvc.common.jdbc.JDBCTemplate.*;


import mvc.login.model.dao.AdminDAO;
import mvc.login.model.vo.Admin;

public class AdminService {

	private AdminDAO dao = new AdminDAO();
	
	public Admin adminlogin(String id, String password) {
		
		Admin amdin = this.findAdminById(id);
		
		if (amdin != null && amdin.getPassword().equals(password)) {
			return amdin;			
		} else {
			return null;
		}
	}

	private Admin findAdminById(String id) {
		Connection connection = getConnection();
		Admin amdin   = dao.findMemberById(connection, id);
		
		close(connection);
		return amdin;
	}

	public int save(Admin admin, String adminKey) {
		int security = 0;
		int result = 0;
		Connection connection = getConnection();
		
		security = dao.confirmSecurity(connection,adminKey);
		if(security > 0) {
		
			result = dao.insertAdmin(connection, admin);

		}
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		return result;
	}

}
