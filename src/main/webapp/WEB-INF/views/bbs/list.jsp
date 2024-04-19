<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-17
  Time: 오전 9:30
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

        h1 {
            text-align: center;
        }

        .viewdetail{
            text-decoration: none;
            color:black;
        }

    </style>
</head>
<body>
    <div class="container">
        <% if(session.getAttribute("user_id") == null){ %>
        <button class="btn btn-primary" onclick="location.href='/login/login'">로그인</button>
        <% }else{ %>
        <button class="btn btn-primary" onclick="location.href='/login/logout'">로그아웃</button>
        <%}%>
        <h1>게시판</h1>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Reg_Date</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${bbsList}" var="list">
                    <tr>
                        <th scope="row">${list.idx}</th>
                        <td><a href="/bbs/view?idx=${list.idx}" class="viewdetail">${list.title}</a></td>
                        <td>${list.reg_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example" >
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <%for(int i =1; i<=10; i++){%>
                <li class="page-item"><a class="page-link" href="#"><%=i%></a></li>
                <%}%>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>


<%--        <ul class="post-list">--%>
<%--            <c:forEach items="${bbsList}" var="list">--%>
<%--                <li><c:out value="${list}"/></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
