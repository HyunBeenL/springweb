<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        .post-list {
            list-style: none;
            padding: 0;
        }

        .post-list li {
            margin-bottom: 10px;
        }

        .post-list li a {
            text-decoration: none;
            color: #333;
            display: block;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .post-list li a:hover {
            background-color: #f0f0f0;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>게시판</h1>
        <ul class="post-list">
        <c:forEach items="${bbsList}" var="list">
            <li><a href="/bbs/view?idx=${list.idx}">${list.title}</a></li>
        </c:forEach>
        </ul>

<%--        <ul class="post-list">--%>
<%--            <c:forEach items="${bbsList}" var="list">--%>
<%--                <li><c:out value="${list}"/></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
</body>
</html>
