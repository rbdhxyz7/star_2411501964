package com.budiluhur.catalog_product.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.budiluhur.catalog_product.exception.ProductNotFoundException;
import com.budiluhur.catalog_product.model.Product;
import com.budiluhur.catalog_product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produk dengan ID '" + id + "' tidak ditemukan!"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product updatedProduct) throws ProductNotFoundException {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(String id) throws ProductNotFoundException {
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }

    // Method untuk Mini Challenge
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}