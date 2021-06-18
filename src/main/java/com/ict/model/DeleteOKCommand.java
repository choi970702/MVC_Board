package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class DeleteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String cPage = request.getParameter("cPage");
		VO vo = (VO)request.getSession().getAttribute("vo");
		request.setAttribute("cPage", cPage);
		// 원글일때 삭제
		int result = DAO.getDelete(vo);
		if(result>0) {
			return "MyController?cmd=list";
		}
		return null;
	}
}
