package com.example.fakeapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;

    @Column(columnDefinition = "longtext")
    private String description;
    private String category;
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating")
    private Rating rating;

}
