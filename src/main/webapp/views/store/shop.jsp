<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/3/2024
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/giao-dien/cua-hang/shared/header.jsp" %>
<!-- Modal Search Start -->
<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Search by keyword</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body d-flex align-items-center">
                <div class="input-group w-75 mx-auto d-flex">
                    <input type="search" class="form-control p-3" placeholder="keywords"
                           aria-describedby="search-icon-1">
                    <span id="search-icon-12" class="input-group-text p-3"><i class="fa fa-search"></i></span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal Search End -->


<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6 my-5">Cửa Hàng</h1>
</div>
<!-- Single Page Header End -->


<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
    <div class="container py-5">
        <h1 class="mb-4">Cửa Hàng Trái Cây Tươi Sạch</h1>
        <div class="row g-4">
            <div class="col-lg-12">
                <div class="row g-4">
                    <div class="col-xl-3">
                        <div class="input-group w-100 mx-auto d-flex">
                            <input type="search" class="form-control p-3" placeholder="Từ khóa..."
                                   aria-describedby="search-icon-1">
                            <a href="#" id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></a>
                        </div>
                    </div>
                    <div class="col-6"></div>
                    <div class="col-xl-3">
                        <div class="bg-light ps-3 py-3 rounded d-flex justify-content-between mb-4">
                            <label for="fruits">Sắp xếp:</label>
                            <select id="fruits" name="fruitlist" class="border-0 form-select-sm bg-light me-3">
                                <option>Mặc định</option>
                                <option>Giá bán</option>
                                <option>Phổ biến</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row g-4">
                    <div class="col-lg-3">
                        <div class="row g-4">
                            <div class="col-lg-12">
                                <div class="mb-3">
                                    <h4>Phân loại</h4>
                                    <ul class="list-unstyled fruite-categorie">
                                        <li>
                                            <div class="d-flex justify-content-between fruite-name">
                                                <a href="/home/shop" class="icon-link icon-link-hover"
                                                   style="--bs-link-hover-color-rgb: 25, 135, 84;"><i
                                                        class="bi bi-bookmark-fill"></i> Tất cả
                                                </a>
                                            </div>
                                        </li>
                                        <c:forEach var="category" items="${categories}">
                                            <li>
                                                <div class="d-flex justify-content-between fruite-name">
                                                    <a class="icon-link icon-link-hover"
                                                       style="--bs-link-hover-color-rgb: 25, 135, 84;"
                                                       href="/home/shop/search-by-category?category_id=${category.id}"><i
                                                            class="bi bi-bookmark-fill"></i> ${category.name}
                                                    </a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="mb-3">
                                    <h4 class="mb-2">Giá bán</h4>
                                    <input type="range" class="form-range w-100" id="rangeInput" name="rangeInput"
                                           min="0" max="1500000" value="0" oninput="amount.value=rangeInput.value">
                                    <output id="amount" name="price" min-value="0" max-value="500"
                                            for="rangeInput">0
                                    </output>
                                    <span>đ</span>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="position-relative">
                                    <img src="/img/banner-fruits.jpg" class="img-fluid w-100 rounded" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="row g-4">
                            <c:forEach var="product" items="${products}">
                                <div class="col-lg-4 col-md-6 col-sm-12">
                                    <div class="rounded position-relative fruite-item">
                                        <a href="/home/shop/detail-product?product_id=${product.id}">
                                            <div class="fruite-img">
                                                <img src="${product.avatar}" class="img-fluid w-100 rounded-top" alt="">
                                            </div>
                                            <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                <h4>${product.name}</h4>
                                                <p class="text-dark"> ${fn:substring(product.description,0, 55)}... </p>
                                                <div class="d-flex justify-content-between flex-lg-wrap">
                                                    <p class="text-dark fs-5 fw-bold mb-0"><fmt:formatNumber value="${product.price}" type="number"/>đ / kg</p>
                                                    <a href="/home/cart/add?product_id=${product.id}"
                                                       class="btn border border-secondary rounded-pill px-3 text-primary"><i
                                                            class="fa fa-shopping-bag me-2 text-primary"></i>Mua</a>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="col-12">
                                <div class="pagination d-flex justify-content-center mt-5">
                                    <c:if test="${currentPage > 1}">
                                        <a href="/home/shop?page=${currentPage - 1}" class="rounded">&laquo;</a>
                                    </c:if>
                                    <c:forEach var="i" begin="1" end="${totalPages}">
                                        <a href="/home/shop?page=${i}"
                                           class="${i == currentPage ? 'active' : ''} rounded">${i}</a>
                                    </c:forEach>
                                    <c:if test="${currentPage < totalPages}">
                                        <a href="/home/shop?page=${currentPage + 1}" class="rounded">&raquo;</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fruits Shop End-->
<%@include file="/giao-dien/cua-hang/shared/footer.jsp" %>
</body>
</html>
