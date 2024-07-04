<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/3/2024
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp"%>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp"%>
<!-- 404 Start -->
<div class="pt-5">
    <div class="container-fluid py-5 my-5">
        <div class="container py-5 text-center">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <i class="bi bi-exclamation-triangle display-1 text-secondary"></i>
                    <h1 class="display-1">404</h1>
                    <h1 class="mb-4">Không tìm thấy trang</h1>
                    <p class="mb-4">Chúng tôi xin lỗi, trang bạn đang tìm không tồn tại trên website của chúng tôi! <br> Bạn có thể quay về trang chủ hoặc thử sử dụng tính năng tìm kiếm?</p>
                    <a class="btn border-secondary rounded-pill py-3 px-5" href="index.html">Trở về trang chủ</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 404 End -->
<%@include file="/giao-dien/cua-hang/shared/footer.jsp"%>
</body>
</html>
