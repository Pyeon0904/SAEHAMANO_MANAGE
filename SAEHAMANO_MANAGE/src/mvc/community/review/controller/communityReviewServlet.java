/*210426 00:34 김예원 (최종수정자) */
package mvc.community.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.common.util.PageInfo;
import mvc.community.review.model.service.ReviewService;
import mvc.community.review.model.vo.Review;



@WebServlet("/community/review")
public class communityReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReviewService service = new ReviewService();
	
    public communityReviewServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<Review> review = null;
	
		review = service.getReviewList();
				
		request.setAttribute("review",review);
		request.getRequestDispatcher("/views/adminCommunity/adminCommunityReview.jsp").forward(request, response);

	}

	
}
