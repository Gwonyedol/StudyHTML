package kr.or.bit.service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;

public class MemoListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("메모리스트실행중");
		try {
  		  		  memodao dao = new memodao();
  		  		  List<memo> memolist = dao.getMemoList();
  		  		  request.setAttribute("memolist",memolist);
		  		  
  		  		  forward = new ActionForward();
  			  	  forward.setRedirect(false); //forward 방식
  			  	  forward.setPath("/WEB-INF/memo/memolist.jsp");
  			  	  System.out.println("메모리스트실행중");
		  	}catch(Exception e){
		  		System.out.println(e.getMessage());
		  	}
		return forward;
		
	}

}
