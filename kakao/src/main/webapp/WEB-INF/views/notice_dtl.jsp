<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/mainnav.css">
    <link rel="stylesheet" href="css/notice_dtl.css">
</head>
<body>
    <div class="container">
            <jsp:include page="include/index_include/index_header.jsp"></jsp:include>

        <main>
        
        <div class="notice_dtl_main">
        <input type="hidden" id="notice_code" name ="notice_code"value="${notice.notice_code }">
            <ul class= "nd_header_ul">
                <li>${notice.notice_title }</li>
            </ul>
            <div>
                
                <ul  class="nd_info_ul" >
                    <li >작성자</li>
                    <li>${notice.notice_writer }</li>
                    <li>작성일</li>
                    <li>${notice.notice_date }</li>
                    <li>조회수</li>
                    <li>${notice.notice_count }</li>
                </ul>
                <ul class="nd_content_ul">
                    <li>
                        <pre>${notice.notice_content }</pre>
                    </li>
                </ul>
                
            </div>
        </div>
        <div class="notice_dtl_footer">
            <div class="nd_footer_buttons">
                <button type="button" class="notice_list_button" onclick="location.href='notice'" >목록</button>
              <c:set var="admin_id" value="admin"></c:set>
				<c:set var="admin_user" value="${login_user.id }"></c:set>

				<c:if test="${admin_id eq admin_user }">
                 <button type="button"class="notice_update_button" >수정</button>
                <button type="button"class="notice_delete_button">삭제</button>
                </c:if>
               
            </div>
            <div class="nd_footer_pre_next">
                	<ul class="nd_footer_next">
                        <li class="next_title">다음 글</li>
                        <c:if test="${notice.nextnotice_code ne 0  }">
                        <a href="notice-dtl?code=${notice.nextnotice_code }"><li>${notice.nextnotice_title }</li></a>
                        </c:if>
                        
                    </ul>
                    <ul class="nd_footer_pre">
                        <li class="pre_title">이전 글</li>
                        <c:if test="${notice.prenotice_code ne 0 }">
                        <a href="notice-dtl?code=${notice.prenotice_code }"><li>${notice.prenotice_title }</li></a>
                        </c:if>
                        
                    </ul>
                </div>
        </div>
        </main>
        <footer>

        </footer>
    </div>
        <script src="https://kit.fontawesome.com/639f802672.js" crossorigin="anonymous"></script>
        <script src="js/notice_dtl.js" type="text/javascript"></script>
</body>
</html>