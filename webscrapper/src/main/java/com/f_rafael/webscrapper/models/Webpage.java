package com.f_rafael.webscrapper.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "webpages")
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String domain;
    private String url;
    private String title;
    @Column(name="page_description")
    private String description;
    private String picture;
    @Column(name ="page_rank")
    private Integer pageRank; //rank es palabra reservada en mysql
}
