<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
    /*
    int empno = Integer.parseInt(request.getParameter("txtempno"));
    String ename = request.getParameter("txtename");
    
    Emp emp = new Emp();
    emp.setEmpno(empno);
    emp.setEname(ename);
    
    session.setAttribute("empobj", emp);
    */
    //a.jsp  , b.jsp 에서도 사용가능
%>    
<%--1단계 실습코드
<jsp:useBean id="emp" class="kr.or.bit.Emp" scope="session"></jsp:useBean>
	<jsp:setProperty property="empno" name="emp" param="txtempno"/>
	<jsp:setProperty property="ename" name="emp" param="txtename"/>
<!DOCTYPE html>
 --%>
 <!-- 2단계 실습 코드 -->
 <jsp:useBean id="emp" class="kr.or.bit.Emp" scope="session"></jsp:useBean>
 <jsp:setProperty property="*" name="emp/">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "Ex26_Loginok.jsp" method="post"></form>
	사번 : <jsp:getProperty property="empno" name="emp"/><br>
	이름 : <jsp:getProperty property="ename" name="emp"/><br>
	<input type = "submit" value = "전송하기">
	</form>
	<!--만약 넘어가는 parameter 이름이 객체의 memberfield 명과 동일 하다면
	?empno=1000&ename=kglim  
	 -->
	
</body>
</html>