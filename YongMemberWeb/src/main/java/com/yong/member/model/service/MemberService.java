package com.yong.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.yong.common.JDBCTemplate;
import com.yong.member.model.dao.MemberDAO;
import com.yong.member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}
	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnenction();
			result = mDao.insertMember(conn, member);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnenction();
			result = mDao.updateMember(conn, member);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public Member checkLogin(Member member) {
		Connection conn = null;
		Member mOne = null;
		
		try {
			conn = JDBCTemplate.getConnenction();
			mOne = mDao.checkLogin(conn, member);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mOne;
	}
	public int deleteMember(String memberId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnenction();
			result = mDao.deleteMember(conn, memberId);
			// 성공 여부에 따른 커밋/롤백이 있어야 함
			conn.setAutoCommit(false);
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public Member selectOneById(String memberId) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = JDBCTemplate.getConnenction();
			member = mDao.selectOneById(conn, memberId);
			
			// 예외 처리할떄 하나로 처리하고 싶으면
			// Exception e 이렇게 씀 조상클래스여 이것도 업캐스팅이다 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
}
