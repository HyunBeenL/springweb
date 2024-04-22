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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>게시글 등록</h1>
<form name="frmRegist" id="frmRegist" class="row mb-3" method="post" action="/bbs/regist">
    <div class="col-sm-10">
        <span>작성자 : </span><input type="text" class="form-control" name="user_id" id="user_id" value="${sessionScope.user_id}" maxlength="20" readonly>
        <div id="div_err_user_id" style="display:none"></div>
    </div>
    <div class="col-sm-10">
        <span>제목 : </span><input type="text" class="form-control" name="title" id="title" value="${errdto.getTitle()}" maxlength="100">
        <div id="div_err_title" style="display:none"></div>
    </div>
    <div class="col-sm-10">
        <span>내용 : </span><textarea name="content" class="form-control" id="content" rows="10" cols="60">${errdto.getContent()}</textarea>
        <div id="div_err_content" style="display:none"></div>
    </div>
    <div class="col-sm-10">
        <span>출력날짜 : </span><input type="date" class="form-control" name="display_date" id="display_date" value="${errdto.getDisplay_date()}" maxlength="10">
        <div id="div_err_display_date" style="display:none"></div>
    </div>
    <div class="col-sm-10">
        <span>관심사항 : </span>
        <span>스포츠<input type="checkbox" class="form-check-input" name="interest" id="interest_0" value="스포츠" /></span>
        <span>여행<input type="checkbox" class="form-check-input" name="interest" id="interest_1" value="여행" /></span>
        <span>영화<input type="checkbox" class="form-check-input" name="interest" id="interest_2" value="영화" /></span>
        <span>음악<input type="checkbox" class="form-check-input" name="interest" id="interest_3" value="음악" /></span>

    </div>
    <div class="col-12" style="text-align: center; margin-top:20px;">
        <button type="submit" class="btn btn-primary">글 등록</button>
    </div>
</form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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