package com.ecommerce.main;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;

import java.security.Provider;
import java.util.List;

public class Main {
    static void main(String[] args) {


        ProductRepository repo = new ProductRepository();
        ProductService service = new ProductService(repo);

        //1.show all products
        System.out.println("\nAll products :");
        for (Product p : repo.getAllProducts()) {
            System.out.println(p);

        }

        //2.GET BY ID
        System.out.println("\n GET BY ID ::");
        Product p  = service.getById(1);
        if (p != null){
            System.out.println(p);
        }else {
            System.out.println("not found");
        }

        //3. Apply discount
        System.out.println("\nApply discount");
        service.applyDiscount(2,50);
        System.out.println(service.getById(2));

        //4.add product
        System.out.println("\nAdding new product :..");
        Product newProduct = new Product()
                .setId(11)
                .setName("CAR")
                .setDiscountPercentage(50)
                .setMaxRetailPrice(50000)
                .setAvailable(true)
                .setRating(4);
        service.addProduct(newProduct);

            for (Product product : repo.getAllProducts()) {
                System.out.println(product);
            }
        //5.Update product
        System.out.println("\n update new product");
        Product P = new Product()
                .setId(3)
                .setName("BIKE")
                .setMaxRetailPrice(12000)
                .setDiscountPercentage(25)
                .setRating(3)
                .setAvailable(true);

        service.update(3, P);
        service.getById(3);
        for (Product product1 : repo.getAllProducts()) {
            System.out.println(product1);}

        // 6. Delete product
        System.out.println("\nDeleting product ID 3...");
        service.delete(3);
      ;
        System.out.println("\nFinal Product List:");
        for (Product list : repo.getAllProducts()) {
            System.out.println(list);
        }
    }


    }




