<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT - 로그인</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <div class="container">
        <h1>로그인</h1>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <form action="<c:url value='/user/login'/>" method="POST">
            <div>
                <label for="userId">아이디:</label>
                <input type="text" id="userId" name="userId" required>
            </div>
            <div>
                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <button type="submit">로그인</button>
            </div>
        </form>
        <p>계정이 없으신가요? <a href="<c:url value='/user/register'/>">회원가입</a></p>
    </div>
</body>
</html>