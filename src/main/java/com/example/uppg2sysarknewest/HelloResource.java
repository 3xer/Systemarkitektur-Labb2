package com.example.uppg2sysarknewest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDateTime;
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
