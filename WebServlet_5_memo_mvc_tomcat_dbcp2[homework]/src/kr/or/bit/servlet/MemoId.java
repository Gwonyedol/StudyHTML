package kr.or.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memodao;
import kr.or.bit.service.LoginProcessAction;
import kr.or.bit.service.MemberWriteAction;
/*

id 검증 (사용자에 입력한 id ) DB에 있는지 없는지 확인 
isCheckById 사용해서 
return "false" or "true"
 
*/
@WebServlet("/*.Memo")
public class MemoId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemoId() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
		//1. 요청 받기
    	//String command  = request.getParameter("cmd")
    	//Url 방식은 cmd parameter 없어요
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	ActionForward forward = null; //redirect 와 path 정보갖는 클래스
    	Action action = null;
    	
    	//2. 요청 판단 처리 
    	String viewpage="";
    	if(url_Command.equals("/Id.Memo")) { //아이디 확인
    		//UI제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Memo/memoid.jsp");
     	
    	}else if(url_Command.equals("/List.Memo")){ //회원가입 처리 (업무)
    		
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Register.jsp");
    	    
    	}else if(url_Command.equals("/MemoOK.Memo")) {
    		//UI제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/login.jsp");
    		
    	}else if(url_Command.equals("/loginok.do")) {
    		
    		action = new LoginProcessAction(); //다형성
    	    forward =action.execute(request, response);	
    		
    	}
    	
    
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
