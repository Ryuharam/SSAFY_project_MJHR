<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT - 운동 영상 목록</title>
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
            <h1>
                <c:choose>
                    <c:when test="${not empty part}">${part} 운동 영상</c:when>
                    <c:otherwise>전체 운동 영상</c:otherwise>
                </c:choose>
            </h1>
            
            <div class="video-grid">
                <c:forEach items="${videos}" var="video">
                    <div class="video-card">
                        <h3>${video.title}</h3>
                        <p>조회수: ${video.viewCount}</p>
                        <p>운동 부위: ${video.part}</p>
                        <a href="<c:url value='/video/detail?id=${video.videoId}'/>">자세히 보기</a>
                    </div>
                </c:forEach>
            </div>
        </main>
        
        <footer>
            <p>&copy; 2023 SSAFIT. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>