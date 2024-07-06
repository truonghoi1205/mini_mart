package com.example.mini_mart.controllers;

import com.example.mini_mart.models.User;
import com.example.mini_mart.services.user.IUserService;
import com.example.mini_mart.services.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/admin/users/*")
public class UserServlet extends HttpServlet {
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/list":
                showListUser(req, resp);
                break;
            case "/create":
                showFormCreateUser(req, resp);
                break;
            case "/delete":
                deleteUser(req, resp);
                break;
            case "/update":
                showFormUpdateUser(req, resp);
                break;
            case "/search":
                searchUser(req, resp);
                break;
        }

    }

    private void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<User> users = userService.findByName(name);
        req.setAttribute("users",users);
        req.getRequestDispatcher("/views/user/list.jsp").forward(req,resp);
    }

    private void showFormUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/user/update.jsp").forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUser(id);
        resp.sendRedirect("/admin/users/list");
    }

    private void showFormCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/create.jsp").forward(req, resp);
    }

    private void showListUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.selectAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/views/user/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        req.setCharacterEncoding("UTF-8");
        switch (url) {
            case "/create":
                createUser(req, resp);
                break;
            case "/update":
                updateUser(req, resp);
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            userService.updateUser(user);
            resp.sendRedirect("/admin/users/list");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/admin/users/update?error=true");
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");
        if (userService.emailExists(email)) {
            req.setAttribute("existsEmail", "Email đã tồn tại!!!");
            req.getRequestDispatcher("/views/user/create.jsp").forward(req, resp);
        } else {
             if (password.equals(rePassword)){
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                userService.createUser(user);
                resp.sendRedirect("/admin/users/list");
            } else {
                req.setAttribute("errorPassword", "Mật khẩu không khớp!!!");
                req.getRequestDispatcher("/views/user/create.jsp").forward(req, resp);
            }
        }

    }
}
