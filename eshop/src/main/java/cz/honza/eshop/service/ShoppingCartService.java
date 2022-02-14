package cz.honza.eshop.service;

import cz.honza.eshop.entyty.Product;

import java.util.Map;

public interface ShoppingCartService {

    void add(Long id);

    void remove(Long id);

    Map<Product, Integer> getCart();

    void checkout();

    Integer totalPrice();
}
