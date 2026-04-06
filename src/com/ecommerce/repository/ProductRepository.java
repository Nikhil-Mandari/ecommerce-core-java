package com.ecommerce.repository;
import com.ecommerce.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductRepository {
    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        initialProducts();
    }

    private void initialProducts() {

        Product p1 = new Product()
                .setId(1).setName("Laptop")
                .setMaxRetailPrice(80000)
                .setDiscountPercentage(10.5f)
                .setRating(5)
                .setAvailable(true);

        Product p2 = new Product()
                .setId(2).setName("Smartphone")
                .setMaxRetailPrice(25000)
                .setDiscountPercentage(15.0f)
                .setRating(4)
                .setAvailable(true);

        Product p3 = new Product()
                .setId(3)
                .setName("Headphones")
                .setMaxRetailPrice(3000)
                .setDiscountPercentage(20.0f)
                .setRating(4).
                setAvailable(true);

        Product p4 = new Product()
                .setId(4)
                .setName("Smartwatch")
                .setMaxRetailPrice(7000)
                .setDiscountPercentage(18.0f)
                .setRating(3)
                .setAvailable(false);

        Product p5 = new Product()
                .setId(5)
                .setName("Tablet")
                .setMaxRetailPrice(20000)
                .setDiscountPercentage(12.5f)
                .setRating(4).
                setAvailable(true);

        Product p6 = new Product()
                .setId(6)
                .setName("Bluetooth Speaker")
                .setMaxRetailPrice(4000)
                .setDiscountPercentage(25.0f)
                .setRating(5)
                .setAvailable(true);

        Product p7 = new Product()
                .setId(7)
                .setName("Keyboard")
                .setMaxRetailPrice(1500)
                .setDiscountPercentage(10.0f)
                .setRating(3)
                .setAvailable(true);

        Product p8 = new Product()
                .setId(8)
                .setName("Mouse")
                .setMaxRetailPrice(800)
                .setDiscountPercentage(5.0f)
                .setRating(4)
                .setAvailable(true);

        Product p9 = new Product()
                .setId(9)
                .setName("Monitor")
                .setMaxRetailPrice(12000)
                .setDiscountPercentage(8.0f)
                .setRating(5)
                .setAvailable(false);

        Product p10 = new Product()
                .setId(10)
                .setName("Printer")
                .setMaxRetailPrice(9000)
                .setDiscountPercentage(22.0f)
                .setRating(3)
                .setAvailable(true);

        // ✅ Add to list
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);
        products.add(p10);
    }

    // ✅ Getter method
    public List<Product> getAllProducts() {
        return products;
    }
    //get by id
    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;

    }
    //add product
    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateDiscount(int id, double discountPercentage) {
        Product p = getById(id);
        if (p != null) {
            p.setDiscountPercentage((float) discountPercentage);
        }
    }

    // Update price
    public void updatePrice(int id, int newPrice) {
        Product p = getById(id);
        if (p != null) {
            p.setMaxRetailPrice(newPrice) ;
        }
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}


