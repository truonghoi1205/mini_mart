package com.example.mini_mart.controllers;

import com.example.mini_mart.models.Category;
import com.example.mini_mart.models.User;
import com.example.mini_mart.services.category.CategoryService;
import com.example.mini_mart.services.category.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/admin/categories/*")
public class CategoryServlet extends HttpServlet {
    ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/list":
                showListCategory(req, resp);
                break;
            case "/create":
                showFormCreateCategory(req, resp);
                break;
            case "/delete":
                deleteCategory(req, resp);
                break;
            case "/update":
                showFormUpdateCategory(req, resp);
                break;
            case "/search":
                searchCategory(req,resp);
                break;
        }
    }

    private void searchCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Category> categories = categoryService.findByName(name);
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req,resp);
    }

    private void showFormUpdateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/views/category/update.jsp").forward(req, resp);

    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryService.deleteCategory(id);
        resp.sendRedirect("/admin/categories/list");

    }

    private void showFormCreateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/category/create.jsp").forward(req, resp);
    }

    private void showListCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/create":
                createCategory(req, resp);
                break;
            case "/update":
                updateCategory(req, resp);
                break;
        }
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String avatar = req.getParameter("avatar");
        String description = req.getParameter("description");
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setAvatar(avatar);
        category.setDescription(description);
        categoryService.updateCategory(category);
        resp.sendRedirect("/admin/categories/list");
    }

    private void createCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String avatar = req.getParameter("avatar");
        String description = req.getParameter("description");
        Category category = new Category();
        category.setName(name);
        category.setAvatar(avatar);
        category.setDescription(description);
        categoryService.createCate(category);
        resp.sendRedirect("/admin/categories/list");
    }
}
