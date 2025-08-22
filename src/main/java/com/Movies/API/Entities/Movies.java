package com.Movies.API.Entities;

import jakarta.persistence.Entity;

@Entity
public class Movies {

    private int id;
    private String MovieName;
    private String Review;
    private String Writer;
    private String MainHero;
    private String LeadHeroin;

    public Movies(int id, String movieName, String review, String writer, String mainHero, String leadHeroin) {
        this.id = id;
        MovieName = movieName;
        Review = review;
        Writer = writer;
        MainHero = mainHero;
        LeadHeroin = leadHeroin;
    }

    public Movies(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getMainHero() {
        return MainHero;
    }

    public void setMainHero(String mainHero) {
        MainHero = mainHero;
    }

    public String getLeadHeroin() {
        return LeadHeroin;
    }

    public void setLeadHeroin(String leadHeroin) {
        LeadHeroin = leadHeroin;
    }


}
