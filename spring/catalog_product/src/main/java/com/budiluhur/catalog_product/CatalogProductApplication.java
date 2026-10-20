package com.budiluhur.catalog_product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.budiluhur.catalog_product.model.Product;
import com.budiluhur.catalog_product.repository.ProductRepository;

@SpringBootApplication
public class CatalogProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductRepository repository) {
        return args -> {
            repository.save(new Product("PRD-01", "Keyboard Mechanical", 450000.0));
            repository.save(new Product("PRD-02", "Mouse Wireless Silent", 175000.0));
            System.out.println("Data awal berhasil disimpan ke database H2!");
        };
    }
}