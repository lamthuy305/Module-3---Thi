<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


<div class="container">
    <a href="/products" class="btn btn-primary">Danh sách sản phẩm</a>
    <h1>Xóa sản phẩm</h1>

    <p style="color: green"><c:if test="${msg != null}">${msg}</c:if></p>
    <form action="/products?action=delete&id=${product.id}" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Tên sản phẩm</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="text" class="form-control" id="price" name="price" value="${product.price}" disabled>
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="quantity" name="quantity" value="${product.quantity}" disabled>
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Màu sắc</label>
            <input type="text" class="form-control" id="color" name="color" value="${product.color}" disabled>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="description" name="description" value="${product.description}" disabled>
        </div>

        <div class="mb-3">
            <label for="category_id" class="form-label">Category ID</label>
            <input type="text" class="form-control" id="category_id" name="description" value="${product.category_id}" disabled>
        </div>

        <button type="submit" class="btn btn-primary">Xóa</button>
    </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
