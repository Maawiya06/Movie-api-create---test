package com.Movies.API.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Movies {

    private int id;
    private String Reviews;
    private String Director;
    private String Main_Cast;
    private String LeadHeroin;

    public Movies(int id, String reviews, String director, String main_Cast, String leadHeroin) {
        this.id = id;
        Reviews = reviews;
        Director = director;
        Main_Cast = main_Cast;
        LeadHeroin = leadHeroin;
    }

    public Movies() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviews() {
        return Reviews;
    }

    public void setReviews(String reviews) {
        Reviews = reviews;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getMain_Cast() {
        return Main_Cast;
    }

    public void setMain_Cast(String main_Cast) {
        Main_Cast = main_Cast;
    }

    public String getLeadHeroin() {
        return LeadHeroin;
    }

    public void setLeadHeroin(String leadHeroin) {
        LeadHeroin = leadHeroin;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", Reviews='" + Reviews + '\'' +
                ", Director='" + Director + '\'' +
                ", Main_Cast='" + Main_Cast + '\'' +
                ", LeadHeroin='" + LeadHeroin + '\'' +
                '}';
    }
}
