<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BITUSER","0916");
	
	stmt = conn.createStatement();
	String sql = "select empno, ename, sal, job from emp";
	
	rs = stmt.executeQuery(sql);
	//여러건 데이터 (객체로 담아 놓고 싶어요 : collection)
	//DTO 클래스 Emp
	/* Emp emp = new Emp(); 데이터 1건 */
	
	List<Emp> list = new ArrayList<>();
	
	while(rs.next()){
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getInt(3));
		emp.setJob(rs.getString(4));
		list.add(emp);
	}
	
	//자바에서 jsonlib 를 통해서 ...
	JSONArray jsonlist = JSONArray.fromObject(list);
	
	/*  
	[
	 {empno : 7788 .....}
	 {empno : 7799 ....}
	]
	*/
	
%>

<%= jsonlist %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>