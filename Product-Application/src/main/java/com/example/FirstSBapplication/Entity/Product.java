package com.example.FirstSBapplication.Entity;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Data
@Table(name = "PRODUCT_TABLE")
@Entity
public class Product {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
}
