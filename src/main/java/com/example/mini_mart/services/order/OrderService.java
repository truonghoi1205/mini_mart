package com.example.mini_mart.services.order;

import com.example.mini_mart.models.Order;
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
}
