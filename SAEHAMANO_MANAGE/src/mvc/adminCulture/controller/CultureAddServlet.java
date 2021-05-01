//20210430 19:43 이재용
package mvc.adminCulture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mvc.adminCulture.model.service.CultureService;
import mvc.adminCulture.model.vo.Culture;
import mvc.common.util.FileRename;

@WebServlet("/culture/add")
public class CultureAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CultureService service = new CultureService();

    public CultureAddServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "/views/cultureGuide/adminCulAdd.jsp";
		
		request.getRequestDispatcher(viewName).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Culture culture = new Culture();
		Culture cul_img = new Culture();
		
		
		String path = getServletContext().getRealPath("/resources/upload/culture");
		
		int maxSize = 10485760;
		
		String encoding = "UTF-8";
		
		MultipartRequest mr =new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		String cul_no = mr.getParameter("cul_no");
		String cul_name = mr.getParameter("name");
		String cul_region = mr.getParameter("region");
		String cul_location = mr.getParameter("location");
		String cul_invalid = mr.getParameter("invalid");
		String deg_date = mr.getParameter("deg_date");
		String cul_era = mr.getParameter("era");
		String cul_category = mr.getParameter("category");
		String cul_field = mr.getParameter("field");
		String cul_description = mr.getParameter("description");
		
		String cul_img1 = mr.getParameter("img1");
		String cul_img2 = mr.getParameter("img2");
		String cul_img3 = mr.getParameter("img3");
		
		String original_filename = mr.getOriginalFileName("upfile");
		String renamed_filename = mr.getFilesystemName("upfile");
		
		
		culture.setCul_no(cul_no);
		culture.setCul_name(cul_name);
		culture.setCul_region(cul_region);
		culture.setCul_location(cul_location);
		culture.setCul_invalid(cul_invalid);
		culture.setDeg_date(deg_date);
		culture.setCul_era(cul_era);
		culture.setCul_category(cul_category);
		culture.setCul_field(cul_field);
		culture.setCul_description(cul_description);
		

		
		int result2 = service.save(culture);
		String find_no = service.findNo(culture);
		
		cul_img.setImg1(cul_img1);
		cul_img.setImg2(cul_img2);
		cul_img.setImg3(cul_img3);
		
		cul_img.setCul_no(find_no);
		cul_img.setOriginal_filename(original_filename);
		cul_img.setRenamed_filename(renamed_filename);
		int result1 = service.saveCulImg(cul_img);
		
		
		if(result2 > 0) {
			request.setAttribute("msg", "게시글 등록 성공");
			request.setAttribute("location", "/cultural/list");
			
		}else {
			request.setAttribute("msg", "게시글 등록 실패");
			request.setAttribute("location", "/culture/add");
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
