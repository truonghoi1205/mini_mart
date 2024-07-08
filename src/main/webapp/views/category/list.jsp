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
                <a class="btn btn-sm btn-primary px-4 text-light" type="submit" href="/admin/categories/create">Thêm mới</a>
            </div>
        </div>
        <div class="p-3 bg-white mb-2 shadow-sm">
            <div class="mb-3">
                <div class="row justify-content-end">

                    <div class="col-3">
                        <form action="/admin/categories/search" class="d-flex">
                            <input class="form-control form-control-sm" type="text" name="name"
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
                        <th >#</th>
                        <th>Ảnh</th>
                        <th>Tên</th>
                        <th >Mô tả</th>
                        <th style="width: 200px"></th>
                    </tr>
                    <c:forEach var="category" items="${categories}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>
                                <img src="${category.avatar}" class="img-fluid" style="width: 40px;">
                            </td>
                            <td>${category.name}</td>

                            <td>${category.description}</td>
                            <td>
                                <a href="/admin/categories/update?id=${category.id}"
                                   class="btn btn-sm btn-outline-warning me-3">Sửa</a>
                                <button
                                   class="btn btn-sm btn-outline-danger me-3" data-bs-toggle="modal"
                                   data-bs-target="#modalDelete${category.id}">Xoá</button>
                                <div class="modal fade" tabindex="-1" id="modalDelete${category.id}">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Xóa Sản Phẩm</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close" ></button>
                                            </div>
                                            <div class="modal-body">
                                                <p class="my-auto text-center">Bạn có chắc chắn muốn xóa phân loại này?</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal"
                                                        name="cancel">Hủy
                                                </button>
                                                <a href="/admin/categories/delete?id=${category.id}" class="btn btn-danger">Xác nhận</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <%@include file="/views/shared/footer.jsp" %>
            <%@include file="/views/shared/lib-script.jsp" %>
</body>
</html>
