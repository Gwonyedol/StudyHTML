<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
UID , PWD , chk 여부
1. ID ,PWD 같다면 로그인 성공 (id(ID.equals(...)
   chk 이 체크 되었다면
   >쿠키 생성 ID 값을 쿠키에 담아서 : 유효 타입(24시간)
   >쿠키 쓰기 완료

2. ID ,PWD 같다면 로그인 성공 (id(ID.equals(...)
   chk 이 체크 되어 있지 않다면
   >만들었던 쿠키 삭제 : setMaxAge(0)
   Cookie delco = new Cookie("UID","");
   delco.setMaxAge(0);
   response.addCookie(delco);
   
3. ID , PWD 같지 않다면
   response.sendRedirect() -> Ex19_login.jsp 이동 처리


 -->

<%
		String id = request.getParameter("UID");
		String pwd = request.getParameter("PWD");
		String chk = null;
		chk = request.getParameter("chk");
		System.out.println(id + " / " + pwd + " / " + chk);
	

%>
<%
	 if(id.equals(pwd)){ //로그인 성공
		if(chk != null){  
			if(chk.equals("on")){ //쿠키 생성
				//쿠키 생성
				Cookie co = new Cookie("UID",id);
				co.setMaxAge(24*60*60);
				response.addCookie(co);
			
			}
			
		}else{
			//쿠키 삭제
			Cookie delco = new Cookie("UID","");
			delco.setMaxAge(0); //소멸
			response.addCookie(delco);
			
		}
			response.sendRedirect("Ex19_login.jsp"); //페이지 이동 (loing.jsp) 요청
	}else{
			//response.sendRedirect("Ex20_login.jsp");
			out.print("<script>location.href='Ex19_login.jsp'</script>");
	} 

%>


</body>
</html>