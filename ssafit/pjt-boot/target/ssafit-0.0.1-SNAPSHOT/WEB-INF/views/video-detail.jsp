<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT - ${video.title}</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <div class="container">
        <header>
            <h1>SSAFIT</h1>
            <nav>
                <a href="<c:url value='/'/>">홈</a>
                <a href="<c:url value='/video/popular'/>">인기 영상</a>
                <a href="<c:url value='/video/part?part=상체'/>">상체 운동</a>
                <a href="<c:url value='/video/part?part=하체'/>">하체 운동</a>
                <a href="<c:url value='/video/part?part=전신'/>">전신 운동</a>
            </nav>
        </header>
        
        <main>
            <div class="video-container">
                <iframe width="100%" height="500" src="${video.url}" frameborder="0" allowfullscreen></iframe>
            </div>
            
            <div class="video-info">
                <h1>${video.title}</h1>
                <p>조회수: ${video.viewCount}</p>
                <p>운동 부위: ${video.part}</p>
                
                <c:if test="${not empty sessionScope.user}">
                    <c:choose>
                        <c:when test="${isFavorite}">
                            <form action="<c:url value='/favorite/remove'/>" method="POST">
                                <input type="hidden" name="videoId" value="${video.videoId}">
                                <button type="submit">찜 취소</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="<c:url value='/favorite/add'/>" method="POST">
                                <input type="hidden" name="videoId" value="${video.videoId}">
                                <button type="submit">찜하기</button>
                            </form>
                        </c:otherwise>
                         </c:choose>
                </c:if>
            </div>
            
            <div class="reviews">
                <h2>리뷰</h2>
                <c:if test="${not empty sessionScope.user}">
                    <form action="<c:url value='/review/add'/>" method="POST">
                        <input type="hidden" name="videoId" value="${video.videoId}">
                        <textarea name="content" rows="4" cols="50" required></textarea>
                        <button type="submit">리뷰 작성</button>
                    </form>
                </c:if>
                
                <div class="review-list">
                    <c:forEach items="${reviews}" var="review">
                        <div class="review">
                            <p>${review.content}</p>
                            <small>작성자: ${review.userId} | 작성일: ${review.createdAt}</small>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
        
        <footer>
            <p>&copy; 2023 SSAFIT. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>