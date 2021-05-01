//20210430 19:43 이재용
package mvc.adminCulture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.adminCulture.model.service.CultureService;
import mvc.adminCulture.model.vo.Culture;

@WebServlet("/cultural/list")
public class adminCulture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CultureService service = new CultureService();

    public adminCulture() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount = 0;
		List<Culture> list = null;
		
		listCount = service.getCultureCount();
		
		list = service.getCultureList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/cultureGuide/adminCulList.jsp").forward(request, response);
		
		
	
	}

}
