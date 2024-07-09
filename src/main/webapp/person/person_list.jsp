<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>person_list</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box{
	width: 1000px;
	margin: auto;
	margin-top: 50px;
}

</style>

</head>
<body>
	<div id="box">
		<table class="table">
			<tr class="info">
				<th>순번</th>
				<th>이름</th>
				<th>별명</th>
				<th>나이</th>
				<th>핸드폰번호</th>
				<th>집전화</th>
			</tr>
			<!-- for(PersonVo vo : p_list) -->
			<c:forEach var="vo" items="${ p_list }" varStatus="i">
				<tr>
					<td>${ i.count }</td>
					<td>${ vo.name }</td>
					<td>${ vo.nickName }</td>
					<td>${ vo.age }</td>
					<td>${ vo.tel }</td>
					<td>${ vo.homeTel }</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>