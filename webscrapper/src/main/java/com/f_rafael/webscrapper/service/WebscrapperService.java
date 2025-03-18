package com.f_rafael.webscrapper.service;

import com.f_rafael.webscrapper.WebpageRepository;
import com.f_rafael.webscrapper.models.Webpage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebscrapperService {
    @Autowired
    private WebpageRepository repository;

    public void scrapAndSave(String url) throws IOException {
        Document document = Jsoup.connect(url).get(); //La pagina web se almacenara en la variable document
        String domain = getDomainFromUrl(url);
        String title = document.title(); //guarda el titulo de la pagina web
        String description = document.select("meta[name=description]")
                .attr("content"); //Extrae informacion del head de la pagina web, meta es una etiqueta y...
                //...content es un atributo
        String picture = document.select("meta[name=image]")
                .attr("content");

        Webpage webpage = new Webpage();
        webpage.setTitle(title);
        webpage.setDescription(description);
        webpage.setPicture(picture);
        webpage.setDomain(domain);

        repository.save(webpage);

    }

    private String getDomainFromUrl(String url){
        String domain = url.replaceFirst("^(http?://)?(www\\.)?","");
        int index = domain.indexOf('/');
        if(index!=-1){
            domain = domain.substring(0,index);
        }
        return domain;
    }
}
