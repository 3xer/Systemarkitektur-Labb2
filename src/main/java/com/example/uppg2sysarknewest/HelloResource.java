package com.example.uppg2sysarknewest;

import jakarta.inject.Inject;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("")
public class HelloResource {
    @Inject
    private WarehouseService w;

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    public Product addResource(@Valid Product product) {
        product.setCreateTime(LocalDateTime.now());
        return w.addProduct(product);
    }
    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductRecord> getResources(){
        System.out.println(w.getAll());
        return w.getAll();
    }
    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductRecord getResourceById(
            @PathParam("id") int id){
        return w.getProduct(id);
    }
    @GET
    @Path("/products/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductRecord> getResourceByCategory(
            @PathParam("category") Category category) {
        return w.getProductByCategory(category);
    }

}
    //http://localhost:11160/uppg2SysarkNewest-1.0-SNAPSHOT/api/product?id=1&name=product&category=Category.Big&rating=5
/*
    @GET
    @Path("/getProductById")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductRecord getResourceById(
            @QueryParam("id") int id){
        return w.getProduct(id);
    }
    @GET
    @Path("/getAllProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductRecord> getResources(){
        System.out.println(w.getAll());
        return w.getAll();
    }
    @GET
    @Path("/getProductByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductRecord> getResourceByCategory(
            @QueryParam("category") Category category){
        return w.getProductByCategory(category);
    }
    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByNameAndAge(){
        return new Person("test", 1);
    }
    public class Person {
        String name;
        int age;
        public Person() {
        }
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
*/