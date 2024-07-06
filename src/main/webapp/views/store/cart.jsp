<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/3/2024
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6 my-5">Giỏ Hàng</h1>
</div>
<!-- Single Page Header End -->


<!-- Cart Page Start -->
<div class="container-fluid py-5">
    <c:if test="${cart == null || cart.items.isEmpty()}">
        <div class="text-center py-3 col-12 rounded bg-white">
            <h5 class="mb-3">Chưa có sản phẩm nào trong giỏ hàng!</h5>
            <a href="/home/shop" class="btn btn-outline-primary">Quay lại trang sản phẩm</a>
        </div>
    </c:if>
    <c:if test="${cart != null && !cart.items.isEmpty()}">
        <div class="container py-5">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Sản phẩm</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Xử lý</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <th scope="row">
                                <div class="d-flex align-items-center">
                                    <img src="${item.product.avatar}" class="img-fluid me-5 rounded-circle"
                                         style="width: 80px; height: 80px;" alt="">
                                </div>
                            </th>
                            <td>
                                <p class="mb-0 mt-4">${item.product.name}</p>
                            </td>
                            <td>
                                <p class="mb-0 mt-4"> ${item.product.price}đ</p>
                            </td>
                            <td>
                                <form action="/home/cart/update">
                                    <input type="hidden" name="product_id" value="${item.product.id}">
                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-minus rounded-circle border">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input type="text" id="numbers" class="form-control form-control-sm text-center border-0"
                                               value="${item.quantity}" name="quantity">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-plus rounded-circle border">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </td>
                            <td>
                                <p class="mb-0 mt-4">${cart.getTotalPrice()}đ</p>
                            </td>
                            <td>
                                <a href="/home/cart/remove?product_id=${item.product.id}"
                                   class="btn btn-md rounded-circle bg-light border mt-4">
                                    <i class="fa fa-times text-danger"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row g-4 mx-auto mt-5 w-50">
                <div>
                    <div class="bg-light rounded">
                        <div class="p-4">
                            <h1 class="display-6 mb-4">Hóa đơn</h1>
                            <div class="d-flex justify-content-between mb-4">
                                <h5 class="mb-0 me-4">Tạm tính:</h5>
                                <p class="mb-0">${cart.getTotalPrice()}đ</p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h5 class="mb-0 me-4">Phí vận chuyển</h5>
                                <div class="">
                                    <p class="mb-0">Cố định: 35.000đ</p>
                                </div>
                            </div>
                            <p class="mb-0 text-end">Tới: 295 Nguyễn Tất Thành, Đà Nẵng</p>
                        </div>
                        <div class="py-4 mb-4 border-top border-bottom d-flex justify-content-between">
                            <h5 class="mb-0 ps-4 me-4">Tổng tiền</h5>
                            <p class="mb-0 pe-4">${cart.getTotalPrice()+35000}đ</p>
                        </div>
                        <a href="/home/cart/checkout"
                           class="btn border-secondary rounded-pill px-4 py-3 text-primary mb-4 ms-4"
                           type="button">THANH TOÁN
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<!-- Cart Page End -->

<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>
