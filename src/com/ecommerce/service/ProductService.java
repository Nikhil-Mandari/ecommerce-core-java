package com.ecommerce.service;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import java.util.List;

public class ProductService {

    private ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // GET by id
    public Product getById(int id) {
        return repo.getById(id);
    }
    // ADDING PRODUCTS
    public Product addProduct(Product product) {
        repo.addProduct(product);
        return product;
    }

    //DICOUNT
   public void applyDiscount(int id,double discount){
        if (discount < 0 || discount > 100) {
            System.out.println("invailid discount");
            return;
        }
       Product p = repo.getById(id);
       if (p == null) {
           System.out.println("Product not found");
           return;
       }
       repo.updateDiscount(id, discount);
   }
    // UPDATE
    public Product update(int id, Product newproduct) {
        Product existing = repo.getById(id);

        if (existing != null) {
            existing.setName(newproduct.getName());
            existing.setMaxRetailPrice(newproduct.getMaxRetailPrice());
            existing.setDiscountPercentage(newproduct.getDiscountPercentage());
            existing.setRating(newproduct.getRating());
            existing.setAvailable(newproduct.isAvailable());
            return existing;
        }

        return null;
    }
    public void delete(int id) {
        repo.delete(id);
    }



}