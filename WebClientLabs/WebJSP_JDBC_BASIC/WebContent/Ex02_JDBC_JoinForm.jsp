<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body {

}

table {
	border: solid 1px white;
	border-collapse: collapse ;
}

tr {
	border: solid 1px white;
	background-color:;
	padding: 5px;
	color: #ffc8c8;
	font-family:'맑은고딕';
	width: 500px;
}

td {
	border: solid 1px white;
	padding: 12px;
	font-family: "양재붓꽃체L";
}

th {
	background-color: rgb(255, 234, 235);
	font-family:'맑은고딕';

}

h3 {
	font-family:'맑은고딕';
}


#button {

    width:90px;
    background-color: #f8585b;
    border: none;
    color:#fff;
    padding: 15px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 13px;
    margin: 4px;
    cursor: pointer;  
    border-radius:10px;

}





</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
 //jquery 로 간단하게 유효성 check 하기
 $(function() {
  	$('#joinForm').submit(function() {
	   //alert("가입");
	if ($('#id').val() == "") { // 아이디 검사
    	alert('ID를 입력해 주세요.');
    	$('#id').focus();
    return false;
   } else if ($('#pwd').val() == "") { // 비밀번호 검사
    alert('PWD를 입력해 주세요.');
    $('#pwd').focus();
    return false;
   }else if ($('#mname').val() == "") { // 이름 검사
    alert('mname를 입력해 주세요.');
    $('#mname').focus();
    return false;
   }else if ($('#age').val() == "") { // 나이 검사
    alert('age를 입력해 주세요.');
    $('#age').focus();
    return false;
   }else if ($('#email').val() == "") { // 우편번호
    alert('email를 입력해 주세요.');
    $('#email').focus();
    return false;
   }
   
  });
 });
</script>
<!--  
CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
)
-->

</head>
<body>
	<table
		style="width: 1200px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="width: 700px">
				<form action="Ex02_JDBC_JoinOK.jsp" method="post" name="joinForm" id="joinForm"><br>
					<h3 style="text-align: center;font-family:'맑은고딕'">Join</h3><br>
					<div>
						<table
							style="width: 700px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<th style = "width:35%">ID</th>
								<td><input type="text" name="id" id="id" style="width:300px;"></td>
							</tr>
							<tr>
								<th>PWD</th>
								<td><input type="password" name="pwd" id="pwd" style="width:300px;"></td>
							</tr>
							<tr>
								<th>Name</th>
								<td><input type="text" name="mname" id="mname" style="width:300px;"></td>
							</tr>
							<tr>
								<th>age</th>
								<td><input type="text" name="age" id="age" maxlength="3" style="width:300px;"></td>
							</tr>
							<tr>
								<th>Gender</th>
								<td><input type="radio" name="gender" id="gender" value="여"
									checked>여자 <input type="radio" name="gender"
									id="gender" value="남">남자</td>
							</tr>
							<tr>
								<th>Email</th>
								<td><input type="text" name="email" id="email" style="width:300px;"></td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: center;"><br>					
									<input id = "button" type="submit" value="회원가입" style="text-align: center;">
									<input id = "button" type="reset" value="취소" style="text-align: center;"></td>
							
							</tr>
							
						</table>

					</div>
				</form>
				<br><br><br><br><br><br>
			</td>
		</tr>

	</table>
	
	</div>
	
	
</body>
</html>