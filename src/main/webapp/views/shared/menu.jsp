<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/4/2024
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<!-- Spinner Start -->--%>
<%--<div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">--%>
<%--    <div class="spinner-grow text-primary" role="status"></div>--%>
<%--</div>--%>
<%--<!-- Spinner End -->--%>

<!-- Navbar start -->

    <div class="container-fluid px-0 bg-light">
        <div class="container">
            <nav class="navbar navbar-light navbar-expand-xl">
                <a href="/home" class="navbar-brand"><h1 class="text-primary display-6">HnQFruits</h1></a>
                <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars text-primary"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav mx-auto">

                        <a href="/admin/categories/list" class="nav-item nav-link mx-3"><i class="bi bi-bag-check-fill fs-5 me-2"></i>Phân Loại</a>
                        <a href="/admin/products/list" class="nav-item nav-link mx-3"><i class="bi bi-stack fs-5 me-2"></i></i>Sản Phẩm</a>
                        <a href="/admin/orders/list" class="nav-item nav-link mx-3"><i class="bi bi-cart-check-fill fs-5 me-2"></i>Đơn Hàng</a>
                        <a href="/admin/users/list" class="nav-item nav-link mx-3"><i class="bi bi-people-fill fs-5 me-2"></i>Nhân Sự</a>
                    </div>
                    <div class="d-flex m-3 me-0">
                        <a href="/logout" class="my-auto">
                            <i class="bi bi-box-arrow-in-right display-6"></i>
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
<!-- Navbar End -->

