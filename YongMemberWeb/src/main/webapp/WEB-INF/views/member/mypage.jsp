<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
	<!-- </처럼 닫는 태그가 있으면 태그 사이에 써줘야 눈에 보이고
	닫는 태그가 없으면 <input type="text" value="1"> 이렇게 value값에 써야함  -->
		<h1>마이페이지</h1>
		<!-- 원래 게터 써야됨{member.getmemberId()} 근데 안써도 됨 -->
		<form action="/member/update.do" method="post">
		<!-- name값으로 부를려면 만들어 줘야하는데 네임을 만드는건 input태그 뿐임 -->
		<input type = "hidden" name="memberId" value="${member.memberId}">
		아이디 : <span>${member.memberId}</span> <br>
<!--  	비밀번호 : <input type="password" value=""> -->
		이름 : 		<span>${member.memberName}</span> <br>        
		성별 : 		<span>${member.gender}</span> <br>
		나이 : 		<span>${member.age}</span>    <br>
		이메일 :    <input type="text" name="email" value = "${member.email}"> <br>
		전화번호 :  <input type="text" name="phone" value = "${member.phone}"> <br>
		주소 : 		<input type="text" name="address" value = "${member.address}"> <br>
		취미 :		<input type="text" name="hobby" value = "${member.hobby}"> <br>
		가입일자 :  <span>${member.regDate}</span> <br>
		<input type = "submit" value= "수정하기">
		</form>
	</body>
</html>