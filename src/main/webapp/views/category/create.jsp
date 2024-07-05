<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/5/2024
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Nhập thông tin phân loại</h4>
<form action="/admin/categories/create" method="post">
    <div class="mb-3 form-floating">
        <input type="text" class="form-control" id="name" placeholder="tên" name="name">
        <label for="name" class="form-label">Tên</label>
    </div>
    <div class="mb-3 form-floating">
        <input type="text" class="form-control" id="description" placeholder="Mô tả" name="description">
        <label for="description" class="form-label">Mô tả</label>
    </div>
    <div class="input-group mb-3">
        <label class="input-group-text" for="imageInput">Upload</label>
        <input type="file" class="form-control" id="imageInput">
    </div>
    <div id="previewContainer">
        <input type="text" class="form-control d-none" id="avatar" placeholder="Ảnh" name="avatar">
        <img id="imagePreview" src="" alt="Image Preview" style="display: none;">
    </div>
    <div class="d-grid gap-2 mt-5">
        <button type="submit" class="btn btn-primary btn-lg" >Lưu</button>
    </div>
</form>
<%@include file="/views/shared/footer.jsp" %>
</body>
</html>
