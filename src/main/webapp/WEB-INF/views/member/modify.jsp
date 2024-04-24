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
    <h1>회원정보 수정</h1>
    <form name="frmJoin" id="frmModify" class="row mb-3" method="post" action="/member/modify">
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
            <p id ="pwderr"></p>
        </div>
        <div class="col-sm-10">
            <span >비밀번호 확인</span>
            <input type="password" id ="password2" class="form-control" name="password2" maxlength="30"  placeholder="비밀번호 다시 입력" required>
            <p id ="pwdequal"></p>
        </div>
        <div class="col-sm-10">
            <span>생년월일 : </span><input type="date" class="form-control" name="birthday" id="birthday" value="${dto.birthday}" maxlength="100" readonly>
        </div>
        <div class="col-sm-10">
            <span>이메일 : </span><input type="email" class="form-control" name="email" id="email" value="${dto.email}" maxlength="100" readonly>
        </div>

        <div class="col-sm-10">
            <span>주소 : </span>
            <select class="form-control" name="addr1" id="si" onchange="GetGuList(this)">


            </select>
            <select class="form-control" name="addr2" id="gu">

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
            <button type="submit" id= "Modifybtn" class="btn btn-primary">수정</button>
        </div>
    </form>
</div>
<script>
    $.ajax({
        url:"/area/siList.dox",
        dataType:"json",
        type : "POST",

        success : function(data) {
            let si = document.querySelector("#si");
            si.innerHTML = '<option value="" selected disabled>시</option>';
            for(let e of data.list){
                let op = document.createElement('option');
                op.innerText = e;
                op.setAttribute('value', e);
                si.append(op);
            }
        }
    });

    function GetGuList(item){
        $.ajax({
            url:"/area/guList.dox",
            dataType:"json",
            type : "POST",
            data : {
                "si" : item.value
            },
            success : function(data) {
                let gu = document.querySelector("#gu");
                gu.innerHTML = '<option value="" selected disabled>구</option>';
                for(let e of data.list){
                    let op = document.createElement('option');
                    op.innerText = e;
                    op.setAttribute('value', e);
                    gu.append(op);
                }
            }
        });

    }


    /////////////////////////////////////////////////////////////////////////

    let pwdconfirm = false;
    let pwdequalconfirm = false;

    let pwderr = document.querySelector('#pwderr');
    let pwderr2 = document.querySelector('#pwdequal');

    let pwd = document.querySelector('#pwd');
    let pwd2 = document.querySelector('#password2');

    var pwdcheck = function() {
        if(pwd.value.match(/[a-zA-Z]/g) == null
            || pwd.value.match(/[0-9]/g) == null
            || pwd.value.match(/[\W_]/g) == null
            || pwd.value.length<10 ||pwd.value.length >16){
            pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;10글자~16글자이내 영어/숫자/특수문자를 최소 하나씩넣어서 작성해주세요</strong>"
            pwderr.style.color = "red";
            pwdconfirm = false;
        }
        else{
            pwderr.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;올바른 비밀번호입니다.";
            pwderr.style.color = "green";
            pwdconfirm = true;
        }
    }
    var pwdequal = function(){
        if(pwd.value !== pwd2.value){
            pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치하지 않습니다.</strong>"
            pwderr2.style.color = "red";
            pwdequalconfirm = false;
        }
        else{
            pwderr2.innerHTML = "<strong>&nbsp;&nbsp;&nbsp;비밀번호가 일치합니다.</strong>";
            pwderr2.style.color = "green";
            pwdequalconfirm = true;
        }
    }

    document.querySelector("#Modifybtn").addEventListener('click', (e)=>{
        e.preventDefault();
        if( pwdconfirm && pwdequalconfirm){
            document.querySelector("#frmModify").submit();
        }
        else{
            console.log(pwdconfirm);
            console.log(pwdequalconfirm);
            alert("확인 다시할것");
            return false;
        }

    });

    pwd.addEventListener("keyup", pwdcheck);
    pwd.addEventListener("keypress", pwdcheck);
    pwd.addEventListener("keyup", pwdequal);
    pwd.addEventListener("keypress", pwdequal);
    pwd2.addEventListener("keyup", pwdequal);
    pwd2.addEventListener("keypress", pwdequal);


</script>
</body>
</html>
