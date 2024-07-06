<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/5/2024
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>

<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6 my-5">Chi tiết sản phẩm</h1>
</div>
<!-- Single Page Header End -->


<!-- Single Product Start -->
<div class="container py-5 mt-5">
    <div class="row">
        <div class="col-lg-6">
            <form action="/home/cart/add">
                <div class="row">
                    <div class="col-6">
                        <div class="border rounded ">
                            <img src="${product.avatar}" class="img-fluid rounded " alt="Image">
                        </div>
                    </div>
                    <div class="col-6">
                        <input type="hidden" name="product_id" value="${product.id}">
                        <h4 class="fw-bold mb-3">${product.name}</h4>
                        <p class="mb-3">Danh mục: ${product.category.name}</p>
                        <h5 class="fw-bold mb-3"><fmt:formatNumber value="${product.price}" type="number"/>đ</h5>
                        <div class="input-group quantity mb-5" style="width: 100px;">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-sm btn-minus rounded-circle border">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <input type="text" id="numbers" class="form-control form-control-sm text-center border-0"
                                   value="1" name="quantity">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-sm btn-plus rounded-circle border">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <button class="btn border border-secondary rounded-pill px-4 py-2 mb-4 text-primary"><i
                                class="fa fa-shopping-bag me-2 text-primary"></i>Thêm vào giỏ hàng
                        </button>

                    </div>
                </div>
            </form>
        </div>

        <div class="col-lg-6">
            <nav>
                <div class="nav nav-tabs mb-3">
                    <button class="nav-link active border-white border-bottom-0" type="button" role="tab"
                            id="nav-about-tab" data-bs-toggle="tab" data-bs-target="#nav-about"
                            aria-controls="nav-about" aria-selected="true">Mô tả sản phẩm
                    </button>
                </div>
            </nav>
            <div class="tab-content mb-5">
                <div class="tab-pane active" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
                    <p>${product.description}</p>
                </div>
            </div>
        </div>
        <!-- table detail product start -->
        <div class="px-2 pt-5">
            <div class="row g-4">
                <div class="col-12">
                    <div class="row bg-light align-items-center text-center justify-content-center py-2">
                        <div class="col-6">
                            <p class="mb-0">Đơn vị đo lường</p>
                        </div>
                        <div class="col-6">
                            <p class="mb-0">kg</p>
                        </div>
                    </div>
                    <div class="row text-center align-items-center justify-content-center py-2">
                        <div class="col-6">
                            <p class="mb-0">Xuất xứ</p>
                        </div>
                        <div class="col-6">
                            <p class="mb-0">Trang trại HnQ</p>
                        </div>
                    </div>
                    <div class="row bg-light text-center align-items-center justify-content-center py-2">
                        <div class="col-6">
                            <p class="mb-0">Chất lượng</p>
                        </div>
                        <div class="col-6">
                            <p class="mb-0">Organic</p>
                        </div>
                    </div>
                    <div class="row text-center align-items-center justify-content-center py-2">
                        <div class="col-6">
                            <p class="mb-0">Đánh giá</p>
                        </div>
                        <div class="col-6">
                            <p class="mb-0">Tốt cho sức khỏe</p>
                        </div>
                    </div>
                    <div class="row bg-light text-center align-items-center justify-content-center py-2">
                        <div class="col-6">
                            <p class="mb-0">Tối thiểu</p>
                        </div>
                        <div class="col-6">
                            <p class="mb-0">0.25kg</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- table detail product end -->
    </div>
</div>
<!-- Single Product End -->

<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>
