<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/3/2024
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp"%>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp"%>
<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6 my-5">Thanh toán</h1>
</div>
<!-- Single Page Header End -->


<!-- Checkout Page Start -->
<div class="container-fluid py-5 w-50 m-auto">
    <div class="container py-5">
        <h1 class="mb-4 text-center">Thông tin thanh toán</h1>
        <form action="#">
            <div class="row g-5">
                <div class="col-12">
                    <div class="row">
                        <div class="col-md-12 col-lg-6">
                            <div class="form-item w-100">
                                <label class="form-label my-3">Họ <sup>*</sup></label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-6">
                            <div class="form-item w-100">
                                <label class="form-label my-3">Tên <sup>*</sup></label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3">Địa chỉ <sup>*</sup></label>
                        <input type="text" class="form-control" placeholder="Số nhà và tên đường" required>
                    </div>

                    <div class="form-item">
                        <label class="form-label my-3">Số điện thoại <sup>*</sup></label>
                        <input type="tel" class="form-control" required>
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3">Địa chỉ email <sup>*</sup></label>
                        <input type="email" class="form-control" required>
                    </div>
                    <hr>

                </div>

                <div class="row g-4 text-center w-25 m-auto pt-4">
                    <button type="button" class="btn border-secondary py-3 px-4 text-uppercase w-100 text-primary">Đặt hàng
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- Checkout Page End -->

<%@include file="/giao-dien/cua-hang/shared/footer.jsp"%>
</body>
</html>
