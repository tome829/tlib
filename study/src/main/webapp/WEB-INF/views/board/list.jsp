<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr>
		<nav>
			<%@include file="nav.jsp" %>
		</nav>
		<hr>
		<section id="container">
			<form role="form" method="post" action="/board/write">
				<table border="1">
					<tr><th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>등록일</th></tr>
					<!--  
					<c:forEach items="${list}" var = "list">
						<tr>
							<td><c:out value="${list.bno}"/></td>
							<td><c:out value="${list.title}"/></td>
							<td><c:out value="${list.writer}"/></td>
							<td><fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>-->
					<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.bno}" /></td>
								<td>
									<a href="/board/readView?bno=${list.bno}"><c:out value="${list.title}" /></a>
								</td>
								<td><c:out value="${list.content}" /></td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					
				</table>
			</form>
		</section>
		<hr>
	</div>
</body>
</html>