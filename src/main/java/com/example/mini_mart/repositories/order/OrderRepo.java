package com.example.mini_mart.repositories.order;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.Cart;
import com.example.mini_mart.models.CartItem;
import com.example.mini_mart.models.Order;
import com.example.mini_mart.models.dto.OrderDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public void insertOrder(Cart cart) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String number = randomNumber();
        String orderSql = "insert into orders(number, total) value(?,?)";
        PreparedStatement orderPs = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
        orderPs.setString(1, number);
        orderPs.setDouble(2, cart.getTotalPrice());
        orderPs.executeUpdate();
        ResultSet orderGenerateKeys = orderPs.getGeneratedKeys();
        int orderId = 0;
        if (orderGenerateKeys.next()) {
            orderId = orderGenerateKeys.getInt(1);
        }

        String addressSql = "insert into addresses(name, address, email, phone_number, order_id) value(?,?,?,?,?)";
        PreparedStatement addressPs = connection.prepareStatement(addressSql);
        addressPs.setString(1, cart.getAddress().getName());
        addressPs.setString(2, cart.getAddress().getAddress());
        addressPs.setString(3, cart.getAddress().getEmail());
        addressPs.setString(4, cart.getAddress().getPhoneNumber());
        addressPs.setInt(5, orderId);
        addressPs.executeUpdate();

        String orderItemSql = "insert into order_items(product_id, quaitity, price, order_id) value(?,?,?,?)";
        PreparedStatement orderItemPs = connection.prepareStatement(orderItemSql);
        for (CartItem item : cart.getItems()) {
            orderItemPs.setInt(1, item.getProduct().getId());
            orderItemPs.setInt(2, item.getQuantity());
            orderItemPs.setDouble(3, item.getProduct().getPrice());
            orderItemPs.setInt(4, orderId);
            orderItemPs.executeUpdate();
        }

        connection.close();
    }

    private String randomNumber() {
        Random r = new Random(System.currentTimeMillis());
        int n = 10000 + r.nextInt(20000);
        return "O-" + n;
    }
}
