package com.yong.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yong.member.model.service.MemberService;
import com.yong.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */

// get방식은 쿼리가 보이는 형식이고
// post는 쿼리가 보이지 않음
@WebServlet("/member/join.do") // 이건 무조건 get방식임 post가 절대 안됨
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("/WEB-INF/views/member/register.jsp"); //이건 그냥 주소창 붙혀넣는거 밖에 안됨
		// 이방식으로 해야 됨 RequestDispatcher 매서드는 변동이 없음
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //글자 안꺠지게 하는 코드
		
		String memberId = request.getParameter("member-id");
		System.out.println(memberId);
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		
		// 회원가입 비즈니스 로직
		Member member = new Member(memberId, memberPw, memberName, gender, Integer.parseInt(age), email, phone, address, hobby);
		System.out.println(member.toString());
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		
		
		if(result > 0) {
			// 성공 메세지 출력 종류
			// 1. redirect 단순하게 출력하려면 
			// respinst.sendRediect(""); 
			// 2. requestDispatcher    내가 메세지를 추가하고싶으면 이고
			// request.setAttribute("msg", "성공);
			// request.getRequesDispatcher("").forward(request, response);
			response.sendRedirect("/index.jsp");
			
		}else {
			// 실패 메세지 출력 
//			response.sendRedirect("/common/error/errorPage.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		
		}
		
	}

}
