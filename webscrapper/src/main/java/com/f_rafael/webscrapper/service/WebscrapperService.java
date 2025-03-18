package com.f_rafael.webscrapper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebscrapperService {

    public void scrapAndSave(String url) throws IOException {
        Document document = Jsoup.connect(url).get(); //La pagina web se almacenara en la variable document

    }
}
