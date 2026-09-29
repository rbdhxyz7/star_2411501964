package com.budiluhur;

public class Application {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" SISTEM KATALOG PRODUK ENTERPRISE v1.0 ");
        System.out.println("=========================================");

        String productName = "Mouse Wireless Silent";
        double unitPrice = 175000.0;
        int stockQuantity = 12;

        printProductDetails(productName, unitPrice, stockQuantity);

        boolean isAvailable = checkStockStatus(stockQuantity);
        System.out.println("Status Ketersediaan: " + (isAvailable ? "Tersedia" : "Stok Habis"));
    
        System.out.println("\n-----------------------------------------");
        System.out.println(" SIMULASI PEMBELIAN");
        System.out.println("-----------------------------------------");

        String itemToBuy = "Keyboard Mechanical";
        double keyboardPrice = 450000.0;
        int quantityToBuy = 4;

        double totalPrice = calculateTotalPrice(quantityToBuy, keyboardPrice);

        System.out.println("Produk Dibelii : " + itemToBuy);
        System.out.println("Jumlah Pembelian : " + quantityToBuy + " unit");
        System.out.println("Harga Satuan     : Rp" + keyboardPrice);
        System.out.println("Total Pembayaran : Rp" + totalPrice);
        System.out.println("-----------------------------------------");
    }

    public static void printProductDetails(String name, double price, int stock) {
        System.out.println("Nama Produk : " + name);
        System.out.println("Harga Satuan: Rp" + price);
        System.out.println("Jumlah Stok : " + stock + " unit");
    }

    public static boolean checkStockStatus(int stock) {
        return stock > 0;
    }

    public static double calculateTotalPrice(int quantity, double price) {
        return quantity * price;
    }
}