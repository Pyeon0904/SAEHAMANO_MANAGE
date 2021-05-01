package mvc.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.login.model.service.AdminService;
import mvc.login.model.vo.Admin;


@WebServlet(name="login", urlPatterns="/login")
public class ManageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminService service = new AdminService();
	
    public ManageLoginServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("adminId");
		String password = request.getParameter("password");
		
		System.out.println(password);
		
		Admin admin = service.adminlogin(Id,password);

		
		if(admin != null) {
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}else {
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
			request.setAttribute("location", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
	}

}
