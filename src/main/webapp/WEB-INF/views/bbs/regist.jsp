<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>BBS >> Regist</h1>

<form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
    <div>
        <span>아이디 : </span><input type="text" name="user_id" id="user_id" value="${errdto.getUser_id()}" maxlength="20">
        <div id="div_err_user_id" style="display:none"></div>
    </div>
    <div>
        <span>제목 : </span><input type="text" name="title" id="title" value="${errdto.getTitle()}" maxlength="100">
        <div id="div_err_title" style="display:none"></div>
    </div>
    <div>
        <span>내용 : </span><textarea name="content" id="content" rows="10" cols="60">${errdto.getContent()}</textarea>
        <div id="div_err_content" style="display:none"></div>
    </div>
    <div>
        <span>출력날짜 : </span><input type="date" name="display_date" id="display_date" value="${errdto.getDisplay_date()}" maxlength="10">
        <div id="div_err_display_date" style="display:none"></div>
    </div>
    <div>
        <span>관심사항 : </span>
        <span>스포츠<input type="checkbox" name="interest" id="interest_0" value="스포츠" /></span>
        <span>여행<input type="checkbox" name="interest" id="interest_1" value="여행" /></span>
        <span>영화<input type="checkbox" name="interest" id="interest_2" value="영화" /></span>
        <span>음악<input type="checkbox" name="interest" id="interest_3" value="음악" /></span>

    </div>
    <div>
        <button type="submit">글등록</button>
    </div>
</form>

<script>
    <%--const serverVailseResult = {};--%>
    <%--<c:forEach items="${errors}" var="err">--%>
    <%--    if(document.getElementById("div_err_${err.getField()}")!=null){--%>
    <%--        document.getElementById("div_err_${err.getField()}").innerHTML="<span style='color:red'>${err.defaultMessage}</span>"--%>
    <%--        document.getElementById("div_err_${err.getField()}").style.display="block";--%>
    <%--    }--%>
    <%--    serverVailseResult['${err.getField()}'] = '${err.defaultMessage}';--%>
    <%--</c:forEach>--%>

    <%--console.log(serverVailseResult);--%>
    const serverValiseResult = {};
    <c:forEach items="${errors}" var="err">
        if(document.getElementById("div_err_${err.getField()}") != null) {
            document.getElementById("div_err_${err.getField()}").innerHTML = "<span style='color: red'>${err.getField()}필드는 ${err.defaultMessage}</span>";
            document.getElementById("div_err_${err.getField()}").style.display = "block";
        }
        serverValiseResult['${err.getField()}'] = '${err.defaultMessage}';
    </c:forEach>

    console.log(serverValiseResult);

</script>
</body>
</html>