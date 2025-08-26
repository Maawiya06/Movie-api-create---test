package com.Movies.API.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private int id;

    private String movieName;
    private String review;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    private Author writer;

    private String mainHero;
    private String leadHeroin;

    public Movies() {}

    public Movies(int id, String movieName, String review, Author writer, String mainHero, String leadHeroin) {
        this.id = id;
        this.movieName = movieName;
        this.review = review;
        this.writer = writer;
        this.mainHero = mainHero;
        this.leadHeroin = leadHeroin;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public Author getWriter() { return writer; }
    public void setWriter(Author writer) { this.writer = writer; }

    public String getMainHero() { return mainHero; }
    public void setMainHero(String mainHero) { this.mainHero = mainHero; }

    public String getLeadHeroin() { return leadHeroin; }
    public void setLeadHeroin(String leadHeroin) { this.leadHeroin = leadHeroin; }
}
