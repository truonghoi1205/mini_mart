package com.example.mini_mart.controllers.home;

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
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/home/*")
public class ProductController extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/home":
                showProduct(req,resp);
                break;
            case "/home/shop":
                showAllProduct(req,resp);
                break;
            default:
                req.getRequestDispatcher("/views/store/404error.jsp").forward(req,resp);
                break;
        }
    }
    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/shop.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id =Integer.parseInt(req.getParameter("id")) ;
//        Product product = productService.selectProduct(id);
//        req.setAttribute("product",product);
//        req.getRequestDispatcher("/views/store/products/show.jsp").forward(req, resp);
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/home.jsp").forward(req,resp);
    }
}
