<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2021/5/25
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增数据</title>
</head>
<body>
    <h1>新增书籍</h1>

    <form action="/book/addBook" method="post">
        <input type="hidden" name="bookID" value="${book.bookID}">
        <input type="text" name="bookName" value="${book.bookName}">
        <input type="text" name="bookCounts" value="${book.bookCounts}">
        <input type="text" name="detail" value="${book.detail}">

        <input type="submit">
    </form>
</body>
</html>
