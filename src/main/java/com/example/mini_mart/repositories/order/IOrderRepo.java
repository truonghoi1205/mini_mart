package com.example.mini_mart.repositories.order;

import com.example.mini_mart.models.Order;
import com.example.mini_mart.models.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepo {
    List<OrderDTO> selectAll() throws SQLException;
}
