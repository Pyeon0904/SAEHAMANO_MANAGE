/*210426 00:24 김예원 (최종수정자) */
package mvc.community.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.community.qna.model.service.QnaService;
import mvc.community.qna.model.vo.Qna;


@WebServlet("/community/qna/update")
public class communityQnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QnaService service = new QnaService();
	
    public communityQnaUpdateServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Qna qna = new Qna();
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		qna = service.findBoardByNo(qnaNo);
    	
    	
    	request.setAttribute("qna", qna);
		request.getRequestDispatcher("/views/adminCommunity/adminQnaModify.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		Qna qna =  new Qna();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
	
		qna.setQna_no(qna_no);
		qna.setQna_name(title);
		qna.setQna_content(content);
		
		result = service.update(qna);
		
		
		if (result > 0) {
			request.setAttribute("msg", "수정되었습니다.");
		} else {
			request.setAttribute("msg", "수정에 실패하였습니다.");

		}
		request.setAttribute("location", "/community/qna");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

}
