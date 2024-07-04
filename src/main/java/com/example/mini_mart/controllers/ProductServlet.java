package com.example.mini_mart.controllers;


import com.example.mini_mart.models.Category;
import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;
import com.example.mini_mart.services.category.CategoryService;
import com.example.mini_mart.services.category.ICategoryService;
import com.example.mini_mart.services.product.IProductService;
import com.example.mini_mart.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ProductServlet", urlPatterns = "/home/products/*")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICategoryService categoryService = new CategoryService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showList(req, resp);
                break;
            case "/create":
                showFormCreateProduct(req, resp);
                break;
            case "/delete":
//                deleteProduct(req, resp);
                break;
            case "/update":
//                showFormUpdateProduct(req, resp);
                break;
            case "/search":
//                searchProduct(req, resp);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                insertProduct(req, resp);
                break;
        }
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String avatar = req.getParameter("avatar");
        double costPrice = Double.parseDouble(req.getParameter("cost-price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category-id"));
        Product product = new Product(sku, name, price, description, avatar, costPrice, quantity, categoryId);

        productService.insert(product);
        req.setAttribute("product", product);
        resp.sendRedirect("/home/products/list");
    }

    private void showFormCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/product/create.jsp").forward(req, resp);
    }



    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
    }
}
