package com.f_rafael.webscrapper.controllers;

import com.f_rafael.webscrapper.WebpageRepository;
import com.f_rafael.webscrapper.models.Webpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebpageController {

    @Autowired
    private WebpageRepository repository;

    @GetMapping("/api/search")
    public List<Webpage> search(@RequestParam("query") String query){
        List<Webpage> list = repository.findByText(query);
        //Iterable<Webpage> result = repository.findByText();

        /*for(Webpage webpage : result){
            list.add(webpage);
        }*/
        return list;
    }
}
