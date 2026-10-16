package com.budiluhur.catalog_product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.budiluhur.catalog_product.model.Product;
import com.budiluhur.catalog_product.service.ProductService;

@SpringBootApplication
public class CatalogProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductService productService) {
        return args -> {
            System.out.println("=== SPRING BOOT PRODUCT CATALOG IS RUNNING ===");

            // 1. Tambah produk baru PRD-03
            productService.createProduct(new Product("PRD-03", "Monitor Gaming 24 Inch", 2100000.0));

            // 2. Cetak daftar produk
            System.out.println("\nDaftar Produk di Spring Container:");
            productService.getAllProducts().forEach(p -> 
                System.out.println("[" + p.getId() + "] " + p.getName() + " - Rp" + p.getPrice())
            );

            // 3. Output Informasi Harga & Diskon sesuai slide terbaru
            System.out.println("\n=== INFORMASI HARGA & DISKON ===");

            // PRD-01 (Ada Diskon 10%)
            Product p1 = productService.getProductById("PRD-01");
            double disc1 = 10.0;
            double finalPrice1 = productService.getDiscountedProductPrice("PRD-01", disc1);
            
            System.out.println("[" + p1.getId() + "] " + p1.getName());
            System.out.printf("  Harga Normal: Rp%,.2f\n", p1.getPrice());
            System.out.println("  Diskon      : " + disc1 + "% (Ada Diskon)");
            System.out.printf("  Harga Akhir : Rp%,.2f\n\n", finalPrice1);

            // PRD-02 (Tidak Ada Diskon / 0%)
            Product p2 = productService.getProductById("PRD-02");
            double disc2 = 0.0;
            double finalPrice2 = productService.getDiscountedProductPrice("PRD-02", disc2);

            System.out.println("[" + p2.getId() + "] " + p2.getName());
            System.out.printf("  Harga Normal: Rp%,.2f\n", p2.getPrice());
            System.out.println("  Diskon      : " + (int)disc2 + "% (Tidak Ada Diskon)");
            System.out.printf("  Harga Akhir : Rp%,.2f\n", finalPrice2);
        };
    }
}