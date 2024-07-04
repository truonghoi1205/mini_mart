package com.example.mini_mart.controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "ProductServlet", urlPatterns = "/home/products/*")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showList(req, resp);
                break;
            case "/create":
//                showFormCreateProduct(req, resp);
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

    private void showList(HttpServletRequest req, HttpServletResponse resp) {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
