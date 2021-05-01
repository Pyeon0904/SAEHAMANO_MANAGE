package mvc.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.login.model.service.AdminService;
import mvc.login.model.vo.Admin;


@WebServlet(name="enroll",urlPatterns="/enroll")
public class ManageEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService service = new AdminService();

	
    public ManageEnrollServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/adminEnroll.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		
		admin.setId(request.getParameter("adminId"));
		admin.setPassword(request.getParameter("password"));
		String adminKey = request.getParameter("adminKey");
		
		int result = service.save(admin,adminKey);
		
		if(result > 0) {
    		request.setAttribute("msg", "관리자등록성공!");
    		request.setAttribute("location", "/");
    	} else {
    		request.setAttribute("msg", "관리자등록실패!");
    		request.setAttribute("location", "/");
    	}

		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
	}

}
