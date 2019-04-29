package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;


//서비스 클래스
public class MemoId implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println(id);
		memodao dao=null;
		try {
			dao = new memodao();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String idcheck = dao.isCheckById(id);
		out.print(idcheck); //true or false
		return idcheck;
	}

	

}

