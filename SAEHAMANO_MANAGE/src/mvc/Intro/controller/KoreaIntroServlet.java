// 210411 11:04 김예원 (최종수정자) 
package mvc.Intro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Intro/KoreaIntro")
public class KoreaIntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KoreaIntroServlet() {

    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sPath=request.getContextPath();
    	response.sendRedirect(sPath+"/views/adminIntro/KoreaIntro.jsp");


    	

	}
}
