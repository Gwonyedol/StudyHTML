<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//1.request (클라이언트가 입력한 값을 얻어 올 수 있다.)
	//input > text, password, radio, textarea, select
	//넘어오는 값이.. 단일값,다중값
	//input type = "text" name = "userid" >> ?userid=yeji
	
	String userid = request.getParameter("userId");
	String username = request.getParameter("userName");
	String userpass = request.getParameter("userPass");
	String userpasscheck = request.getParameter("userPassCheck");

	
	String useremail = request.getParameter("userEmail");
	String userssn1 = request.getParameter("userSsn1");
	String userssn2 = request.getParameter("userSsn2");
	String userzipcode = request.getParameter("userZipCode");
	String useraddr1 = request.getParameter("userAddr1");
	String useraddr2 = request.getParameter("userAddr2");
	String userphone = request.getParameter("userPhone");


	String[] hobbys = request.getParameterValues("hobby");
	Enumeration<String> e = request.getParameterNames();
	String name = "";
	while(e.hasMoreElements()){
		name += "/" +e.nextElement();
	}
	
	String year = request.getParameter("year");
	
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ID : <%= userid %><br>
PASSWORD : <%= userpass %><br>
이름 : <%= username %><br>
이메일 : <%= useremail %><br>
주민번호 : <%= userssn1%> - <%= userssn2%><br>
우편번호 : <%= userzipcode%><br>
주소1 : <%= useraddr1%><br>
주소2 : <%= useraddr2%><br>
핸드폰번호 : <%= userphone%><br>
<%
 for(String str : hobbys){ %>
	 취미 : <%= str %><br>
<%
}
%>
생년월일 : <%= year%> 월

</body>
</html>