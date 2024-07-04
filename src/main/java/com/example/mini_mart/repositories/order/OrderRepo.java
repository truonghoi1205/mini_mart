package com.example.mini_mart.repositories.order;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.Order;
import com.example.mini_mart.models.dto.OrderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo implements IOrderRepo {
    @Override
    public List<OrderDTO> selectAll() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select a.id as addressId, concat(last_name,' ',fisrt_name) as nameAddress, a.address,a.email,a.phone as phoneNumber,o.id,o.number,o.total \n" +
                "from orders o \n" +
                "join addresses a \n" +
                "on a.order_id = o.id";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            OrderDTO order = new OrderDTO();
            order.setId(rs.getInt("id"));
            order.setName(rs.getString("nameAddress"));
            order.setAddress(rs.getString("address"));
            order.setEmail(rs.getString("email"));
            order.setPhone(rs.getString("phoneNumber"));
            order.setAddressId(rs.getInt("addressId"));
            order.setNumber(rs.getString("number"));
            order.setTotal(rs.getDouble("total"));
            orders.add(order);
        }
        return orders;
    }
}
