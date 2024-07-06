<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/5/2024
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container">
        <form class="w-50 mx-auto shadow rounded-3 p-5 mt-5" action="/admin/categories/create" method="post">
            <h2 class="text-center mb-3">Thêm phân loại mới</h2>
            <div class="mb-3">
                <label for="name" class="form-label">Tên</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Mô tả</label>
                <input type="text" class="form-control" id="description" name="description" required>
            </div>
            <div class="row">

                <label for="description" class="form-label">Hình Ảnh</label>
                <div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="imageInput">Upload</label>
                        <input type="file" class="form-control" id="imageInput" required>
                    </div>
                    <div id="previewContainer">
                        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar"
                               value="${category.avatar}">
                        <img id="imagePreview" src="${category.avatar}" class="img-fluid mx-auto">
                    </div>
                </div>
            </div>

            <div class="mt-4 d-flex justify-content-end">
                <button type="submit" class="btn btn-primary text-white me-2">Thêm</button>
                <a href="/admin/products/list" type="submit" class="btn btn-danger">Hủy</a>
            </div>
        </form>

</div>
<%@include file="/views/shared/footer.jsp" %>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
