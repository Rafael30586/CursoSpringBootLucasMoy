package com.f_rafael.webscrapper.services;

import com.f_rafael.webscrapper.WebpageRepository;
import com.f_rafael.webscrapper.models.Webpage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebscrapperService {
    @Autowired
    private WebpageRepository repository;

    public void scrapAndSave(String url) {
        try{
            Document document = Jsoup.connect(url).get(); //La pagina web se almacenara en la variable document
            String domain = getDomainFromUrl(url);
            String title = document.title(); //guarda el titulo de la pagina web
            String description = document.select("meta[name=description]")
                    .attr("content"); //Extrae informacion del head de la pagina web, meta es una etiqueta y...
            //...content es un atributo
            String picture = document.select("meta[property=og:image]")
                    .attr("content");

            Webpage webpage = new Webpage();
            webpage.setTitle(title);
            webpage.setDescription(description);
            webpage.setPicture(picture);
            webpage.setDomain(domain);
            webpage.setUrl(url);

            repository.save(webpage);

        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }

    private String getDomainFromUrl(String url){
        String domain = url.replaceFirst("^(https?://)?(www\\.)?","");
        int index = domain.indexOf('/');
        if(index!=-1){
            domain = domain.substring(0,index);
        }
        return domain;
    }

    public List<String> getAllLinks(String url) {
        Webpage findWebpage = repository.findByUrl(url);
        if (findWebpage != null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList();
        try{
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            links.stream().parallel().forEach(link -> {
                String linkHref = link.attr("href");
                if (linkHref.startsWith("/")) {
                    linkHref = "https://" + getDomainFromUrl(url) + linkHref;
                }
                if (!result.contains(linkHref)) {
                    result.add(linkHref);
                }
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return result;
    }
}
