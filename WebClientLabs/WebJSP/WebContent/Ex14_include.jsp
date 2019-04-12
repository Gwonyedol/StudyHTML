<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
       request.setCharacterEncoding("UTF-8");
       String type = request.getParameter("type");
       String userid = request.getParameter("userid");
       String type2 = request.getParameter("type2");
       out.print(type+ " / " + userid + " / " + type2);
       //http://localhost:8080/WebServlet/Ex14_include_param_main.jsp?type=장지훈&userid=장지훈

       //include 되는 페이지에서는 request 객체를 공유할 수 있다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include (request 객체 공유) POINT!</title>
</head>
<body>
   MAIN PAGE <br>
   <hr>
   <jsp:include page="subparam.jsp">
       <jsp:param value="<%=type2 %>" name ="aaaa"/>
       <jsp:param value="1004" name ="bbbb"/>
   </jsp:include>
   <hr>
   MAIN END
</body>
</html>
