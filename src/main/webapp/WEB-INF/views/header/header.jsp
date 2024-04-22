<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-19
  Time: 오후 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<header>
<ul class="nav justify-content-end">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/bbs/list"></a>
    </li>
    <li class="nav-item">
        <a class="btn btn-primary" href="/bbs/list">게시판</a>
    </li>
    <c:if test="${sessionScope.user_id eq null}">
    <li class="nav-item">
        <a class="btn btn-primary" href="/member/join">회원 가입</a>
    </li>
    </c:if>
    <c:if test="${sessionScope.user_id ne null}">
        <a class="btn btn-primary" href="/member/view?user_id=${sessionScope.user_id}">마이 페이지</a>
    </c:if>
    <li class="nav-item">
        <c:if test="${sessionScope.user_id eq null}">
        <a class="btn btn-primary" href="/login/login">로그인</a>
        </c:if>
        <c:if test="${sessionScope.user_id ne null}">
            <a class="btn btn-primary" href="/login/logout">로그아웃</a>
        </c:if>
    </li>
</ul>
</header>
</html>
