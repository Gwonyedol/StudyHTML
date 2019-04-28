<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 컨텐츠(자기소개)</title>
<style type = "text/css">
    table, tr, td {
        border :2px solid black ; border-collapse:collapse 
    }
</style>
</head>
<body>
    <!-- 원칙 : Layout : div ... -->
    <table style="background-color: rgb(253, 218, 253)">
        <tr>
            <td colspan="3">
                <jsp:include page ="/commonmodule/Top.jsp"></jsp:include>
            </td>
        </tr>
        <tr>
            <td style="width:120px"></td>
            <td style = "width:600px"><jsp:include page ="/commonmodule/Center1.jsp"></td>
            <td style = "width:120px"></td>
        </tr>
                <tr>
            <td style="width:120px"></td>
            <td style = "width:600px"><jsp:include page ="/commonmodule/Center2.jsp"></td>
            <td style = "width:120px"></td>
        </tr>
        <tr>
            <td colspan="3"><jsp:include page ="/commonmodule/Bottom.jsp"></jsp:include></td>
        </tr>
    </table>
    
</body>
</html>