//2021-04-30 19:33 이재용
package mvc.adminEvent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mvc.adminEvent.model.service.EventService;
import mvc.adminEvent.model.vo.Event;
import mvc.common.util.FileRename;


@WebServlet("/event/enroll")
public class EventEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EventService service = new EventService();

    public EventEnrollServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String viewName = "/views/adminEvent/enrollEvent.jsp";
	
	request.getRequestDispatcher(viewName).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event event = new Event();
		
		String path = getServletContext().getRealPath("/resources/upload/event");
		
		int maxSize = 10485760;
		
		String encoding = "UTF-8";
		
		MultipartRequest mr =new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		String event_name = mr.getParameter("event_name");
		String event_start_date = mr.getParameter("event_start_date");
		String event_last_date = mr.getParameter("event_last_date");
		String event_content = mr.getParameter("event_content");
		String event_insta = mr.getParameter("event_insta");
		String event_home = mr.getParameter("event_home");
		String event_place = mr.getParameter("event_place");
		String event_hosting = mr.getParameter("event_hosting");
		String event_img = mr.getParameter("event_img");
		
		String original_filename = mr.getOriginalFileName("upfile");
		String renamed_filename = mr.getFilesystemName("upfile");
		
		
		
		event.setEvent_name(event_name);
		event.setEvent_start_date(event_start_date);
		event.setEvent_last_date(event_last_date);
		event.setEvent_content(event_content);
		event.setEvent_insta(event_insta);
		event.setEvent_home(event_home);
		event.setEvent_place(event_place);
		event.setEvent_hosting(event_hosting);
		event.setEvent_img(event_img);
		event.setOriginal_FileName(original_filename);
		event.setRenamed_FileName(renamed_filename);
		
		int result = service.save(event);
		

		if(result > 0) {
			request.setAttribute("msg", "게시글 등록 성공");
			request.setAttribute("location", "/admin/event");
			
		}else {
			request.setAttribute("msg", "게시글 등록 실패");
			request.setAttribute("location", "/admin/event");
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
