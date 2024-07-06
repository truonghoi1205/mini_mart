<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container">
    <form class="w-50 mx-auto mt-4 shadow rounded-3 p-5 " action="/admin/categories/update" method="post">
        <input type="hidden" value="${category.id}" name="id">
        <h2 class="text-center mb-4">Chỉnh sửa phân loại</h2>
        <div class="mb-3">
            <label for="name" class="form-label">Tên phân loại</label>
            <input type="text" class="form-control" id="name" name="name" value="${category.name}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả phân loại</label>
            <input type="text" class="form-control" id="description" name="description" value="${category.description}" required>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="description" class="form-label">Hình Ảnh</label>
                <div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imageInput">Upload</label>
                        <input type="file" class="form-control" id="imageInput" required>
                    </div>
                    <div id="previewContainer">
                        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar"
                               value="${product.avatar}">
                        <img id="imagePreview" src="${product.avatar}" class="img-fluid">
                    </div>
                </div>
            </div>
        <div class="mt-4 d-flex justify-content-end">
            <button type="submit" class="btn btn-primary me-2">Xác nhận</button>
            <a href="/admin/categories/list" type="submit" class="btn btn-warning">Hủy</a>
        </div>
        </div>
    </form>
</div>
<%@include file="/views/shared/footer.jsp" %>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
