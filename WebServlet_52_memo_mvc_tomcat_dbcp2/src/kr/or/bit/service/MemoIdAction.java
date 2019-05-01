package kr.or.bit.service;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;

public class MemoIdAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		memodao dao=null;
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			dao = new memodao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String idcheck = dao.isCheckById(id);
		
		request.setAttribute("idcheck", idcheck);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/Register/memo.html");
		
		return forward;
	}

}
