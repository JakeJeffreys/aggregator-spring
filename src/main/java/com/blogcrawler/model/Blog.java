package com.blogcrawler.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Blog {

    @Id
    private long id;

    private String category;
    private String website;
    private String author;
    private String url;

    private String date1;
    private String article1;
    private String link1;

    private String date2;
    private String article2;
    private String link2;

    private String date3;
    private String article3;
    private String link3;

};