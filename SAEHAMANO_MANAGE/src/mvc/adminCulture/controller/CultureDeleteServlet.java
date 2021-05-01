//20210430 19:43 이재용
package mvc.adminCulture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.adminCulture.model.service.CultureService;

@WebServlet("/culture/delete")
public class CultureDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CultureService service = new CultureService();
	
    public CultureDeleteServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String cul_no = request.getParameter("cul_no");
	int result = service.delete(cul_no);
	
	if(result > 0) {
		request.setAttribute("msg", "게시글 삭제 성공");
		request.setAttribute("location", "/cultural/list");
		
	}else {
		request.setAttribute("msg", "게시글 삭제 실패");
		request.setAttribute("location", "/cultural/list");
	}
	
	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

	}

}
