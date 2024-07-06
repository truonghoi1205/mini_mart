<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/4/2024
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>

<div class="container pt-5">
    <div class="w-50 shadow mx-auto py-4 rounded-3">
        <h2 class="text-center display-6 text-primary">Cập nhật nhân viên</h2>
    </div>
    <form class="w-50 mx-auto mt-4 shadow rounded-3 p-5 " action="/admin/users/create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên nhân viên</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
            <p class="text-danger mt-2">${existsEmail}</p>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="text" class="form-control" id="password" name="password" value="${user.password}" required>
        </div>

        <div class="mt-4 d-flex justify-content-end">
            <button type="submit" class="btn btn-primary me-2">Xác nhận</button>
            <a href="/admin/users/list" type="submit" class="btn btn-warning">Hủy</a>
        </div>
    </form>
</div>

<%@include file="/views/shared/footer.jsp" %>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
