package com.example.fakeapi.controller;

import com.example.fakeapi.model.Product;
import com.example.fakeapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/load")
    public String loadProduct(){
        RestTemplate temp = new RestTemplate();
        Product[] prod = temp.getForObject("https://fakestoreapi.com/products", Product[].class);

        productRepository.saveAll(Arrays.asList(prod));
        return "Success";
    }



}
