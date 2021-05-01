/*210426 10:09 김예원 (최종수정자) */
package mvc.Intro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.common.util.FileRename;
import com.oreilly.servlet.MultipartRequest;

import mvc.Intro.model.service.NoticeService;
import mvc.Intro.model.vo.Notice;

@WebServlet("/Intro/NoticeWrite")
public class NoticeBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService service = new NoticeService();

	public NoticeBoardWriteServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/adminIntro/adminNoticeAdd.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//String path = getServletContext().getRealPath("/upload/notice");
		/* 절대경로 (Write / Filedown / Update)*/
		String path = "C:\\upload\\notice";
		int maxSize = 10485760;
    	String encoding = "UTF-8"; 
		
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());

    	
    	
    	
		int result = 0;

		Notice notice = new Notice();
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");

		
		String originalFileName = mr.getOriginalFileName("upfile");
		String renamedFileName = mr.getFilesystemName("upfile");

		notice.setNotice_name(title);
		notice.setNotice_writer_no(1);
		notice.setNotice_content(content);
		notice.setOriginal_filename(originalFileName);
		notice.setRenamed_filename(renamedFileName);
		
		
		result = service.save(notice);

		if (result > 0) {
			request.setAttribute("msg", "공지사항 등록 성공");
			request.setAttribute("location", "/Intro/NoticeBoard");
		} else {
			request.setAttribute("msg", "공지사항 등록 실패");
			request.setAttribute("location", "/Intro/NoticeBoard");
		}

		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

	}

}
