package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Engine;


@WebServlet("/Prime.do")
public class Prime extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("calc") != null)
		{
			Engine engine = Engine.getInstance();
			String min = request.getParameter("min");
			String max = request.getParameter("max");
			request.setAttribute("minRes", min);
			request.setAttribute("maxRes", max);
			try
			{
				request.setAttribute("result",  engine.doPrime(min, max));
				System.out.println(request.getAttribute("result"));
			} 
			catch (Exception e)
			{
				request.setAttribute("error", e.getMessage());
			}
		} 
		else if (request.getParameter("recalc") != null)
		{	
			Engine engine = Engine.getInstance();
			String min = request.getParameter("min");
			String max = request.getParameter("max");
			String result ="";
			try {
				result = engine.doPrime(min, max);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("minRes", result);
			request.setAttribute("maxRes", max);
			
			try
			{
				request.setAttribute("result",  engine.doPrime(result, max));
				System.out.println(request.getAttribute("result"));
			} 
			catch (Exception e)
			{
				request.setAttribute("error", e.getMessage());
			}
		}
		this.getServletContext().getRequestDispatcher("/Prime.jspx").forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
