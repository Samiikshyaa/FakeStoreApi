package com.example.fakeapi.controller;

import com.example.fakeapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
    @Autowired
    private ProductRepository productrepo;

    @GetMapping("/")
    public String getIndex(){
        return "Index";
    }

    @GetMapping("/product/gallery")
    public String getGallery(Model model){
        model.addAttribute("plist",productrepo.findAll());
        return "ProductGallery";
    }

}
