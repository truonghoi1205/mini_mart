package com.example.mini_mart.models;

public class CartItem {
    private int quantity;
    private Product product;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public int getProductId() {
        return product.getId();
    }
}
