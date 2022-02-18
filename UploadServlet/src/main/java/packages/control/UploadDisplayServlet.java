package packages.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadDisplayServlet
 */
@WebServlet("/UploadDisplayServlet")
public class UploadDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//リクエストパラメータからタスク番号を取得して、リクエスト属性へ格納
		String idString = request.getParameter("id");
		
		//整数値にキャスト
		Integer id = Integer.parseInt(idString);
		
		//リクエスト属性に格納
		request.setAttribute("id", id);
		
		//JSPの情報を取得
		RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
		
		//JSPにフォワード
		rd.forward(request, response);
	}
}
