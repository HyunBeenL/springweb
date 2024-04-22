<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
    </style>
</head>

<body>
<div class="container">
<form name="frmDelete" id="frmDelete" method="post" action="/bbs/delete">
    <table class="table table-bordered">
        <tbody>
        <tr>
            <th scope="col" colspan="2">작성자 <strong>${list.user_id}</strong></th>
            <th scope="col" colspan="2">제목 <strong>${list.title}</strong></th>

        </tr>
        <tr>

            <td colspan="4" style="min-width: 300px; min-height: 500px;">${list.content}</td>

        </tr>
        <tr>

            <td colspan="4">등록 일자:<strong>${list.display_date}</strong></td>

        </tr>
        <tr>
            <th scope="row">3</th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
        </tr>
        </tbody>
    </table>
    <input type="hidden" name="idx" id="idx" value="${list.idx}">
    <div>
        <button type="button" class="btn btn-primary" onclick="location.href='/bbs/list'">목록</button>
        <c:if test="${sessionScope.user_id eq list.user_id}">
        <button type="button" class="btn btn-primary" onclick="location.href='/bbs/modify?idx=${list.idx}'">수정</button>
        <button type="button" class="btn btn-primary" onclick="goDelete()">삭제</button>
        </c:if>

    </div>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
