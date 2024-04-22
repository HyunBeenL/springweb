<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오후 4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form name="frmDelete" id="frmDelete" method="post" action="/member/delete?id=${sessionScope.user_id}">
        <table class="table table-bordered">
            <tbody>
            <tr>
                <th scope="col" colspan="2">아이디 <strong>${dto.user_id}</strong></th>
                <th scope="col" colspan="2">비밀번호 <strong>${dto.pwd}</strong></th>

            </tr>
            <tr>

                <td colspan="4" style="min-width: 300px; min-height: 500px;">${dto.birthday}</td>
            </tr>
            <tr>

                <td colspan="4">가입 날짜:<strong>${dto.regdate}</strong></td>

            </tr>
            <tr>
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>
        <button type="button" class="btn btn-primary" onclick="location.href='/member/modify?user_id=${user_id}'">수정</button>
        <input type="submit" class="btn btn-primary" value="탈퇴">
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
