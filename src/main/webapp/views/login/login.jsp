<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/4/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>

<div class="container-fluid px-0 bg-light">
    <div class="container">
        <nav class="navbar navbar-light navbar-expand-xl">
            <div>
                <a href="/home" class="navbar-brand"><h1 class="text-primary display-6">HnQFruits</h1></a>
            </div>

        </nav>
    </div>
</div>

<div class="container py-4 mt-5">
    <div class="text-center container pb-2">
        <p>Trang này chỉ dành cho quản trị viên! nếu bạn không phải quản trị viên vui lòng quay lại <a href="/home">Trang
            Chủ</a> !!!</p>
    </div>
    <div class="row justify-content-center">
        <div class="w-50">
            <div class="shadow rounded p-3 bg-white mt-4">
                <div class="m-4">

                    <form action="/login" method="post" class="mt-4">
                        <h4 class="mb-3 ">Đăng Nhập<i class="bi bi-people-fill ms-2"></i></h4>
                        <div class="mb-3 form-floating">
                            <input type="text" class="form-control" id="email" placeholder="Email" name="email">
                            <label for="email" class="form-label">Email</label>
                        </div>
                        <div class="mb-3 form-floating">
                            <input type="password" class="form-control" id="password" placeholder="Mật khẩu"
                                   name="password">
                            <label for="password" class="form-label">Mật khẩu</label>
                        </div>
                        <div class="text-center">
                            <% if (request.getAttribute("errorMessage") != null) { %>
                            <p style="color: red;"><%= request.getAttribute("errorMessage") %>
                            </p>
                            <% } %>
                        </div>

                        <div class="d-grid gap-2 mt-4 w-25 mx-auto">
                            <button type="submit" class="btn btn-primary">Đăng Nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="/views/shared/footer.jsp" %>
<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
