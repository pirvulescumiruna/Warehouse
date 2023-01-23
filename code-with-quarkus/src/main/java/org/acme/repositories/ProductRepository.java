package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.resources.Product;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}
