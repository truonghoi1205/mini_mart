<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/4/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container py-4">

    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Đăng Nhập</h4>
                <% if (request.getAttribute("errorMessage") != null) { %>
                <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
                <% } %>
                <form action="/login" method="post">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="email" placeholder="Email" name="email">
                        <label for="email" class="form-label">Email</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password">
                        <label for="password" class="form-label">Mật khẩu</label>
                    </div>
                    <div class="d-grid gap-2 mt-5">
                        <button type="submit" class="btn btn-primary btn-lg">Đăng Nhập</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
