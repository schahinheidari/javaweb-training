package com.javaweb.entity;

public class Product {
    Integer id;
    String name;
    String model;
    String factory;

    public Product(Integer id, String name, String model, String factory) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.factory = factory;
    }

    public Product(String name, String model, String factory) {
        this.name = name;
        this.model = model;
        this.factory = factory;
    }
    public Product(Integer id) {
        this.id = id;
    }

    public Product() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
