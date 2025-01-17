package com.yong.checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckboxServlet
 */
@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String place = request.getParameter("place"); 이건 하나만 
		String [] places = request.getParameterValues("place"); // 이건 여러개
		String str = "";
		for(String place : places )
			str += place + ", ";
//			System.out.println(places);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림을 열었음
		out.println("<h1>관광지 선택 결과</h1>");
		out.println("<h2>" + str + "</h2>");
//		response.sendRedirect("/checkbox/checkResult.html");
		
	}


}
