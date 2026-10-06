package com.budiluhur.catalog.repository;

import com.budiluhur.catalog.model.Product;
import com.budiluhur.catalog.exception.ProductNotFoundException;
import java.util.*;

public class ProductRepository {
    
    private List<Product> productList = new ArrayList<>();

    // Method untuk menambah produk
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Method yang hilang: Mengembalikan seluruh daftar produk
    public List<Product> getAllProducts() {
        return productList;
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(String id) throws ProductNotFoundException {
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Produk dengan ID '" + id + "' tidak ditemukan!"
        );
    }
}