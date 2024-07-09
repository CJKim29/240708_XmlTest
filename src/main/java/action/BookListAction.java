package action;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.MySearchUtil2;
import xml.vo.BookVo;

/**
 * Servlet implementation class BookListAction
 */
@WebServlet("/book/list.do")
public class BookListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String	b_name	= request.getParameter("b_name");
		int		start	= 0;
		int		display	= 10;
		
		try {
			start	= Integer.parseInt(request.getParameter("start"));
			display	= Integer.parseInt(request.getParameter("display"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		List<BookVo> b_list = MySearchUtil2.search_shop(b_name, start, display);
		
		request.setAttribute("b_list", b_list);

		//Dispatcher형식으로 호출
		String forward_page = "book_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}