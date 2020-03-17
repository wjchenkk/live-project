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
import pojo.Reservation;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
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
		String id = request.getParameter("id");
		if(id==null||id.equals(""))id="-1";
		if (flag == null || flag.equals("end")) {
			MaskDAO maskDAO = new MaskDAOImpl();
			Reservation r = maskDAO.get(Integer.parseInt(id));
			if (r!=null&&r.getStatus() == 2) {
				request.setAttribute("result", "success");
				request.setAttribute("name", r.getName());
				request.setAttribute("id", r.getID());
				request.setAttribute("tel", r.getTel());
				request.setAttribute("number", r.getNumber());
			}
			else {
				request.setAttribute("result", "fail");
			}
		} else {
			request.setAttribute("result", "fail");
		}
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
