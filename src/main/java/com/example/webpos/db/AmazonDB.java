package com.example.webpos.db;

import com.example.webpos.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AmazonDB extends PagingAndSortingRepository<Product, Long> {

}
