package com.zynb.vo;

import com.zynb.domain.Product;
import com.zynb.domain.User;

public class PUVO {

    private Product product;
    private User user;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PUVO{" +
                "product=" + product +
                ", user=" + user +
                '}';
    }
}
