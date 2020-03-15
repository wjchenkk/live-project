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

import pojo.Campaign;


/**
 * Servlet implementation class test
 */
@WebServlet("/next")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NextServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponsse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        //进行下一轮
		int total=Integer.parseInt(request.getParameter("total"));
		HttpSession session = request.getSession();
		session.setAttribute("flag", "begin");
		CampaignDAO campaignDAO=new CampaignDAOImpl();
		Campaign c=new Campaign();
		c.setTimes(campaignDAO.get().getTimes()+1);
		c.setTotal(total);
		campaignDAO.add(c);
		request.setAttribute("times",campaignDAO.getTimes());
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
