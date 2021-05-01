/*210426 13:37 김예원 (최종수정자) */
package mvc.community.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.common.util.PageInfo;
import mvc.community.qna.model.service.QnaService;
import mvc.community.qna.model.vo.Qna;



@WebServlet("/community/qna")
public class communityQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QnaService service = new QnaService();

    public communityQnaServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Qna> qna = null;
				
		qna = service.getQnaList();
				
		request.setAttribute("qna",qna);
		request.getRequestDispatcher("/views/adminCommunity/adminCommunityQna.jsp").forward(request, response);
	}

}
