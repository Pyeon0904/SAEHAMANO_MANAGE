//2021-04-30 19:33 이재용
package mvc.adminEvent.model.service;
import static mvc.common.jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import mvc.adminEvent.model.dao.EventDAO;
import mvc.adminEvent.model.vo.Event;

public class EventService {
	
	private EventDAO dao = new EventDAO();

	public int getAdminEventCount() {
		Connection connection = getConnection();
		
		int count = dao.getAdminCount(connection);
		close(connection);
		return count;
	}

	public List<Event> getAdminEventList() {
		Connection connection = getConnection();
		List<Event> list = dao.findAll(connection);
		
		close(connection);
		return list;
	}

	public int save(Event event) {
		int result = 0;
		Connection connection = getConnection();
		
		if(event.getEvent_no() !=0) {
			
			result= dao.updateEvent(connection,event);
			
		}else {
		
		result = dao.insertEvent(connection,event);
		
		}
		if(result > 0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		close(connection);
		return result;
	}

	public Event findEventByNo(int eventNo, boolean b) {
		Event event = null;
		Connection connection = getConnection();
		
		event = dao.findEventByNo(connection, eventNo);
		
		close(connection);
		return event;
	}

	public int delete(int eventNo) {
		int result =0;
		Connection connection = getConnection();
		
		result = dao.updateStatus(connection,eventNo,"N");
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

}
