package com.f_rafael.webscrapper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiderService {
    @Autowired
    WebscrapperService webscrapperService;

    public void start(){
        String initialLink = "https://elpais.com/hemeroteca/elpais/portadas/2024/05/14/";
        getAndScrapLinks(initialLink);
    }

    public void getAndScrapLinks(String url){
        String initialLink = "https://elpais.com";
        List<String> links = webscrapperService.getAllLinks(initialLink);
        links.stream().forEach(link -> {
            webscrapperService.scrapAndSave(link);
            getAndScrapLinks(url);
        }
        );
    }
}
