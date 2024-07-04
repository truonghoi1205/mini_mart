<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/4/2024
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Nhập thông tin nhân sự</h4>
<form action="/admin/users/create" method="post">
    <div>
        <input type="text" class="form-control" id="name" placeholder="tên" name="name">
        <label for="name" class="form-label">Tên</label>
    </div>
    <div>
        <input type="text" class="form-control" id="email" placeholder="email" name="email">
        <label for="email" class="form-label">email</label>
    </div>
    <div>
        <input type="text" class="form-control" id="password" placeholder="password" name="password">
        <label for="password" class="form-label">password</label>
    </div>
    <div >
        <button type="submit">Lưu</button>
        <a href="/admin/users/list">Huỷ</a>
    </div>
</form>
</body>
</html>
