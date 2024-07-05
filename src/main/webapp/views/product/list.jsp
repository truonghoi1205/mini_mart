<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/4/2024
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/giao-dien/cua-hang/shared/head.jsp" %>
<body>
<%@include file="/views/shared/menu.jsp" %>
<div class="mb-5">
    <div class="row g-5 m-auto container">
        <div>
            <a href="/admin/products/create" type="button" class="btn btn-sm btn-outline-primary">Thêm mới</a>
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
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="productDTO" items="${products}">
                <tr>
                    <td><img src="${product.avatar}" class="img-fluid" style="width: 40px;"></td>
                    <td>${productDTO.sku}</td>
                    <td>${productDTO.name}</td>
                    <td>${productDTO.costPrice}</td>
                    <td>${productDTO.price}</td>
                    <td>${productDTO.description}</td>
                    <td>${productDTO.quantity}</td>
                    <td>${productDTO.categoryName}</td>
                    <td>
                        <a href="/admin/products/update?id=${productDTO.id}" type="button"
                           class="btn btn-sm btn-outline-warning me-3">Chỉnh sửa</a>
                        <a href="/admin/products/delete?id=${productDTO.id}" type="button"
                           class="btn btn-sm btn-outline-danger" data-bs-toggle="modal"
                           data-bs-target="#modalDelete${productDTO.id}">Xóa</a>
                        <div class="modal fade" tabindex="-1" id="modalDelete${productDTO.id}">
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
                                            <input type="hidden" name="id" value="${productDTO.id}">
                                        </form>
                                    </div>
                                </div>
                            </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="/views/shared/lib-script.jsp" %>
<%@include file="/views/shared/footer.jsp" %>
</body>
</html>
