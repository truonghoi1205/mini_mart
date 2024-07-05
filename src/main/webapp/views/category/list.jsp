<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Phân Loại</h1>
<a href="/admin/categories/create">Thêm phân loại</a>
<form action="/admin/categories/search" method="get">
    <input type="text"  name="name" placeholder="Tìm theo phân loại " value="${name}">
    <button type="submit" >Tìm Kiếm </button>
</form>
<table>
    <tr>
        <th>#</th>
        <th>Ảnh</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Hành động</th>
    </tr>
<c:forEach var="category" items="${categories}" varStatus="status">
    <tr>
    <td>${status.count}</td>
    <td>
    <img src="${category.avatar}" class="img-fluid" style="width: 40px;">
    </td>
    <td>${category.name}</td>

    <td>${category.description}</td>
    <td>
    <a href="/admin/categories/update?id=${category.id}">Sửa</a>
    <a href="/admin/categories/delete?id=${category.id}">Xoá</a>
    </td>
    </tr>
</c:forEach>
</table>
<%@include file="/views/shared/footer.jsp" %>

</body>
</html>
