<%--<%@ page import="org.fullstack4.springmvc.Common.CommonUtil" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: user--%>
<%--  Date: 2024-04-17--%>
<%--  Time: 오전 9:30--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page trimDirectiveWhitespaces="true" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f4f4f4;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--        }--%>

<%--        .container {--%>
<%--            max-width: 800px;--%>
<%--            margin: 20px auto;--%>
<%--            background-color: #fff;--%>
<%--            padding: 20px;--%>
<%--            border-radius: 5px;--%>
<%--            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);--%>
<%--        }--%>

<%--        h1 {--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .viewdetail{--%>
<%--            text-decoration: none;--%>
<%--            color:black;--%>
<%--        }--%>

<%--    </style>--%>
<%--</head>--%>
<%--<header style="background-color:white; border-bottom: 1px solid black; height: 100px;">--%>
<%--    <jsp:include page="../header/header.jsp" />--%>
<%--</header>--%>
<%--<body>--%>
<%--    <div class="container">--%>
<%--        <div style="float:right;">--%>
<%--        <button type="button" class="btn btn-primary" id="registbtn" onclick="location.href='/bbs/regist'">글 작성</button>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--        <h1>게시판</h1>--%>
<%--            <form action="/bbs/list">--%>
<%--                <div class="col-sm-10">--%>
<%--                    <span >제목</span><input type="checkbox" class="form-check-input" id="search_type1" name="search_type" value="t" style="margin:25px;">--%>
<%--                    <span >작성자</span><input type="checkbox" class="form-check-input" id="search_type2" name="search_type" value="u" style="margin:25px;">--%>
<%--                    <input type="text" id="search" name="search_word" maxlength="20" style="margin:20px;">--%>
<%--                </div>--%>
<%--                <div class="col-sm-10">--%>
<%--                    <span >등록 시작일</span><input type="date" id="startdate" name="startdate" maxlength="20" style="margin:20px;">--%>
<%--                    <span >등록일 끝</span><input type="date" id="enddate" name="enddate" maxlength="20" style="margin:20px;">--%>
<%--                </div>--%>

<%--                <button type="submit" class="btn btn-primary" id="search-btn" style="margin:20px;">검색</button>--%>
<%--            </form>--%>
<%--        <table class="table table-hover">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th scope="col">#</th>--%>
<%--                <th scope="col">Title</th>--%>
<%--                <th scope="col">Reg_Date</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--                <c:forEach items="${bbsList}" var="list">--%>
<%--                    <tr>--%>
<%--                        <th scope="row">${list.idx}</th>--%>
<%--                        <td><a href="/bbs/view?idx=${list.idx}" class="viewdetail">${list.title}</a></td>--%>
<%--                        <td>${list.reg_date}</td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--        <nav aria-label="Page navigation example" >--%>
<%--            <ul class="pagination">--%>
<%--                <li class="page-item"><a class="page-link" href="/bbs/list?page=${page-1}&bar=${barcount}">Previous</a></li>--%>
<%--                <c:forEach begin="${barcount}" end="${pagecount}" var="num">--%>
<%--                <li class="page-item"><a class="page-link" href="/bbs/list?page=${num}&bar=${barcount}">${num}</a></li>--%>
<%--                </c:forEach>--%>
<%--                <li class="page-item"><a class="page-link" href="/bbs/list?page=${page+1}&bar=${barcount}">Next</a></li>--%>
<%--            </ul>--%>
<%--        </nav>--%>
<%--        </div>--%>


<%--&lt;%&ndash;        <ul class="post-list">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <c:forEach items="${bbsList}" var="list">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><c:out value="${list}"/></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </c:forEach>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </ul>&ndash;%&gt;--%>
<%--    </div>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>

<%--</body>--%>
<%--</html>--%>



<%--////////////////////////////////////강사님코드/////////////////////////////////--%>

<%@ page import="org.fullstack4.springmvc.Common.CommonUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:30
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

        h1 {
            text-align: center;
        }

        .viewdetail{
            text-decoration: none;
            color:black;
        }

    </style>
</head>
<header style="background-color:white; border-bottom: 1px solid black; height: 100px;">
    <%@include file="../header/header.jsp"%>

</header>
<body>
    <div class="container">
        <div style="float:right;">
        <button type="button" class="btn btn-primary" id="registbtn" onclick="location.href='/bbs/regist'">글 작성</button>
        </div>
        <div>
        <h1>게시판</h1>
            <form action="/bbs/list">
                <div class="col-sm-10">
                    <span >제목</span><input type="checkbox" class="form-check-input" id="search_type1" name="search_type" value="t" style="margin:25px;">
                    <span >작성자</span><input type="checkbox" class="form-check-input" id="search_type2" name="search_type" value="u" style="margin:25px;">
                    <input type="text" id="search_word" name="search_word" maxlength="20" style="margin:20px;">
                </div>
                <div class="col-sm-10">
                    <span >등록 시작일</span><input type="date" id="startdate" name="search_date" maxlength="20" style="margin:20px;">
                    <span >등록일 끝</span><input type="date" id="enddate" name="search_date2" maxlength="20" style="margin:20px;">
                </div>

                <button type="submit" class="btn btn-primary" id="search-btn" style="margin:20px;">검색</button>
            </form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">작성자</th>
                <th scope="col">Reg_Date</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${responseDTO.dtoList}" var="list">
                    <tr>
                        <th scope="row">${responseDTO.total_count}</th>
                        <td><a href="/bbs/view?idx=${list.idx}" class="viewdetail">${list.title}</a></td>
                        <td>${list.user_id}</td>
                        <td>${list.reg_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example" >
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/bbs/list?page=${page-1}&bar=${barcount}&search_type=${responseDTO.search_type[0]}&search_type=${responseDTO.search_type[1]}&search_word=${responseDTO.search_word}&search_date=${responseDTO.search_date}&search_date2=${responseDTO.search_date2}">Previous</a></li>
                <c:forEach begin="${responseDTO.page_block_start}" end="${responseDTO.total_page}" var="num">
                <li class="page-item"><a class="page-link" href="/bbs/list?page=${num}&bar=${barcount}&search_type=${responseDTO.search_type[0]}&search_type=${responseDTO.search_type[1]}&search_word=${responseDTO.search_word}&search_date=${responseDTO.search_date}&search_date2=${responseDTO.search_date2}">${num}</a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="/bbs/list?page=${page+1}&bar=${barcount}&search_type=${responseDTO.search_type[0]}&search_type=${responseDTO.search_type[1]}&search_word=${responseDTO.search_word}&search_date=${responseDTO.search_date}&search_date2=${responseDTO.search_date2}">Next</a></li>
            </ul>
        </nav>
        </div>


<%--        <ul class="post-list">--%>
<%--            <c:forEach items="${bbsList}" var="list">--%>
<%--                <li><c:out value="${list}"/></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>