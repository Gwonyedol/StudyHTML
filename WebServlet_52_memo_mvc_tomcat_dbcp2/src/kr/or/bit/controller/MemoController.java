package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.MemoIdAction;
import kr.or.bit.service.MemoListAction;
import kr.or.bit.service.MemoSendAction;

@WebServlet("*.memo")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemoController() {
        super();
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청주소 받아옴
		String requestURI = request.getRequestURI(); 
		String contextPath = request.getContextPath();
		String url_Command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Action action = null;
		
		//2. 요청된 주소에 따라 업무분담
		//Action이 업무를 처리함
		if(url_Command.equals("/MemoId.memo")) { //ID확인(DB에 보내야됨)
			action = new MemoIdAction();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/MemoSend.memo")) { //전송버튼(서버에 내용 보냄)
			action = new MemoSendAction();
			forward = action.execute(request, response);
		}else if(url_Command.equals("/MemoList.memo")) { //목록보기(리스트로 가기)
	    	try {
    			action = new MemoListAction();
        		forward = action.execute(request, response);
        		System.out.println("forward"+forward.getPath());
        		System.out.println("forward1111111 목록보기");
		}catch(Exception e) {
			e.printStackTrace();
		}
		}else if(url_Command.equals("/MemoWrite.memo")) { //글쓰기(주소 보내기)
	  		forward = new ActionForward();
	  		forward.setRedirect(false);
	  		forward.setPath("/WEB-INF/memo/memo.html");
		}
		
		if(forward != null) {
			if(forward.isRedirect()) { //true(redirect 형식으로 가야됨)
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				
			}
		}
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
