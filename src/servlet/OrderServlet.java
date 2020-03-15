package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MaskDAO;
import dao.MaskDAOImpl;
// import dao.ProvinceDAOImpl;
import pojo.Reservation;
// import util.DateUtil;

/**
 * Servlet implementation class test
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String flag = (String) session.getAttribute("flag");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		String number = request.getParameter("number");
		String times = request.getParameter("times");
		int id_n = Integer.parseInt(id);
		int times_n = Integer.parseInt(times);
		boolean fl = true;
		String result = "fail";
		MaskDAO maskDAO = new MaskDAOImpl();
		if (flag != null && flag.equals("begin")) {
			// 前三天的状况
			if (id_n > 0) {
				for (Reservation r : maskDAO.list(id)) {
					if (r.getStatus() == 2) {
						fl = false;
					}
				}
			}
			// 预约成功
			if (!maskDAO.query(id, times_n) && fl) {
				Reservation Order_ = new Reservation();// 轮次，身份证号，电话，口罩数量
				Order_.setReserveNum(times_n);
				Order_.setID(id);
				Order_.setTel(tel);
				Order_.setName(name);
				Order_.setNumber(Integer.parseInt(number));
				maskDAO.add(Order_);
				result = "success";
			} else {
				result = "fail1";
			}
		}
		else {
			result="fail2";
		}
		// 是否预约成功
		request.setAttribute("status", result);
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
