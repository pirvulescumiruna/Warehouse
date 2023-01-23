package org.acme.services;

import org.acme.repositories.ProductRepository;
import org.acme.repositories.StoreRepository;
import org.acme.resources.Product;
import org.acme.resources.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Inject
    StoreRepository storeRepository;

    public List<Product> getAllProducts() {

        return productRepository.listAll();
    }

    public Product add(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product update(Product product) {
        Product productToUpdate = new Product();
        try {productToUpdate = productToUpdate.findById(product.getId());
            System.out.println(productToUpdate);
            productToUpdate.setName(product.getName());
            productToUpdate.persist(productToUpdate);
        }
        catch (NullPointerException e) {

        }

        return productToUpdate;

    }
    public boolean delete(Long id) {
        return productRepository.deleteById(id);
    }


}

