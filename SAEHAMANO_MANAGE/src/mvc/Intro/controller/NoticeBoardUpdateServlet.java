package mvc.Intro.controller;

import java.io.File;
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

@WebServlet("/Intro/NoticeUpdate")
public class NoticeBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService service = new NoticeService();
	
    public NoticeBoardUpdateServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = service.findBoardByNo(noticeNo, true);
		
		request.setAttribute("notice", notice);
    	request.getRequestDispatcher("/views/adminIntro/adminNoticeModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int result = 0;
    	Notice notice = new Notice();
    	/* 절대경로 (Write / Filedown / Update)*/
		String path = "C:\\upload\\notice";
    	int maxSize = 10485760;    	
    	String encoding = "UTF-8"; 
    	MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
    	
    	notice.setNotice_code(Integer.parseInt(mr.getParameter("noticeNo")));
    	notice.setNotice_name(mr.getParameter("title"));
    	notice.setNotice_content(mr.getParameter("content"));
    	notice.setOriginal_filename(mr.getParameter("originalFileName"));
    	notice.setRenamed_filename(mr.getParameter("renameFileName"));
    	
    	String originalFileName = mr.getOriginalFileName("reloadFile");
		String renamedFileName = mr.getFilesystemName("reloadFile");
		
		if(originalFileName != null && !originalFileName.equals("")) {
			String deleteFilePath = path + "/" + notice.getRenamed_filename();
			
			deleteFile(deleteFilePath);
			
			notice.setOriginal_filename(originalFileName);
			notice.setRenamed_filename(renamedFileName);
		}
		result = service.save(notice);
	    
		if(result > 0) {
     		request.setAttribute("msg", "게시글 수정 성공");
		} else {
     		request.setAttribute("msg", "게시글 수정 실패");
		}    
		
		request.setAttribute("location", "/Intro/NoticeBoard");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    	
	}
	private void deleteFile(String path) {
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}
	}

}
