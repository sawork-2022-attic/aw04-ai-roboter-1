package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PosService {

    public void checkout(Cart cart);

    public Cart add(Cart cart, Product product, int amount);

    public Cart add(Cart cart, Long productId, int amount);

    public List<Product> products();

    public Product randomProduct();

    public List<Product> getProductByPage(Pageable pageable);
}
