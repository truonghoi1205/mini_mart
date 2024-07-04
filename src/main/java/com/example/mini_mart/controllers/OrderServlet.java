package com.example.mini_mart.controllers;

import com.example.mini_mart.models.Order;
import com.example.mini_mart.models.dto.OrderDTO;
import com.example.mini_mart.services.order.IOrderService;
import com.example.mini_mart.services.order.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/home/orders/*")
public class OrderServlet extends HttpServlet {
    private static IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showAll(req, resp);
                break;
        }
    }

    private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDTO> orders = orderService.selectAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/views/order/list.jsp").forward(req, resp);
    }
}
