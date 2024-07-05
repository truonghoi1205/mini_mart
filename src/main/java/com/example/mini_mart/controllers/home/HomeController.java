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

@WebServlet(name="HomeController",urlPatterns = {"/home","/home/thank-you"})
public class HomeController extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/home":
                showHome(req, resp);
                break;
            case "/home/thank-you":
                showThankYou(req, resp);
                break;
            default:
                resp.sendError(404);
                break;
        }
    }

    private void showThankYou(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/store/complete.jsp").forward(req, resp);
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/home.jsp").forward(req, resp);
    }
}
