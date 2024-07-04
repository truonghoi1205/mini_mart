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
            <a href="/home/products/create" type="button" class="btn btn-sm btn-outline-primary">Thêm mới</a>
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
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.avatar}</td>
                    <td>${product.sku}</td>
                    <td>${product.name}</td>
                    <td>${product.costPrice}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.quantity}</td>
                    <td>${product.categoryName}</td>
                    <td>
                        <a href="/home/products/update?id=${product.id}" type="button"
                           class="btn btn-sm btn-outline-warning me-3">Chỉnh sửa</a>
                        <a href="/home/products/delete?id=${product.id}" type="button"
                           class="btn btn-sm btn-outline-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

</div>


<%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
