
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="mb-5">
    <div class="row g-5 m-auto container">
        <div class="d-flex justify-content-between p-3 shadow-sm bg-white mb-3 align-items-center">
            <h6 class="text-decoration-none text-secondary mb-0 ">Tất cả sản phẩm</h6>
            <div>
                <a href="/admin/products/create" type="button" class="btn btn-sm btn-outline-primary">Thêm mới</a>
            </div>
            <div class="col-3">
                <form action="/admin/products/search" class="d-flex">
                    <input class="form-control form-control-sm" type="text" name="name"
                           placeholder="Tìm kiếm theo tên"
                           aria-label=".form-control-sm example">
                    <button class="btn btn-outline-primary ms-3">Tìm</button>
                </form>
            </div>
        </div>

        <table class="table table-bordered mt-3">
            <thead>
            <tr>
                <th>Ảnh</th>
                <th>Mã Sản Phẩm</th>
                <th>Tên</th>
                <th>Giá Gốc</th>
                <th>Giá</th>
                <th>Mô Tả</th>
                <th>Số Lượng</th>
                <th>Phân Loại</th>
                <th width="150px">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td class="align-middle"><img src="${product.avatar}" class="img-fluid" style="width: 50px;"></td>
                    <td class="align-middle">${product.sku}</td>
                    <td class="align-middle">${product.name}</td>
                    <td class="align-middle"><fmt:formatNumber value="${product.costPrice}" type="number"/></td>
                    <td class="align-middle"><fmt:formatNumber value="${product.price}" type="number"/></td>
                    <td class="align-middle text-break" width="30%">${product.description}</td>
                    <td class="align-middle">${product.quantity}</td>
                    <td class="align-middle">${product.categoryName}</td>
                    <td class="align-middle"  width="170px">
                        <div>
                            <a href="/admin/products/update?id=${product.id}" type="button"
                               class="btn btn-sm btn-outline-warning me-1">Chỉnh sửa</a>
                            <a href="/admin/products/delete?id=${product.id}" type="button"
                               class="btn btn-sm btn-outline-danger" data-bs-toggle="modal"
                               data-bs-target="#modalDelete${product.id}">Xóa</a>
                        </div>
                        <div class="modal fade" tabindex="-1" id="modalDelete${product.id}">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Xóa Sản Phẩm</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p class="my-auto text-center">Bạn có chắc chắn muốn xóa sản phẩm này!!!</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"
                                                name="cancel">Hủy
                                        </button>
                                        <form action="/admin/products/delete" method="get">
                                            <button type="submit" class="btn btn-danger">Xác nhận</button>
                                            <input type="hidden" name="id" value="${product.id}">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>>
</div>

<%@include file="/views/shared/lib-script.jsp" %>
<%@include file="/views/shared/footer.jsp" %>
</body>
</html>
