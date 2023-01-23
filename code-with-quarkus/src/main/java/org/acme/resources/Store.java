package org.acme.resources;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class Store extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

   @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
   @JoinTable(name = "store_to_product",
           joinColumns = {@JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "store_id_fk"))}
          ,inverseJoinColumns = {@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_id_fk"))})
    private List<Product> products;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Product> getProducts() {
       return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
