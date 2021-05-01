//2021-04-30 19:33 이재용
package mvc.adminEvent.controller;

import java.io.File;
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

@WebServlet("/event/modify")
public class EventModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EventService service = new EventService();
	
    public EventModifyServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		Event event = service.findEventByNo(eventNo,true);
		
		request.setAttribute("event", event);
		
		request.getRequestDispatcher("/views/adminEvent/modifyEvent.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event event = new Event();
		int result = 0;
		
		String path = getServletContext().getRealPath("/resources/upload/event");
		
		int maxSize = 10485760;
		
		String encoding = "UTF-8";
		
		MultipartRequest mr =new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		event.setEvent_no(Integer.parseInt(mr.getParameter("eventNo")));
		event.setEvent_name(mr.getParameter("event_name"));
		event.setEvent_start_date(mr.getParameter("event_start_date"));
		event.setEvent_last_date(mr.getParameter("event_last_date"));
		event.setEvent_content(mr.getParameter("event_content"));
		event.setEvent_insta(mr.getParameter("event_insta"));
		event.setEvent_home(mr.getParameter("event_home"));
		event.setEvent_place(mr.getParameter("event_place"));
		event.setEvent_hosting(mr.getParameter("event_hosting"));
		event.setEvent_img(mr.getParameter("event_img"));
		event.setOriginal_FileName(mr.getParameter("original_Filename"));
		event.setRenamed_FileName(mr.getParameter("renamed_Filename"));
			
		String original_Filename = mr.getOriginalFileName("reloadfile");
		String renamed_Filename = mr.getFilesystemName("reloadfile");
		
		if(original_Filename != null && !original_Filename.equals("")) {
			String deleteFilePath = path + "/" + event.getRenamed_FileName();
			
			deleteFile(deleteFilePath);
			
			event.setOriginal_FileName(original_Filename);
			event.setRenamed_FileName(renamed_Filename);
		}
			result = service.save(event);
		
		if(result > 0) {
			request.setAttribute("msg", "게시글 수정 성공");
			
			
		}else {
			request.setAttribute("msg", "게시글 수정 실패");
		}
		
		request.setAttribute("location", "/admin/event");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

	private void deleteFile(String path) {
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
	}

}
