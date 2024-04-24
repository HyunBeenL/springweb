<%@ page import="java.util.ArrayList" %><%--
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
    <h1>회원 가입</h1>
    <form name="frmJoin" id="frmJoin" class="row mb-3" method="post" action="/member/join">
        <div class="col-sm-10">
            <span>이름 : </span><input type="text" class="form-control" name="user_name" id="user_name" value="" maxlength="20" >
            <div id="div_err_user_name" style="display:none"></div>
        </div>
        <div class="col-sm-10">
            <span>아이디 : </span><input type="text" class="form-control" name="user_id" id="user_id" value="" maxlength="20" >
            <div id="div_err_user_id" style="display:none"></div>
            <p id ="iderr"></p>
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
            <span>생년월일 : </span><input type="date" class="form-control" name="birthday" id="birthday" value="" maxlength="100">
        </div>
        <div class="col-sm-10">
            <span>이메일 : </span><input type="email" class="form-control" name="email" id="email" value="" maxlength="100">
            <p id ="emailerr"></p>
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
            <button type="submit" id="joinbtn" class="btn btn-primary">회원 가입</button>
        </div>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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


    // for(let i =0; i<siList.size;i++){
    //     console.log(siList.get(i));
    //     document.querySelector("#si").innerHTML="<option>"+siList.get(i)+"</option>"
    // }










    ////////////////////////////////////////////////////////////
    let idconfirm = false;
    let birthconfirm = true;
    let pwdconfirm = false;
    let pwdequalconfirm = false;
    let idList = new Array();
    idList = ${idList};

    /////////////////에러메시지 영역//////////////////////
    let iderr = document.querySelector('#iderr');
    let pwderr = document.querySelector('#pwderr');
    let pwderr2 = document.querySelector('#pwdequal');
    let emailerr = document.querySelector('#emailerr');

    /////////////////INPUT태그 영역///////////////////
    let id = document.querySelector('#user_id');
    let pwd = document.querySelector('#pwd');
    let pwd2 = document.querySelector('#password2');
    let email = document.querySelector('#email');

    var idcheck = function(){
        if(idList.length ==0){
            idconfirm = true;
        }
        else{
            for(let i = 0; i<idList.length;i++){
                if(id.value === idList[i]){
                    iderr.innerHTML = "이미 존재하는 아이디 입니다.";
                    iderr.style.color= "red";
                    idconfirm = false;
                    console.log("아이디확인"+idconfirm);
                    break;
                }
                else{
                    iderr.innerHTML = "사용할 수 있는 아이디 입니다.";
                    iderr.style.color= "green";
                    idconfirm = true;
                    console.log("아이디확인"+idconfirm);
                }
                console.log(idconfirm);
            }
        }
    }
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

    document.querySelector("#joinbtn").addEventListener('click', (e)=>{
        e.preventDefault();
        if(idconfirm && birthconfirm && pwdconfirm && pwdequalconfirm){
            document.querySelector("#frmJoin").submit();
        }
        else{
            console.log(idconfirm);
            console.log(birthconfirm);
            console.log(pwdconfirm);
            console.log(pwdequalconfirm);
            alert("확인 다시할것");
            return false;
        }

    });

    id.addEventListener("keyup", idcheck);
    id.addEventListener("keypress", idcheck);
    pwd.addEventListener("keyup", pwdcheck);
    pwd.addEventListener("keypress", pwdcheck);
    pwd.addEventListener("keyup", pwdequal);
    pwd.addEventListener("keypress", pwdequal);
    pwd2.addEventListener("keyup", pwdequal);
    pwd2.addEventListener("keypress", pwdequal);
</script>
</body>
</html>