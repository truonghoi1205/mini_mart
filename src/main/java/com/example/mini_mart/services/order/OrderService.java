package com.example.mini_mart.services.order;

import com.example.mini_mart.models.Cart;
import com.example.mini_mart.models.dto.OrderDTO;
import com.example.mini_mart.repositories.order.IOrderRepo;
import com.example.mini_mart.repositories.order.OrderRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderService{
    private static IOrderRepo orderRepo = new OrderRepo();
    @Override
    public List<OrderDTO> selectAll() {
        try {
            return orderRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void insertOrder(Cart cart) {
        validate(cart);
        if (cart.getErrors().isEmpty()) {
            try {
                orderRepo.insertOrder(cart);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void validate(Cart cart) {
        System.out.println(cart.getAddress().getName());
        if (cart.getAddress().getName().isEmpty()) {
            cart.addError("address_name", "Tên không được để trống");
        }

        if (cart.getAddress().getPhoneNumber().isEmpty()) {
            cart.addError("address_phone", "Phone không được để trống");
        }

        if (cart.getAddress().getEmail().isEmpty()) {
            cart.addError("address_email", "Email không được để trống");
        }

        if (cart.getAddress().getAddress().isEmpty()) {
            cart.addError("address_address", "Địa chỉ không được để trống");
        }
    }
}
