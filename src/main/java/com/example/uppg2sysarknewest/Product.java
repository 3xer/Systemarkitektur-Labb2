package com.example.uppg2sysarknewest;
import jakarta.ejb.Local;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Product {
    @NotNull(message = "cant be null")
    @Min(value = 0, message= "has to be more than 0")
    private  int id;
    @NotNull(message = "cant be null")
    private  String name;
    @NotNull(message = "cant be null")
    private Category category;
    @NotNull(message = "cant be null")
    @Min(value = 0, message= "has to be more than 0")
    @Max(value = 10, message= "has to be less than 11")
    private int rating;
    private LocalDateTime createTime;
    private LocalDateTime latestModified;
    //constructor
    public Product(int id, String name, Category category ,int rating, LocalDateTime createTime){
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createTime = createTime;
        this.latestModified = createTime;
    }
    @JsonbCreator
    public Product( @JsonbProperty("id") int id,
                    @JsonbProperty("name") String name,
                    @JsonbProperty("category") Category category,
                    @JsonbProperty("rating") int rating
                    ){
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
    }
    //---getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Category getCategory() {
        return category;
    }
    public int getRating() {
        return rating;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    //---setters
    public void setId (int id){
        this.id = id;
        latestModified = LocalDateTime.now();
    }
    public void setName (String name){
        this.name = name;
        latestModified = LocalDateTime.now();
    }
    public void setCategory (Category category){
        this.category = category ;
        latestModified = LocalDateTime.now();
    }
    public void setRating (int rating){
        this.rating = rating ;
        latestModified = LocalDateTime.now();
    }
    public void setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
        latestModified = LocalDateTime.now();
    }

    public boolean isModified(){
        return !createTime.equals(latestModified);
    }

    public boolean hasName (){
        return !name.isEmpty();
    }
    public ProductRecord productRecord (){
        return new ProductRecord(id, name, category ,rating, createTime);
    }

}