package com.example.mini_mart.controllers.home;

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

@WebServlet(name = "ProductController", urlPatterns = "/home/*")
public class ProductController extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/home/shop":
                getPageNumber(req,resp);
                break;
            case "/home/shop/search":
                searchProductsByApproximatePrice(req,resp);
                break;
            case "/home/shop/search-by-category":
                searchProductByCategory(req,resp);
                break;
            case "/home/shop/detail-product":
                showProduct(req,resp);
                break;
            default:
                req.getRequestDispatcher("/views/store/404error.jsp").forward(req,resp);
                break;
        }
    }

    private void searchProductByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        List<Product> products = productService.selectProductByCategoryId(category_id);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/shop.jsp").forward(req,resp);
    }


    private void searchProductsByApproximatePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = Integer.parseInt(req.getParameter("rangeInput"));
        List<Product> products = productService.searchProductsByApproximatePrice(price);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/store/shop.jsp").forward(req,resp);
    }

    private void showAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAll();
        req.setAttribute("products",products);

        req.getRequestDispatcher("/views/store/shop.jsp").forward(req,resp);
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("product_id")) ;
        Product product = productService.selectProductById(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/views/store/detail-product.jsp").forward(req, resp);
    }

    private void getPageNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        int pageSize = 6;
        List<Product> productList = productService.getProducts(page, pageSize);
        int totalProducts = productService.getTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
        req.setAttribute("productList", productList);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/store/shop.jsp").forward(req, resp);
    }
}
