package com.ict.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Ans_writeOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("/upload");
			MultipartRequest mr = 
					new MultipartRequest(request, path,100*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
			String cPage = mr.getParameter("cPage");
			
			// 세션에 있는 VO에서  groups, step, lev  추출해서  
			// 16, 0, 0
			VO vo = (VO)request.getSession().getAttribute("vo");
			int groups = Integer.parseInt(vo.getGroups());
			int step = Integer.parseInt(vo.getStep());
			int lev = Integer.parseInt(vo.getLev());
			
			// (groups, step, lev를 1씩 증가)
			// 16, 1,  1
			lev++;
			step++;
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("groups", groups);
			map.put("lev", lev);
			
			// 기존 댓글 lev update한다.(첫번째 댓글은 의미가 없다.)
			int result = DAO.getUp_lev(map);
			
			// 댓글 삽입
			VO ins_vo = new VO();
			ins_vo.setWriter(mr.getParameter("writer"));
			ins_vo.setTitle(mr.getParameter("title"));
			ins_vo.setContent(mr.getParameter("content"));
			ins_vo.setPwd(mr.getParameter("pwd"));
			ins_vo.setGroups(String.valueOf(groups));
			ins_vo.setStep(String.valueOf(step));
			ins_vo.setLev(String.valueOf(lev));
			
			if(mr.getFile("file_name") != null) {
				ins_vo.setFile_name(mr.getFilesystemName("file_name"));
			}else {
				ins_vo.setFile_name("");
			}
			result = DAO.getAnsInsert(ins_vo);
			return "MyController?cmd=list&cPage="+cPage ;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}





