package com.example.mini_mart.services.order;

import com.example.mini_mart.models.Cart;
import com.example.mini_mart.models.Order;
import com.example.mini_mart.models.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> selectAll();
    void insertOrder(Cart cart);
}
