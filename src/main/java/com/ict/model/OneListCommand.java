package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OneListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String cPage = request.getParameter("cPage");
		
		// 히트수 업데이트 
		int result = DAO.getHitUp(idx);
		
		// 상세보기
		VO vo = DAO.getOneList(idx);
		
		// 수정과 삭제를 위해서 session에 저장
		 request.getSession().setAttribute("vo", vo);
		 
		// cPage도 저장
		request.setAttribute("cPage", cPage);
		
		return "view/onelist.jsp";
	}
}
