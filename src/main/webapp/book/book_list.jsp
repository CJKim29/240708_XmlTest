<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book_list</title>

<!--  Bootstrap  3.x  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
img{
	width: 120px;
	height: 100px;
}
</style>

</head>
<body>
	<table class="table">
		<tr class="success">
			<th>순번</th>
			<th>이미지</th>
			<th>도서명</th>
			<th>작가</th>
			<th>할인가</th>
			<th>출판사</th>
			<th>출판일</th>
		</tr>
		<!-- for(ProductVo vo : p_list) -->
		<c:forEach var="vo" items="${ b_list }" varStatus="i">
			<tr>
				<td>${ vo.no }</td>
				<td><img src="${ vo.image }"></td>
				<td><a href="${ vo.link }">${ vo.title }</a></td>
				<td>${ vo.author }</td>
				<td><fmt:formatNumber type="currency" value="${ vo.discount }"/></td>
				<td>${ vo.publisher }</td>
				<td> ${ vo.pubdate }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>