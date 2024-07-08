package com.yong.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.member.model.service.MemberService;
import com.yong.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리문은 UPDATE MEMBER_TBL SET EMAIL = ?, PHONE = ?, ADDRESS =?, HOBBY =? WHERE MEMBER_ID = ?
	try {
		// 한글이 깨지지 않게 행함
		request.setCharacterEncoding("");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String memberId = request.getParameter("memberId");
		Member member = new Member();
		
		member.setEmail(email);
		member.setPhone(phone);
		member.setAddress(address);
		member.setHobby(hobby);
		member.setMemberId(memberId);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result > 0) {
			// 마이페이지
			// 완료된 후 마이페이지 서블릿을 호출하면 됨
			response.sendRedirect("/member/mypage.do?memberId="+memberId);
		} else {
			// 에러페이지
			request.setAttribute("msg", "정보수정이 완료되지 않음");
			request.getRequestDispatcher("/WEB-INF/views/common/error.errorPage.jsp").forward(request, response);
			
			
		}
	} catch(Exception e) {
		request.setAttribute("msg", e.getMessage());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error.errorPage.jsp");
		view.forward(request, response);
	}
		
	
	
	
	}

}
