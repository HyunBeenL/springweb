<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BBS >> Regist</h1>

<form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
    <div>
        <span>아이디 : </span><input type="text" name="user_id" id="user_id" value="" maxlength="20">
    </div>
    <div>
        <span>제목 : </span><input type="text" name="title" id="title" value="" maxlength="100">
    </div>
    <div>
        <span>내용 : </span><textarea name="content" id="content" rows="10" cols="60"></textarea>
    </div>
    <div>
        <span>출력날짜 : </span><input type="date" name="display_date" id="display_date" value="" maxlength="10">
    </div>
    <div>
        <button type="submit">글등록</button>
    </div>

</form>

</body>
</html>