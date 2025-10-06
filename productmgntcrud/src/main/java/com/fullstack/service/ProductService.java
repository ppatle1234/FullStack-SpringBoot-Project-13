package com.fullstack.service;

import com.fullstack.entity.Product;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(long productId) {
        return Optional.ofNullable(productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product ID Does Not Exist.")));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public Product update(long productId, Product product) {

        Product product1 = findById(productId).get();
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductLaunchDate(product.getProductLaunchDate());
        return productRepository.save(product1);
    }

    @Override
    public void deleteById(long productId) {
        productRepository.deleteById(productId);
    }
}
