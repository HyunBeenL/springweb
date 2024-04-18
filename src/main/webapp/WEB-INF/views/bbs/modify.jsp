<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BBS >> modify</h1>
<form name="frmModify" id="frmModify" method="post" action="/bbs/modify">
    <input type="hidden" id="idx" name="idx" value="${Bbs.idx}">
    <div>
        <span>아이디 : </span><input type="text" name="user_id" id="user_id" value="${Bbs.user_id}" maxlength="20">
    </div>
    <div>
        <span>제목 : </span><input type="text" name="title" id="title" value="${Bbs.title}" maxlength="100">
    </div>
    <div>
        <span>내용 : </span><textarea name="content" id="content" rows="10" cols="60">${Bbs.content}</textarea>
    </div>
    <div>
        <span>출력날짜 : </span><input type="date" name="display_date" id="display_date" value="${Bbs.display_date}" maxlength="10">
    </div>
    <div>
        <span>관심사항 : </span>
        <span>스포츠<input type="checkbox" name="interest" id="interest_0" value="스포츠" /></span>
        <span>여행<input type="checkbox" name="interest" id="interest_1" value="여행" /></span>
        <span>영화<input type="checkbox" name="interest" id="interest_2" value="영화" /></span>
        <span>음악<input type="checkbox" name="interest" id="interest_3" value="음악" /></span>

    </div>
    <div>
        <button type="submit">수정</button>
    </div>

</form>
</body>
</html>
