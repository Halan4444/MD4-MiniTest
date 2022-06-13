package com.codegym.cms.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @OneToMany(mappedBy = "category")
//    private Set<Product> productsSet;


    public Category(String name) {

        this.name = name;
    }

    public Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Product> getProductsSet() {
//        return productsSet;
//    }
//
//    public void setProductsSet(Set<Product> productsSet) {
//        this.productsSet = productsSet;
//    }
}
