package mvc.Intro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Intro/SaehamanoIntro")
public class SaehamanoIntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaehamanoIntroServlet() {

    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sPath=request.getContextPath();
    	response.sendRedirect(sPath+"/views/adminIntro/SaehamanoIntro.jsp");
		/*
		 * request.getRequestDispatcher("/views/Intro/SaehamanoIntro.jsp").forward(
		 * request,response);
		 */
	}

}
