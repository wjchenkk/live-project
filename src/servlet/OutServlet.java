package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CampaignDAO;
import dao.CampaignDAOImpl;
import dao.MaskDAO;
import dao.MaskDAOImpl;
import pojo.Campaign;
import pojo.Reservation;

/**
 * Servlet implementation class test
 */
@WebServlet("/out")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// 抽签，确定结果
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String times = request.getParameter("times");
		HttpSession session = request.getSession();
		session.setAttribute("flag", "end");
		int times = (int) session.getAttribute("times");
		CampaignDAO campaignDAO = new CampaignDAOImpl();
		int ran1 = (int) (Math.random() * 3);
		String result = "fail";
		MaskDAO maskDAO = new MaskDAOImpl();
		Reservation[] rs = maskDAO.getList(times);
		int cnt = rs.length;
		Campaign c = campaignDAO.get();
		int sum_n = c.getTotal();
		while (sum_n >= 0 && cnt != 0) {
			for (Reservation R : rs) {
				ran1 = (int) (Math.random() * 3);
				int id_n = R.getWinningNum();
				int num = R.getNumber();
				int status = R.getStatus();
				if (status == 0) {
					if (ran1 < 1 && sum_n >= num) {
						maskDAO.update(id_n, "2");
						sum_n = sum_n - num;
						cnt--;
					} else {
						if (ran1 < 1 && sum_n < num && sum_n > 0) {
							cnt--;
						}
						maskDAO.update(id_n, "1");
					}
				}
			}
		}
		c.setTotal(sum_n);
		campaignDAO.update(c);
		request.setAttribute("status", result);
		session.setAttribute("times", -1);
		request.getRequestDispatcher("query.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
