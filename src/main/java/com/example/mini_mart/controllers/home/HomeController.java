package com.example.mini_mart.controllers.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="HomeController",urlPatterns = {"/home","/home/thank-you"})
public class HomeController extends HttpServlet {
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
        req.getRequestDispatcher("/views/store/home.jsp").forward(req, resp);
    }
}
