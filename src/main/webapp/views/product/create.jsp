<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form class="w-50 mx-auto mt-4 shadow rounded-3 p-5 " action="/home/products/create" method="post">
        <div class="mb-3">
            <label for="sku" class="form-label">Mã sản phẩm</label>
            <input type="text" class="form-control" id="sku" name="sku">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả sản phẩm</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>

        <div class="mb-3">
            <label for="cost-price" class="form-label">Giá gốc</label>
            <input type="text" class="form-control" id="cost-price" name="cost-price">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="quantity" name="quantity">
        </div>
        <div class="mb-3">
            <label for="category-id" class="form-label">Phân loại</label>
            <select class="form-select" aria-label="Default select example" name="category-id" id="category-id">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group mb-3 mt-4">
            <label class="input-group-text" for="imageInput">Upload hình ảnh</label>
            <input type="file" class="form-control" id="imageInput">
        </div>
        <div id="previewContainer">
            <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar"
                   value="${product.avatar}">
            <img id="imagePreview" src="${product.avatar}" class="img-fluid">
        </div>
        <div class="mt-4 d-flex justify-content-end">
            <button type="submit" class="btn btn-primary me-2">Thêm sản phẩm</button>
            <a href="/home/products/list" type="submit" class="btn btn-warning">Hủy</a>
        </div>

    </form>
</div>
<%@include file="/views/share/footer.jsp" %>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
