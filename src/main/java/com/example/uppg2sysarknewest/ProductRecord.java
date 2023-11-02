package com.example.uppg2sysarknewest;


import java.time.LocalDateTime;

public record ProductRecord(int id, String name, Category category , int rating, LocalDateTime createTime) {
        public ProductRecord{
            
        }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public int rating() {
        return rating;
    }

    @Override
    public LocalDateTime createTime() {
        return createTime;
    }
   
   
}