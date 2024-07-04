<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/admin/users/list">Danh sách Nhân sự</a>
<a href="/admin/users/create">Thêm nhân sự</a>
<form action="/admin/users/search" method="get">
    <input type="text"  name="name" placeholder="Tìm theo tên " value="${name}">
    <button type="submit" >Tìm Kiếm </button>
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>
                <a href="/admin/users/update?id=${user.id}">Sửa</a>
                <a href="/admin/users/delete?id=${user.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
