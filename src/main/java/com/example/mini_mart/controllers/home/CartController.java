package com.example.mini_mart.controllers.home;

import com.example.mini_mart.models.Address;
import com.example.mini_mart.models.Cart;
import com.example.mini_mart.models.CartItem;
import com.example.mini_mart.models.Product;
import com.example.mini_mart.services.order.IOrderService;
import com.example.mini_mart.services.order.OrderService;
import com.example.mini_mart.services.product.IProductService;
import com.example.mini_mart.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartController", urlPatterns = "/home/cart/*")
public class CartController extends HttpServlet {
    private static IOrderService orderService = new OrderService();
    private static IProductService productService = new ProductService();

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String url = req.getRequestURI();
        System.out.println(url);
        switch (url) {
            case "/home/cart/show":
                showCart(req, resp);
                break;
            case "/home/cart/remove":
                removeCart(req, resp);
                break;
            case "/home/cart/update":
                updateCart(req, resp);
                break;
            case "/home/cart/checkout":
                showFormCheckout(req, resp);
                break;
            case "/home/cart/add":
                addCart(req, resp);
                break;
            default:
                req.getRequestDispatcher("/views/store/404error.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address();
        address.setName(req.getParameter("name"));
        address.setAddress(req.getParameter("address"));
        address.setEmail(req.getParameter("email"));
        address.setPhoneNumber(req.getParameter("phone"));
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clearErrors();
        cart.setAddress(address);
        orderService.insertOrder(cart);
        if (cart.getErrors().isEmpty()) {
            session.removeAttribute("cart");
            resp.sendRedirect("/home/thank-you");
        } else {
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/views/store/check-out.jsp").forward(req, resp);
        }
    }

    private void showFormCheckout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("/home/cart/show");
        }
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/views/store/check-out.jsp").forward(req, resp);
    }

    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int productId = Integer.parseInt(req.getParameter("product_id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        CartItem cartItem = cart.findCartItemByProductId(productId);
        cartItem.setQuantity(quantity);
        resp.sendRedirect("/home/cart/show");
    }

    private void removeCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int productId = Integer.parseInt(req.getParameter("product_id"));
        cart.removeItemByProductId(productId);
        resp.sendRedirect("/home/cart/show");
    }

    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        int productId = Integer.parseInt(req.getParameter("product_id"));
        Product product = productService.selectProductById(productId);
        int quantity;
        try {
            quantity = Integer.parseInt(req.getParameter("quantity"));
        } catch (NumberFormatException e) {
            quantity = 1;
        }
        CartItem cartItem = cart.findCartItemByProductId(productId);
        if (cartItem == null) {
            CartItem newItem = new CartItem(product, quantity);
            cart.addItem(newItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cart.getItems().forEach(a -> System.out.println(a.toString()));
        resp.sendRedirect("/home/cart/show");
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/views/store/cart.jsp").forward(req, resp);
    }

}
