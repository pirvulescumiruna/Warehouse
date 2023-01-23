package org.acme.controllers;

import org.acme.resources.Product;
import org.acme.services.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product insertProduct(Product product){
        productService.add(product);
         return product;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public boolean deleteProduct(Long id){
         return productService.delete(id);
    }


}