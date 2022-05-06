package com.example.webpos.biz;

import com.example.webpos.db.AmazonDB;
import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PosServiceImp implements PosService, Serializable {

    private AmazonDB amazonDB;

    @Autowired
    public void setAmazonDB(AmazonDB amazonDB) {
        this.amazonDB = amazonDB;
    }

    @Override
    public Product randomProduct() {
        return products().get(ThreadLocalRandom.current().nextInt(0, products().size()));
    }

    @Override
    public void checkout(Cart cart) {

    }

    @Override
    public Cart add(Cart cart, Product product, int amount) {
        return add(cart, product.getId(), amount);
    }

    @Override
    public Cart add(Cart cart, Long productId, int amount) {

        var  product = amazonDB.findById(productId);
        if (product.isEmpty()) return cart;

        cart.addItem(new Item(product.get(), amount));
        return cart;
    }

    @Override
    public List<Product> products() {
        // 默认返回前20个
        System.out.println("get products");
        return amazonDB.findAll(PageRequest.of(1, 20)).getContent();
    }

    @Override
    public List<Product> getProductByPage(Pageable pageable) {
        return amazonDB.findAll(pageable).getContent();
    }
}
