//2021-04-30 19:33 이재용

package mvc.adminEvent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.adminEvent.model.service.EventService;
import mvc.adminEvent.model.vo.Event;

@WebServlet("/admin/event")
public class AdminEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventService service = new EventService();

    public AdminEventServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int listCount = 0;
		List<Event> list = null;
		
		listCount = service.getAdminEventCount();
		list = service.getAdminEventList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/adminEvent/adminEvent.jsp").forward(request, response);
	}

}
