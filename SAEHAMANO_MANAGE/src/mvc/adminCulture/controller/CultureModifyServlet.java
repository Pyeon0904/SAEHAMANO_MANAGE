//20210430 19:43 이재용
package mvc.adminCulture.controller;

import java.io.File;
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

@WebServlet("/culture/modify")
public class CultureModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CultureService service = new CultureService();

    public CultureModifyServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cultureNo = request.getParameter("cul_no");
		Culture culture = service.findCultureByNo(cultureNo,true);
		
		request.setAttribute("culture", culture);
		request.getRequestDispatcher("/views/cultureGuide/adminCulModify.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Culture culture = new Culture();
		Culture cul_img = new Culture();
		
		int result1 = 0;
		int result2 = 0;
		
		String path = getServletContext().getRealPath("/resources/upload/culture");
		
		int maxSize = 10485760;
		
		String encoding = "UTF-8";
		
		MultipartRequest mr =new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		culture.setCul_no(mr.getParameter("cul_no"));
		culture.setCul_name(mr.getParameter("name"));
		culture.setCul_region(mr.getParameter("region"));
		culture.setCul_location(mr.getParameter("location"));
		culture.setCul_invalid(mr.getParameter("invalid"));
		culture.setDeg_date(mr.getParameter("deg_date"));
		culture.setCul_era(mr.getParameter("era"));
		culture.setCul_category(mr.getParameter("category"));
		culture.setCul_field(mr.getParameter("field"));
		culture.setCul_description(mr.getParameter("description"));
		
		cul_img.setImg1(mr.getParameter("img1"));
		cul_img.setImg2(mr.getParameter("img2"));
		cul_img.setImg3(mr.getParameter("img3"));
		cul_img.setCul_no(mr.getParameter("cul_no"));
		cul_img.setOriginal_filename(mr.getParameter("original_filename"));
		cul_img.setRenamed_filename(mr.getParameter("renamed_filename"));
		
		String original_filename = mr.getOriginalFileName("reloadFile");
		String renamed_filename = mr.getFilesystemName("reloadFile");
		
		if(original_filename != null && !original_filename.equals("")) {
			String deleteFilePath = path+"/"+cul_img.getRenamed_filename();
			
			deleteFile(deleteFilePath);
			
			cul_img.setOriginal_filename(original_filename);
			cul_img.setRenamed_filename(renamed_filename);
		}
		result2 = service.update(culture);
		
		result1 = service.updateImg(cul_img);
		

		if(result2 > 0) {
			request.setAttribute("msg", "게시글 수정 성공");
			
			
		}else {
			request.setAttribute("msg", "게시글 수정 실패");
		}
	
		request.setAttribute("location", "/cultural/list");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

		
		
	}

	private void deleteFile(String path) {
		File file = new File(path);
		
		if(file.exists()) {
			file.delete();
		}		
	}

}
