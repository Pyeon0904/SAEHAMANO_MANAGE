package mvc.Intro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.Intro.model.service.NoticeService;


@WebServlet("/Intro/NoticeDelete")
public class NoticeBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService service = new NoticeService();

    public NoticeBoardDeleteServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = service.delete(noticeNo);
		
		if(result > 0) {
     		request.setAttribute("msg", "게시글 삭제 성공");
     		request.setAttribute("location", "/Intro/NoticeBoard");
		} else {
     		request.setAttribute("msg", "게시글 삭제 실패");
     		request.setAttribute("location", "/Intro/NoticeBoard");
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}
