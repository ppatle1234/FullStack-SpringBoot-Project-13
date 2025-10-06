package com.fullstack.service;

import com.fullstack.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product save(Product product);

    Optional<Product> findById(long productId);

    List<Product> findAll();

    List<Product> findByName(String productName);

    Product update(long productId, Product product);

    void deleteById(long productId);

}
