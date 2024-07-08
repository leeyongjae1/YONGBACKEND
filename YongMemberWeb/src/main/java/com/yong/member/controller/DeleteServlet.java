package com.yong.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yong.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/remove.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실행될 커리문을 생각하는게 제일 좋음
		// - 회원탈퇴를 할건데 쿼리문 어케함? 
		// DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '로그인한 ID'; 
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		int result = mService.deleteMember(memberId);
		if(result > 0) {
			// 로그아웃 후 메인으로 이동
			// 이렇게 하려면 1. 세션을 가져온후
//			HttpSession session = request.getSession();
			// 2, 세션을 파괴하고
//			if(session != null) session.invalidate();
			// 3. 메인페이지로 이동
//			response.sendRedirect("/");
			// 위에 1 , 2, 3 번과 같음
			response.sendRedirect("/member/logout.do");
		}else {
			// 실패시 에러페이지 이동
			request.setAttribute("msg", "회원탈퇴가 완료되지 않았습니다");
			RequestDispatcher view 
			= request.getRequestDispatcher("/WEB-INF/views/common/error.errorPage.jsp");
			view.forward(request, response);
		}
	}

}
