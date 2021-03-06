<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/mainnav.css">
<link rel="stylesheet" href="css/notice.css">
</head>
<body>
	<div class="container">
		<jsp:include page="include/index_include/index_header.jsp"></jsp:include>
		<main>
			<div class="notice_header">
				<ul>
					<li class="notice_num">번호</li>
					<li class="notice_title">제목</li>
					<li class="notice_writer">작성자</li>
					<li class="notice_date">작성일</li>
					<li class="notice_count">조회수</li>
				</ul>
			</div>
			<div class="notice_main">
				<c:forEach var="notice" items="${noticeList }">
					<a href="notice-dtl?code=${notice.notice_code }">
						<ul>
							<li class="notice_num">${notice.notice_code }</li>
							<li class="notice_title">${notice.notice_title }</li>
							<li class="notice_writer">${notice.notice_writer }</li>
							<li class="notice_date">${notice.notice_date }</li>
							<li class="notice_count">${notice.notice_count }</li>
						</ul>
					</a>
				</c:forEach>

			</div>
			<div class="notice_footer">
				<c:set var="admin_id" value="admin"></c:set>
				<c:set var="admin_user" value="${login_user.id }"></c:set>

				<c:if test="${admin_id eq admin_user }">
					<div class="notice_insert_div">
						<button type="button" class="notice_insert_button"
							onclick="location.href='notice-insert'">글쓰기</button>
					</div>
				</c:if>



				<ul>
					<a
						href="notice?notice-page=${pages[1] - 1 eq 0 ? 1 : pages[1] - 1 }"><li><i
							class="fas fa-arrow-circle-left"></i></li></a>

					<c:forEach var="i" begin="${pages[1] }" end="${pages[2] }">
						<a href="notice?notice-page=${i }"><li>${i }</li></a>
					</c:forEach>

					<a
						href="notice?notice-page=${pages[2] eq pages[0] ? pages[2] : pages[2] + 1 }"><li><i
							class="fas fa-arrow-circle-right"></i></li></a>
				</ul>
			</div>
		</main>
		<footer> </footer>
	</div>
	<script src="https://kit.fontawesome.com/639f802672.js"
		crossorigin="anonymous"></script>
</body>
</html>