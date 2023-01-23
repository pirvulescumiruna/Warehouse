package org.acme.resources;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends PanacheEntityBase {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
