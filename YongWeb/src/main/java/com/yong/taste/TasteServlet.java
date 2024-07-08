package com.yong.taste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TasteServlet
 */
@WebServlet("/TasteServlet")
public class TasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TasteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		String userName = request.getParameter("user-name");
		String pet = request.getParameter("pet");
		String [] foods = request.getParameterValues("foods");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>개인 취향 테스트</title>");
		out.println("</head><body>");
		out.println("<h1>개인 취향 테스트 결과</h1>");
		out.println("<p>이름?" + userName + "<br>");
		out.println("좋아하는 색? " + color + "<br>");
		out.println("좋아하는 동물은? " + pet + "<br>");
		out.println("좋아하는 동물은? " + foods[0]);
		
		out.println("</p>");
		out.println("</body></html>");
	}


}
