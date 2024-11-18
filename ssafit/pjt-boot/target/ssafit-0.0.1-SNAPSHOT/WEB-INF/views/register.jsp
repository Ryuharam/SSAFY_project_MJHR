<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFIT - 회원가입</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <div class="container">
        <h1>회원가입</h1>
        <form action="<c:url value='/user/register'/>" method="POST">
            <div>
                <label for="userId">아이디:</label>
                <input type="text" id="userId" name="userId" required>
            </div>
            <div>
                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <label for="username">이름:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="email">이메일:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div>
                <button type="submit">가입하기</button>
            </div>
        </form>
    </div>
</body>
</html>