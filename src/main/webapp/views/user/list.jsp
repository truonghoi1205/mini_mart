<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>

<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="container mt-5 ">
    <div>
        <div class="d-flex justify-content-between p-3 shadow-sm bg-white mb-3 align-items-center">
            <h6 class="text-decoration-none text-secondary mb-0 ">Tất cả phân loại</h6>
            <div>
                <a class="btn btn-sm btn-primary px-4" type="submit" href="/admin/users/create">Thêm sản phẩm
                    mới</a>
            </div>
        </div>
        <div class="p-3 bg-white mb-2 shadow-sm">
            <div class="mb-3">
                <div class="row justify-content-end">

                    <div class="col-3">
                        <form action="/admin/users/search" class="d-flex">
                            <input class="form-control form-control-sm" type="text" name="keyword"
                                   placeholder="Tìm kiếm theo tên"
                                   aria-label=".form-control-sm example">
                            <button class="btn btn-outline-primary ms-3">Tìm</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="p-3 bg-white shadow-sm">
                <table class="table table-bordered align-middle">
                    <tr>
                        <th>#</th>
                        <th>Tên</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th style="width: 300px"></th>
                    </tr>
                    <c:forEach var="user" items="${users}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>
                                <span class="password">●●●●●●●●</span>
                                <button type="button" class="btn  toggle-password" data-password="${user.password}"><i
                                        class="bi bi-eye"></i></button>
                            </td>
                            <td>
                                <a href="/admin/categories/update?id=${user.id}"
                                   class="btn btn-sm btn-outline-warning me-3">Sửa</a>
                                <a href="/admin/categories/delete?id=${user.id}"
                                   class="btn btn-sm btn-outline-danger me-3">Xoá</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <%@include file="/views/shared/footer.jsp" %>
            <%@include file="/views/shared/lib-script.jsp" %>

            <script>
                document.addEventListener('DOMContentLoaded', (event) => {
                    document.querySelectorAll('.toggle-password').forEach(button => {
                        button.addEventListener('click', function () {
                            const passwordSpan = this.previousElementSibling;
                            if (passwordSpan.innerHTML === '●●●●●●●●') {
                                passwordSpan.innerHTML = this.getAttribute('data-password');
                                this.innerHTML = '<i class="bi bi-eye-slash"></i>';
                            } else {
                                passwordSpan.innerHTML = '●●●●●●●●';
                                this.innerHTML = '<i class="bi bi-eye"></i>';
                            }
                        });
                    });
                });
            </script>
</body>
</html>
