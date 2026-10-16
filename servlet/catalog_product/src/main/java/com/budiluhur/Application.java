package com.budiluhur.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.budiluhur.catalog.model.Product;
import com.budiluhur.catalog.service.ProductService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductService productService) {
        return args -> {
            System.out.println("=== SPRING BOOT PRODUCT CATALOG IS RUNNING ===");

            productService.createProduct(new Product("PRD-03", "Monitor Gaming 24 Inch", 2100000.0));

            System.out.println("\nDaftar Produk di Spring Container:");
            productService.getAllProducts().forEach(p -> 
                System.out.println("[" + p.getId() + "] " + p.getName() + " - Rp" + p.getPrice())
            );

            double discountedPrice = productService.getDiscountedProductPrice("PRD-01", 10.0);
            System.out.println("\n--- HASIL MINI CHALLENGE ---");
            System.out.println("Harga PRD-01 setelah diskon 10%: Rp" + discountedPrice);
        };
    }
}