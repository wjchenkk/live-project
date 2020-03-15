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
		String id = request.getParameter("ID");
		String tel = request.getParameter("Phone");
		String number = request.getParameter("num");
		boolean valid=true;
		if(id==null||id.equals(""))valid=false;
		if(name==null||name.equals(""))valid=false;
		if(tel==null||tel.equals(""))valid=false;
		if(number==null||number.equals(""))valid=false;
		boolean fl = true;
		String result = "fail";
		MaskDAO maskDAO = new MaskDAOImpl();
		if (flag != null && flag.equals("begin")&&valid) {
			int times_n = (int)session.getAttribute("times");
			// 前三天的状况
			for (Reservation r : maskDAO.list(id)) {
				if (r.getStatus() == 2) {
					fl = false;
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
				Order_ = maskDAO.get(id, times_n);
				request.setAttribute("record", Order_.getWinningNum());
			} else {
				result = "fail";
			}
		} else {
			result = "fail";
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
