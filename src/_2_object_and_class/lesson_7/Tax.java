package _2_object_and_class.lesson_7;

import static _2_object_and_class.lesson_7.Product.*;

public class Tax {
    public static void main(String[] args) {
        initDB();

        for (Product pr : getProducts()) {
            if (pr.getPrice() > 10000) continue;
            System.out.println(pr + "\nTax: " + calculateTax(pr));
        }
    }
}

class Product {
    private String name;
    private Double price;
    private static Product[] products = new Product[5];

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public static Product[] getProducts() {
        return products;
    }

    public static void initDB() {
        products[0] = new Product("Холодильник", 9500.7);
        products[1] = new Product("Телевизор", 23999.0);
        products[2] = new Product("Микроволновая печь", 650.5);
        products[3] = new Product("Пылесос", -111.0);
        products[4] = new Product("Утюг", 55.0);
    }

    public static Double calculateTax(Product pr) {
            if (pr.getPrice() < 0) {
                throw new RuntimeException("Price is negative");
            }
            if (pr.getPrice() > 0 && pr.getPrice() < 100) {
                return pr.getPrice() * 0.1;
            } else if (pr.getPrice() >= 100 && pr.getPrice() < 1000) {
                return pr.getPrice() * 0.2;
            } else if (pr.getPrice() >= 1000 && pr.getPrice() < 10000) {
                return pr.getPrice() * 0.3;
            }
    return 0.0;
    }

    public String toString() {
        return "\nName: " + this.getName() + "\nPrice: " + this.getPrice();
    }
}