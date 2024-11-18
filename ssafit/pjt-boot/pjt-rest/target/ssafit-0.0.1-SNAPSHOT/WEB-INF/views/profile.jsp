<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT - ${profileUser.username}의 프로필</title>
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
            <h1>${profileUser.username}의 프로필</h1>
            <p>이메일: ${profileUser.email}</p>
            <p>가입일: ${profileUser.createdAt}</p>
            
            <c:if test="${not empty sessionScope.user && sessionScope.user.userId ne profileUser.userId}">
                <c:choose>
                    <c:when test="${isFollowing}">
                        <form action="<c:url value='/user/unfollow'/>" method="POST">
                            <input type="hidden" name="followingId" value="${profileUser.userId}">
                            <button type="submit">언팔로우</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="<c:url value='/user/follow'/>" method="POST">
                            <input type="hidden" name="followingId" value="${profileUser.userId}">
                            <button type="submit">팔로우</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </c:if>
            
            <h2>팔로워</h2>
            <ul>
                <c:forEach items="${followers}" var="follower">
                    <li><a href="<c:url value='/user/profile?id=${follower}'/>">${follower}</a></li>
                </c:forEach>
            </ul>
            
            <h2>팔로잉</h2>
            <ul>
                <c:forEach items="${following}" var="following">
                    <li><a href="<c:url value='/user/profile?id=${following}'/>">${following}</a></li>
                </c:forEach>
            </ul>
            
            <h2>찜한 영상</h2>
            <div class="video-grid">
                <c:forEach items="${favoriteVideos}" var="video">
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