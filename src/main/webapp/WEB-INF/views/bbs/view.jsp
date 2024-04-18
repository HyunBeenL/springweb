<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BBS >> view</h1>
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
    <input type="hidden" name="idx" id="idx" value="${list.idx}">
    <div>
        <span>아이디 : ${list.user_id}</span>
    </div>
    <div>
        <span>제목 : ${list.title}</span>
    </div>
    <div>
        <span>내용 : ${list.content}</span>
    </div>
    <div>
        <span>출력날짜 : ${list.display_date}</span>
    </div>
    <div>
        <span>출력날짜 : ${list.interest}</span>
    </div>
    <div>
        <button type="button" onclick="location.href='/bbs/list'">목록</button>
        <button type="button" onclick="location.href='/bbs/modify?idx=${list.idx}'">수정</button>
        <button type="button" onclick="goDelete()">삭제</button>
    </div>
</form>
<script>
    function goDelete(){
        const frm =document.getElementById("frmDelete");
        let confirm_flag = confirm("게시글을 삭제하시겠습니까?");
        if(confirm_flag){
            frm.submit();
        }
    }
</script>
</body>
</html>
