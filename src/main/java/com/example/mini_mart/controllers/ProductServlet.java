package com.example.mini_mart.controllers;


import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;
import com.example.mini_mart.services.product.IProductService;
import com.example.mini_mart.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "ProductServlet", urlPatterns = "/home/products/*")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
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

    private void showFormCreateProduct(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher("/views/product/create.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
    }
}
