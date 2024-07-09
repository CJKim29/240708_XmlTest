package action;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.MySearchUtil;
import xml.vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product/list.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /product/list.do?p_name=노트북&start=1&display=10
		
		request.setCharacterEncoding("utf-8");
		
		String	p_name = request.getParameter("p_name");
		int		start = 1;
		int		display = 10;
		
		try {
			start   = Integer.parseInt(request.getParameter("start"));
			display = Integer.parseInt(request.getParameter("display"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//Naver Open API를 이용해서 상품검색
		List<ProductVo> p_list = MySearchUtil.search_shop(p_name, start, display);
		
		
		//request binding
		request.setAttribute("p_list", p_list);

		//Dispatcher형식으로 호출
		String forward_page = "product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}