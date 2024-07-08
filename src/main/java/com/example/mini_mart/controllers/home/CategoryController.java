package com.example.mini_mart.controllers.home;

import com.example.mini_mart.models.Category;
import com.example.mini_mart.models.Product;
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

@WebServlet(name = "CategoryController", urlPatterns = "/home/categories/*")
public class CategoryController extends HttpServlet {
    private static ICategoryService categoryService = new CategoryService();
    private static IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        switch (url) {
            case "/home/categories/show":
                showCategory(req, resp);
                break;

            default:
                req.getRequestDispatcher("/views/store/404error.jsp").forward(req, resp);
                break;
        }
    }

    private void showCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(categoryId);
        List<Product> products = new ProductService().getProductByCategoryId(categoryId);
        req.setAttribute("category", category);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/store/categories/show.jsp").forward(req, resp);
    }
    private void searchCategories(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Category> categories = categoryService.findByName(keyword);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/store/categories/list.jsp").forward(req, resp);
    }
}
