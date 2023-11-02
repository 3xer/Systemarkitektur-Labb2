package com.example.uppg2sysarknewest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
public class WarehouseService {
    private final CopyOnWriteArrayList<Product> productList = new CopyOnWriteArrayList<>();

    //constructor
    public WarehouseService(){

    }
    public synchronized Product addProduct(Product p){
        if(p.hasName()){
            productList.add(p);
            System.out.println(p.getName()+ "\nproduct added ");
            System.out.println(productList.size());
            return p;
        }
        else{
            System.out.println("product has no name");
            return null;
        }
    }
    public synchronized ProductRecord getProduct(int id) throws NoSuchElementException {
        return productList.stream().filter(p -> p.getId() == id).findFirst().orElseThrow(NoSuchElementException::new).productRecord();
    }
    public synchronized List<ProductRecord> getProductByCategory(Category category) {
        return productList.stream().filter(p -> p.getCategory() == category).sorted(
                Comparator.comparing(Product::getCategory)).map(Product::productRecord).toList();
    }
    public synchronized List<ProductRecord> getModified() {
        return productList.stream().filter(Product::isModified).map(Product::productRecord).toList();
    }
    public synchronized List<ProductRecord> getCreated(LocalDateTime time) {
        return productList.stream().filter(p -> p.getCreateTime().isAfter(time)).map(Product::productRecord).toList();
    }
    public synchronized List<ProductRecord> getAll() {
        return productList.stream().map(Product::productRecord).toList();
    }
}