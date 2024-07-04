<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/4/2024
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container">
    <form action="/home/products/create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên sản phẩm</label>
            <input type="email" class="form-control" id="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="password" class="form-control" id="price">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả sản phẩm</label>
            <input type="password" class="form-control" id="description">
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Hình ảnh</label>
            <input type="password" class="form-control" id="image">
        </div>
        <div class="mb-3">
            <label for="cost-price" class="form-label">Giá gốc</label>
            <input type="password" class="form-control" id="cost-price">
        </div>

        <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
    </form>
</div>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
