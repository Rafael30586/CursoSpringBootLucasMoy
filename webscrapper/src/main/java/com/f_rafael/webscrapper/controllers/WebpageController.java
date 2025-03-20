package com.f_rafael.webscrapper.controllers;

import com.f_rafael.webscrapper.WebpageRepository;
import com.f_rafael.webscrapper.models.Webpage;
import com.f_rafael.webscrapper.services.SpiderService;
import com.f_rafael.webscrapper.services.WebscrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class WebpageController {

    @Autowired
    private WebpageRepository repository;
    @Autowired
    private WebscrapperService webscrapperService;
    @Autowired
    private SpiderService spiderService;

    @GetMapping("/search")
    public List<Webpage> search(@RequestParam("query") String query){
        List<Webpage> list = repository.findByText(query);
        //Iterable<Webpage> result = repository.findByText();

        /*for(Webpage webpage : result){
            list.add(webpage);
        }*/
        return list;
    }

    @GetMapping("/webscrapper")
    public void scrapAndSave(@RequestParam("url") String url) throws IOException {
        webscrapperService.scrapAndSave(url);

    }

    @GetMapping("/start")
    public void scrapAndSave() throws IOException {
        spiderService.start();
    }


}
