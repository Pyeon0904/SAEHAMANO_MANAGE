//2021-04-30 19:33 이재용
package mvc.adminEvent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.adminEvent.model.service.EventService;

@WebServlet("/event/delete")
public class EventDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventService service = new EventService();
	
    public EventDeleteServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		int result = service.delete(eventNo);
		

		if(result > 0) {
			request.setAttribute("msg", "게시글 삭제 성공");
			request.setAttribute("location", "/admin/event");
			
		}else {
			request.setAttribute("msg", "게시글 삭제 실패");
			request.setAttribute("location", "/admin/event");
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

	}

}
