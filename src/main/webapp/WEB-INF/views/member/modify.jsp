<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1>회원 가입</h1>
    <form name="frmJoin" id="frmJoin" class="row mb-3" method="post" action="/member/modify">
        <div class="col-sm-10">
            <span>이름 : </span><input type="text" class="form-control" name="user_name" id="user_name" value="${dto.user_name}" maxlength="20" readonly >
            <div id="div_err_user_name" style="display:none"></div>
        </div>
        <div class="col-sm-10">
            <span>아이디 : </span><input type="text" class="form-control" name="user_id" id="user_id" value="${dto.user_id}" maxlength="20" >
            <div id="div_err_user_id" style="display:none"></div>
        </div>
        <div class="col-sm-10">
            <span>비밀번호 : </span><input type="password" class="form-control" name="pwd" id="pwd" value="" maxlength="100">
            <div id="div_err_title" style="display:none"></div>
        </div>
        <div class="col-sm-10">
            <span>생년월일 : </span><input type="date" class="form-control" name="birthday" id="birthday" value="${dto.birthday}" maxlength="100" readonly>
        </div>
        <div class="col-sm-10">
            <span>이메일 : </span><input type="email" class="form-control" name="email" id="email" value="${dto.email}" maxlength="100" readonly>
        </div>

        <div class="col-sm-10">
            <span>주소 : </span>
            <select class="form-control" name="addr1">
                <option selected disabled>도</option>
                <option>서울특별시</option>
                <option>경기도</option>
                <option>경상도</option>

            </select>
            <select class="form-control" name="addr2">
                <option selected disabled>시</option>
                <option>부천시</option>
                <option>인천시</option>
                <option>서울시</option>

            </select>
        </div>
        <div class="col-sm-10">
            <span>관심사항 : </span>
            <span>스포츠<input type="checkbox" class="form-check-input" name="interest" id="interest_0" value="스포츠" /></span>
            <span>여행<input type="checkbox" class="form-check-input" name="interest" id="interest_1" value="여행" /></span>
            <span>영화<input type="checkbox" class="form-check-input" name="interest" id="interest_2" value="영화" /></span>
            <span>음악<input type="checkbox" class="form-check-input" name="interest" id="interest_3" value="음악" /></span>

        </div>
        <div class="col-12" style="text-align: center; margin-top:20px;">
            <button type="submit" class="btn btn-primary">수정</button>
        </div>
    </form>
</div>
</body>
</html>
