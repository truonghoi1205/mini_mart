package com.example.mini_mart.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private Address address;

    private HashMap<String, String> errors = new HashMap<>();

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity()).sum();
    }

    public void removeItemByProductId(int productId) {
        items.removeIf(cartItem -> cartItem.getProductId() == productId);
    }

    public CartItem findCartItemByProductId(int productId) {
        return items.stream().filter( cartItem -> cartItem.getProductId() == productId ).findFirst().orElse(null);
    }

    public void addError(String field, String message) {
        errors.put(field, message);
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void clearErrors() {
        errors.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", address=" + address +
                ", errors=" + errors +
                '}';
    }
}
